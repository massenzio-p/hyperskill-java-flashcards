package flashcards.command;

import flashcards.CardFilePorter;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class ImportCommand extends AbstractCommand {

    private final CardFilePorter importer;

    protected ImportCommand(Scanner scanner, Logger logger, CardFilePorter importer) {
        super(scanner, logger);
        this.importer = importer;
    }

    @Override
    public int execute(Object... args) {
        logger.println("File name:");
        String fileName = logger.saveln(this.scanner.nextLine());
        importer.portData(fileName);
        return 0;
    }
}
