package flashcards.command;

import flashcards.Card;
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

    protected ExportCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("File name:");
        String filename = logger.saveln(scanner.nextLine());
        File file = new File(filename);
        try {
            file.createNewFile();
            try (var fileWriter = new FileWriter(file)) {
                String stringEntity;
                Collection<Card> allCards = this.cardStorage.getAllCards();
                for (var card : allCards) {
                    stringEntity = String.format(
                            "%s,%s,%d;",
                            card.term(),
                            card.definition(),
                            card.score().getErrorsCount());
                    fileWriter.append(stringEntity);
                    fileWriter.flush();
                }
                logger.print(String.format("%s cards have been saved.%n", allCards.size()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
