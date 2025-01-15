import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
   private HashMap<String,ArrayList<String>> dic;
    public DictionaryOfManyTranslations() {
        this.dic = new HashMap<>();
    }

    public void add(String word,String translation) {
        if (!dic.containsKey(word)) {
            dic.put(word, new ArrayList<>());
        }
        dic.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        ArrayList<String> result = new ArrayList<>();
        if(dic.containsKey(word)){
            result.addAll(dic.get(word));
        }
        return result;

    }

    public void remove(String word) {
        dic.remove(word);
    }

}
