package flashcards.command;

import flashcards.Card;
import flashcards.CardStorage;

import java.util.Scanner;

public interface CommandFactory {

    static CommandFactory getDefaultFactory(CardStorage cardStorage, Scanner scanner) {
        return new DefaultCommandFactory(cardStorage, scanner);
    }

    Command buildCommand(CommandType command);
}
