package flashcards.command;

import flashcards.CardStorage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

class ExportCommand implements Command {

    private final CardStorage cardStorage;
    private final Scanner scanner;

    public ExportCommand(CardStorage cardStorage, Scanner scanner) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
    }

    @Override
    public int execute(Object... args) {
        System.out.println("File name:");
        String filename = scanner.nextLine();
        File file = new File(filename);
        try {
            file.createNewFile();
            try (var fileWriter = new FileWriter(file)) {
                String stringEntity;
                Collection<Map.Entry<String, String>> allCards = this.cardStorage.getAllCards();
                for (var entry : allCards) {
                    stringEntity = String.format("%s,%s;", entry.getKey(), entry.getValue());
                    fileWriter.append(stringEntity);
                    fileWriter.flush();
                }
                System.out.printf("%s cards have been saved.%n", allCards.size());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
