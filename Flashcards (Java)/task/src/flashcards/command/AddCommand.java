package flashcards.command;

import flashcards.Card;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

class AddCommand extends AbstractCommand {

    protected AddCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("The card");
        String term = logger.saveln(scanner.nextLine());
        if (this.cardStorage.containsTerm(term)) {
            logger.print(String.format("The card \"%s\" already exists.%n", term));
            return 0;
        }

        logger.println("The definition of the card:");
        String definition = logger.saveln(scanner.nextLine());
        Card existingCard = this.cardStorage.getCardForDefinition(definition);
        if (existingCard != null) {
            logger.print(String.format("The definition \"%s\" already exists.%n", definition));
            return 0;
        }

        this.cardStorage.addCard(term, definition);
        logger.print(String.format("The pair (\"%s\":\"%s\") has been added%n", term, definition));
        return 0;
    }
}
