package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class LogCommand extends AbstractCommand {

    protected LogCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("File name:");
        String filename = logger.saveln(scanner.nextLine());
        File logfile = new File(filename);

        try {
            writeLog(logfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.println("The log has been saved.");
        return 0;
    }

    private void writeLog(File logfile) throws IOException {
        logfile.createNewFile();
        try (var writer = new FileWriter(logfile)) {
            writer.append(logger.getLog());
            writer.flush();
        }
    }
}
