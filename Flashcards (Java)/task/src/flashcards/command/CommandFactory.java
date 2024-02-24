package flashcards.command;

import flashcards.Card;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

public interface CommandFactory {

    static CommandFactory getDefaultFactory(CardStorage cardStorage, Scanner scanner, Logger logger) {
        return new DefaultCommandFactory(cardStorage, scanner, logger);
    }

    Command buildCommand(CommandType command);
}
