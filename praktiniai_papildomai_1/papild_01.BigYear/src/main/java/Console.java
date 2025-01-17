import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private Database database;
    private Scanner scan;


    public Console() {
        this.database = new Database();
        this.scan = new Scanner(System.in);
    }

    public void start() {
        System.out.print("? ");
        boolean stop = false;
        while (!stop) {

            String option = scan.nextLine().trim().toLowerCase();
            switch (option) {
                case "quit":
                    stop = true;
                    break;
                case "add":
                    System.out.print("Name: ");
                    String name = scan.nextLine().trim();
                    System.out.print("Name in Latin: ");
                    String nameLatin = scan.nextLine().trim();
                    Bird bird = new Bird(name, nameLatin);
                    database.addBird(bird);
                    break;
                case "observation":
                    System.out.print("Bird? ");
                    String birdName = scan.nextLine().trim().toLowerCase();
                    database.observation(birdName);
                    break;
                case "one":
                    System.out.print("Bird? ");
                    String birdIn = scan.nextLine().trim().toLowerCase();
                    database.printOne(birdIn);
                    break;
                case "all":
                    database.printAll();
                    break;
                default:
                    System.out.println("Invalid command, try again.");

            }

        }


    }
}
