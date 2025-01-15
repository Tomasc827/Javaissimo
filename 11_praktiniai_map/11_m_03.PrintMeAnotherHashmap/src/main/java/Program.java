
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, Book> hashMap = new HashMap<>();
        hashMap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashMap.put("prejudice", new Book("Pride and prejudice", 1813, "..."));
        printValues(hashMap);
        printValueIfNameContains(hashMap,"prejud");
    }
    public static void printValues(HashMap<String,Book> hashMap) {
        for(Book one : hashMap.values()) {
            System.out.println(one);
        }

    }        public static void printValueIfNameContains(HashMap<String,Book> hashMap, String text) {
            for(Book one : hashMap.values()) {
                if(one.getName().contains(text)){
                    System.out.println(one);
                }
            }
    }

}
