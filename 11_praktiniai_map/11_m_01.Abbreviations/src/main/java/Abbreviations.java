import java.util.HashMap;

public class Abbreviations {
    private HashMap<String,String> abs;


    public Abbreviations() {
        this.abs = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abs.put(abbreviation,explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        return abs.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        return abs.getOrDefault(abbreviation, null);
    }


}
