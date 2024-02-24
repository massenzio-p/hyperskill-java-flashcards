package flashcards;

import java.util.*;

public class HashMapCardStorage implements CardStorage {

    private final Map<String, Card> termCardMap = new LinkedHashMap<>();
    private final Map<String, Card> definitionCardMap = new HashMap<>();
    private final Random random = new Random();

    @Override
    public boolean containsTerm(String term) {
        return this.termCardMap.containsKey(term);
    }

    @Override
    public Card getCardForDefinition(String definition) {
        return this.definitionCardMap.get(definition);
    }

    @Override
    public Card getCardForTerm(String term) {
        return this.termCardMap.get(term);
    }

    @Override
    public void addCard(String term, String definition) {
        addCard(term, definition, 0);
    }

    @Override
    public void addCard(String term, String definition, int errors) {
        Card newCard = new Card(term, definition, new Score(errors));
        this.termCardMap.put(term, newCard);
        this.definitionCardMap.put(definition, newCard);
    }

    @Override
    public boolean removeCard(String term) {
        Card card = this.termCardMap.get(term);
        if (card == null) {
            return false;
        }
        this.termCardMap.remove(term);
        this.definitionCardMap.remove(card.definition());
        return true;
    }

    @Override
    public Collection<Card> getAllCards() {
        return this.termCardMap.values();
    }

    @Override
    public Card getRandomCard() {
        String[] termsArray = termCardMap.keySet().toArray(new String[]{});
        String randomTerm = termsArray[this.random.nextInt(termsArray.length)];
        return termCardMap.get(randomTerm);
    }

    @Override
    public void resetAllScore() {
        getAllCards().stream()
                .map(Card::score)
                .forEach(score -> score.setErrorsCount(0));
    }
}
