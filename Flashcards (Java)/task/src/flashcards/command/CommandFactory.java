package flashcards.command;

import flashcards.Card;
import flashcards.CardFilePorter;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

public interface CommandFactory {

    static CommandFactory getDefaultFactory(CardStorage cardStorage,
                                            Scanner scanner,
                                            Logger logger,
                                            CardFilePorter importer,
                                            CardFilePorter exporter) {
        return new DefaultCommandFactory(cardStorage, scanner, logger, importer, exporter);
    }

    Command buildCommand(CommandType command);
}
