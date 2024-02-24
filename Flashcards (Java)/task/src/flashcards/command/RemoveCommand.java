package flashcards.command;

import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.Scanner;

class RemoveCommand extends AbstractCommand {

    protected RemoveCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("Which card?");
        String term = logger.saveln(this.scanner.nextLine());

        String msg = "The card has been removed.%n";
        if (!this.cardStorage.removeCard(term)) {
            msg = String.format("Can't remove \"%s\": there is no such card.%n", term);
        }

        logger.print(String.format(msg));
        return 0;
    }
}
