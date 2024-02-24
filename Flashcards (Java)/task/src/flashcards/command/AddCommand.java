package flashcards.command;

import flashcards.CardStorage;

import java.util.Map;
import java.util.Scanner;

class AddCommand implements Command {

    private final CardStorage cardStorage;
    private final Scanner scanner;

    AddCommand(CardStorage cardStorage, Scanner scanner) {
        this.cardStorage = cardStorage;
        this.scanner = scanner;
    }

    @Override
    public int execute(Object... args) {
        System.out.println("The card");
        String term = scanner.nextLine();
        if (this.cardStorage.containsTerm(term)) {
            System.out.printf("The card \"%s\" already exists.%n", term);
            return 0;
        }

        System.out.println("The definition of the card:");
        String definition = scanner.nextLine();
        String existingTerm = this.cardStorage.getTermForDefinition(definition);
        if (existingTerm != null) {
            System.out.printf("The definition \"%s\" already exists.%n", definition);
            return 0;
        }

        this.cardStorage.addCard(term, definition);
        System.out.printf("The pair (\"%s\":\"%s\") has been added%n", term, definition);
        return 0;
    }
}
