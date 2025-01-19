
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // you may try out your class here
    Hideout<String> den = new Hideout<>();
        System.out.println(den.isInHideout());
        den.putIntoHideout("sdjg");
        System.out.println(den.isInHideout());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideout());
    }
}
