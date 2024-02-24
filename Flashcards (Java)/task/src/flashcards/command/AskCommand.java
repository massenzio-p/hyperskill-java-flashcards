package flashcards.command;

import flashcards.CardStorage;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AskCommand implements Command {

    private final Scanner scanner;
    private final CardStorage cardStorage;

    public AskCommand(CardStorage storage, Scanner scanner) {
        this.scanner = scanner;
        this.cardStorage = storage;
    }

    @Override
    public int execute(Object... args) {
        System.out.println("How many times to ask?");
        int timesToAsk = scanner.nextInt();
        scanner.nextLine();
        Set<String> askedTerms = new HashSet<>();
        while (timesToAsk > 0) {
            playRandomCard(askedTerms);
            timesToAsk--;
        }
        return 0;
    }

    private void playRandomCard(Set<String> askedTerms) {
        Map.Entry<String, String> randomCard = null;
        do {
            randomCard = this.cardStorage.getRandomCard();
        } while (askedTerms.contains(randomCard.getKey()));

        System.out.printf("Print the definition of \"%s\":%n", randomCard.getKey());
        String answer = scanner.nextLine();

        if (answer.equals(randomCard.getValue())) {
            System.out.println("Correct!");
        } else {
            String suitableTerm = cardStorage.getTermForDefinition(answer);
            String remark = String.format(", but your definition is correct for \"%s\"", suitableTerm);
            System.out.printf(
                    "Wrong. The right answer is \"%s\"%s.%n",
                    randomCard.getValue(),
                    suitableTerm == null ? "" : remark);
        }

        askedTerms.add(randomCard.getKey());
    }
}
