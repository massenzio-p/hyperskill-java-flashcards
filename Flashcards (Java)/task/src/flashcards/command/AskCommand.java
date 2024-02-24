package flashcards.command;

import flashcards.Card;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class AskCommand extends AbstractCommand {

    protected AskCommand(Scanner scanner, CardStorage cardStorage, Logger logger) {
        super(scanner, cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        logger.println("How many times to ask?");
        int timesToAsk = scanner.nextInt();
        scanner.nextLine();
        logger.saveln(Integer.toString(timesToAsk));

        Set<String> askedTerms = new HashSet<>();
        while (timesToAsk > 0) {
            playRandomCard(askedTerms);
            timesToAsk--;
        }
        return 0;
    }

    private void playRandomCard(Set<String> askedTerms) {
        Card randomCard;
        do {
            randomCard = this.cardStorage.getRandomCard();
        } while (askedTerms.contains(randomCard.term()));

        logger.print(String.format("Print the definition of \"%s\":%n", randomCard.term()));
        String answer = logger.saveln(scanner.nextLine());
        if (answer.equals(randomCard.definition())) {
            logger.println("Correct!");
        } else {
            String remark = "";
            Card suitableCard = cardStorage.getCardForDefinition(answer);

            if (suitableCard != null) {
                remark = String.format(", but your definition is correct for \"%s\"", suitableCard.term());
            }

            String finalMessage = String.format(
                    "Wrong. The right answer is \"%s\"%s.%n",
                    randomCard.definition(),
                    suitableCard == null ? "" : remark);
            logger.print(finalMessage);
            randomCard.score().incrementErrorCount();
        }

        askedTerms.add(randomCard.term());
    }
}
