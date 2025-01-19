package dictionary;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SaveableDictionary {
    private HashMap<String,String> dictionary;
    private String file;

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public void add(String words, String translations) {

            if(dictionary.containsKey(words.toLowerCase())) {
                System.out.println("Word is already in the dictionary.");
            }else {
                dictionary.put(words,translations);
            }
    }
    public String translate(String word) {
        return dictionary.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(word)
                    || entry.getValue().equalsIgnoreCase(word))
                .map(x-> word.equalsIgnoreCase(x.getKey()) ? x.getValue() : x.getKey())
                .findFirst()
                .orElse(null);

//        if (dictionary.containsKey(word)) {
//            String value = dictionary.keySet().stream()
//                    .filter(x -> x.equalsIgnoreCase(word))
//                    .map(x -> dictionary.get(x))
//                    .findFirst()
//                    .orElse(null);
//            return value;
//        } else {
//            String key = dictionary.entrySet().stream()
//                    .filter(x -> word.equalsIgnoreCase(x.getValue()))
//                    .map(x -> x.getKey())
//                    .findFirst()
//                    .orElse(null);
//            return key;
//        }
    }
    public void delete(String word) {
  dictionary.remove(word);
  dictionary.values().removeIf(value -> value.equalsIgnoreCase(word));
    }
    public boolean load() {
        try {
            Path path = Paths.get(file);
            Files.readAllLines(path)
                    .stream()
                    .map(x -> x.split(":"))
                    .forEach(x -> {
                        if (x.length == 2) {
                            dictionary.put(x[0], x[1]);
                        }
                    });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

} public boolean save() {
       try {
            Path path = Paths.get(file);
            List<String> lines = dictionary.entrySet()
                    .stream()
                    .map(x -> x.getKey() + ":" + x.getValue())
                    .collect(Collectors.toList());
            Files.write(path, lines);
            return true;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
    }

}
