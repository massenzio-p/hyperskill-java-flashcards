package flashcards;

import java.util.Collection;
import java.util.Map;

public interface CardStorage {

    boolean containsTerm(String term);

    String getTermForDefinition(String definition);

    String getDefinitionForTerm(String term);

    void addCard(String term, String definition);

    boolean removeCard(String term);

    Collection<Map.Entry<String, String>> getAllCards();

    Map.Entry<String, String> getRandomCard();
}
