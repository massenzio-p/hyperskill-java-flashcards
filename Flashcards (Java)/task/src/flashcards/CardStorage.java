package flashcards;

import java.util.Collection;

public interface CardStorage {

    boolean containsTerm(String term);

    Card getCardForDefinition(String definition);

    Card getCardForTerm(String term);

    void addCard(String term, String definition, int errors);

    boolean removeCard(String term);

    Collection<Card> getAllCards();

    Card getRandomCard();

    void resetAllScore();

    void addCard(String term, String definition);
}
