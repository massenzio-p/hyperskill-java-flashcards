package flashcards.command;

import flashcards.CardStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class ImportCommand implements Command {

    private final CardStorage cardStorage;
    private final Scanner scanner;

    public ImportCommand(CardStorage cardStorage, Scanner scanner) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
    }

    @Override
    public int execute(Object... args) {
        System.out.println("File name:");
        String fileName = this.scanner.nextLine();
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

        System.out.println(msg);
        return 0;
    }

    private int importCards(File file) throws Exception {
        try (var fileScanner = new Scanner(file).useDelimiter(";")) {
            AtomicInteger counter = new AtomicInteger();
            fileScanner.tokens()
                    .map(pairToken -> new StringTokenizer(pairToken, ","))
                    .forEach(token -> {
                        this.cardStorage.addCard(token.nextToken(), token.nextToken());
                        counter.incrementAndGet();
                    });
            return counter.get();
        }
    }
}
