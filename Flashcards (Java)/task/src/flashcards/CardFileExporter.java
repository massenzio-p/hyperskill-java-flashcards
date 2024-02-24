package flashcards;

import flashcards.log.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class CardFileExporter implements CardFilePorter {

    private final CardStorage cardStorage;
    private final Logger logger;

    public CardFileExporter(CardStorage cardStorage, Logger logger) {
        this.cardStorage = cardStorage;
        this.logger = logger;
    }


    @Override
    public void portData(String filename) {
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
    }
}
