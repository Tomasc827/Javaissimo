package dictionary;

import java.util.HashMap;

public class SaveableDictionary {
    private HashMap<String,String> dic;

    public SaveableDictionary() {
        this.dic = new HashMap<>();
    }

    public void add(String words, String translations) {
        boolean found = false;
        for(String one : dic.keySet()) {
            if(!one.equalsIgnoreCase(words)) {
                dic.put(words,translations);
                found = true;
            }
        } if(!found) {
            System.out.println("Word is already in the dictionary.");
        }
    }
    public String translate(String word) {
        boolean found = false;
        String wah = "";
        for(String one : dic.keySet()) {
            if(one.equalsIgnoreCase(word)) {
                found = true;
                wah = dic.get(word);
                break;
            }
        } for(String one : dic.values()) {
            if(one.equalsIgnoreCase(word)) {
                found = true;
                wah = dic.get(word);
            }
        }
        if (!found) {
            return null;
        } else {
            return wah;
        }
    }
}
