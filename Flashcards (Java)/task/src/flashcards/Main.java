package flashcards;

import flashcards.command.*;
import flashcards.log.Logger;

import java.util.*;

public class Main {

    private static final String MENU_MESSAGE =
            "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):";
    private static final Logger LOGGER = Logger.getDefault();

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var cardStorage = new HashMapCardStorage();
        Logger logger = Logger.getDefault();
        var commandFactory = CommandFactory.getDefaultFactory(cardStorage, scanner, logger);

        try {
            while (true) {
                logger.println(MENU_MESSAGE);
                String inputCommand = logger.saveln(scanner.nextLine()).replaceAll(" ", "_");
                Command command = commandFactory.buildCommand(CommandType.valueOf(inputCommand.toUpperCase()));
                int res = command.execute();
                if (res > 0) break;
                logger.println("");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
