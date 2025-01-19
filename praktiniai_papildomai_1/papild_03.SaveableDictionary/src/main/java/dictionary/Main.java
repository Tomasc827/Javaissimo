package dictionary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary s = new SaveableDictionary();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim().toLowerCase();
        SaveableDictionary f = new SaveableDictionary(input);
        f.load();
        f.add("now","never");
        f.add("how","however");
        f.save();

    }
}
