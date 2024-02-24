package flashcards.command;

import flashcards.Card;
import flashcards.CardFilePorter;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

class ExportCommand extends AbstractCommand {

    private final CardFilePorter exporter;

    protected ExportCommand(Scanner scanner, Logger logger, CardFilePorter exporter) {
        super(scanner, logger);
        this.exporter = exporter;
    }

    @Override
    public int execute(Object... args) {
        logger.println("File name:");
        String filename = logger.saveln(scanner.nextLine());
        this.exporter.portData(filename);
        return 0;
    }
}
