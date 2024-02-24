package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class ImportCommand extends AbstractCommand {

    protected ImportCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("File name:");
        String fileName = logger.saveln(this.scanner.nextLine());
        File file = new File(fileName);
        String msg = "File not found";

        if (file.isFile()) {
            int loaded = 0;
            try {
                loaded = importCards(file);
                msg = String.format("%d cards have been loaded.", loaded);
            } catch (Exception e) {
                msg = "Something went wrong while importing =(";
            }
        }

        logger.println(msg);
        return 0;
    }

    private int importCards(File file) throws Exception {
        try (var fileScanner = new Scanner(file).useDelimiter(";")) {
            AtomicInteger counter = new AtomicInteger();
            fileScanner.tokens()
                    .map(pairToken -> new StringTokenizer(pairToken, ","))
                    .forEach(token -> {
                        this.cardStorage.addCard(
                                token.nextToken(),
                                token.nextToken(),
                                Integer.parseInt(token.nextToken()));
                        counter.incrementAndGet();
                    });
            return counter.get();
        }
    }
}
