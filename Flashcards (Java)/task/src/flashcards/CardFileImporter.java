package flashcards;

import flashcards.log.Logger;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class CardFileImporter implements CardFilePorter {

    private final CardStorage cardStorage;
    private final Logger logger;

    public CardFileImporter(CardStorage cardStorage, Logger logger) {
        this.cardStorage = cardStorage;
        this.logger = logger;
    }

    @Override
    public void portData(String fileName) {
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
