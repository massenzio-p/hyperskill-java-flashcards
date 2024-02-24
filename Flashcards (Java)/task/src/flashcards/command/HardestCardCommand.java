package flashcards.command;

import flashcards.Card;
import flashcards.CardStorage;
import flashcards.log.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class HardestCardCommand extends AbstractCommand {

    protected HardestCardCommand(CardStorage cardStorage, Logger logger) {
        super(cardStorage, logger);
    }

    @Override
    public int execute(Object... args) {
        Collection<Card> hardestCards = findHardestCards();
        String msgFrame = "There are no cards with errors.\n";
        if (hardestCards != null) {
            msgFrame = String.format(
                    "The hardest card%s %s. You have %d errors answering %s.%n",
                    hardestCards.size() > 1 ? "s are" : " is",
                    hardestCards.stream()
                            .map(card -> String.format("\"%s\"", card.term()))
                            .collect(Collectors.joining(", ")),
                    hardestCards.stream().findFirst().get().score().getErrorsCount(),
                    hardestCards.size() > 1 ? "them" : "it"
            );
        }
        logger.print(msgFrame);
        return 0;
    }

    private Collection<Card> findHardestCards() {
        int maxErrors = 0;
        int currErrors;
        List<Card> maxErrorCards = new ArrayList<>();

        for (var card : this.cardStorage.getAllCards()) {
            currErrors = card.score().getErrorsCount();
            if (currErrors < 1) continue;

            if (currErrors > maxErrors) {
                maxErrors = currErrors;
                maxErrorCards.clear();
                maxErrorCards.add(card);
            } else if (currErrors == maxErrors) {
                maxErrorCards.add(card);
            }
        }

        if (maxErrorCards.isEmpty()) return null;
        return maxErrorCards;
    }
}
