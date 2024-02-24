package flashcards;

import flashcards.command.*;
import flashcards.log.Logger;

import java.util.*;

public class Main {
    public static final String IMPORT_FILE_NAME_PARAM = "importFilename";
    public static final String EXPORT_FILE_NAME_PARAM = "exportFilename";
    private static final String MENU_MESSAGE =
            "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):";
    private static final Logger LOGGER = Logger.getDefault();

    public static void main(String[] args) {
        Map<String, String> params = parseParams(args);


        var scanner = new Scanner(System.in);
        var cardStorage = new HashMapCardStorage();
        CardFilePorter importer = new CardFileImporter(cardStorage, LOGGER);
        CardFilePorter exporter = new CardFileExporter(cardStorage, LOGGER);
        var commandFactory = CommandFactory.getDefaultFactory(cardStorage, scanner, LOGGER, importer, exporter);

        if (params.containsKey(IMPORT_FILE_NAME_PARAM)) {
            importer.portData(params.get(IMPORT_FILE_NAME_PARAM));
        }

        try {
            while (true) {
                LOGGER.println(MENU_MESSAGE);
                String inputCommand = LOGGER.saveln(scanner.nextLine()).replaceAll(" ", "_");
                Command command = commandFactory.buildCommand(CommandType.valueOf(inputCommand.toUpperCase()));
                int res = command.execute();
                if (res > 0) break;
                LOGGER.println("");
            }
            if (params.containsKey(EXPORT_FILE_NAME_PARAM)) {
                exporter.portData(params.get(EXPORT_FILE_NAME_PARAM));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private static Map<String, String> parseParams(String[] args) {
        Map<String, String> params = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            String paramName = args[i];
            if (paramName.equals("-import")) {
                params.put(IMPORT_FILE_NAME_PARAM, args[i + 1]);
            } else if (paramName.equals("-export")) {
                params.put(EXPORT_FILE_NAME_PARAM, args[i + 1]);
            }
        }
        return params;
    }
}
