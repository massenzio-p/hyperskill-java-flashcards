package flashcards;

import java.util.*;

public class HashMapCardStorage implements CardStorage {

    private final Map<String, String> termsDefinitions = new LinkedHashMap<>();
    private final Map<String, String> definitionsTerms = new HashMap<>();
    private final Random random = new Random();

    @Override
    public boolean containsTerm(String term) {
        return this.termsDefinitions.containsKey(term);
    }

    @Override
    public String getTermForDefinition(String definition) {
        return this.definitionsTerms.get(definition);
    }

    @Override
    public String getDefinitionForTerm(String term) {
        return this.termsDefinitions.get(term);
    }

    @Override
    public void addCard(String term, String definition) {
        this.termsDefinitions.put(term, definition);
        this.definitionsTerms.put(definition, term);
    }

    @Override
    public boolean removeCard(String term) {
        String definition = this.termsDefinitions.get(term);
        if (definition == null) {
            return false;
        }
        this.termsDefinitions.remove(term);
        this.definitionsTerms.remove(definition);
        return true;
    }

    @Override
    public Collection<Map.Entry<String, String>> getAllCards() {
        return this.termsDefinitions.entrySet();
    }

    @Override
    public Map.Entry<String, String> getRandomCard() {
        String[] termsArray = termsDefinitions.keySet().toArray(new String[]{});
        String randomTerm = termsArray[this.random.nextInt(termsArray.length)];
        return Map.entry(randomTerm, termsDefinitions.get(randomTerm));
    }
}
