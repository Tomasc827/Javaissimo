import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI{
    private Scanner scan;
    private List<Book> books;

    public ConsoleUI() {
        this.books = new ArrayList<>();
    }

    public void Start() {
        boolean stop = false;

        while (!stop) {
            this.scan = new Scanner(System.in);
            System.out.print("Input the name of the book, empty stops: ");
            String name = this.scan.nextLine().trim();
            if(name.isEmpty()) {
                stop = true;
                break;
            }
            System.out.print("Input the age recommendation: ");
            int age = Integer.parseInt(this.scan.nextLine());

            books.add(new Book(name,age));
        }
        System.out.println(this.books.size() + " books in total.");
        System.out.println();
        Collections.sort(books);
        for (Book one : books) {
            System.out.println(one);
        }
    }

}
