
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine().trim();
        readBooks(input);

    }

    public static List<Book> readBooks(String file) {
        try {
            List<Book> books = Files.readAllLines(Paths.get(file)).stream()
                    .map(x -> x.split(","))
                    .map(x -> new Book(x[0],Integer.parseInt(x[1]),Integer.parseInt(x[2]),x[3])).collect(Collectors.toList());
           books.forEach(System.out::println);
                return books;
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
            return new ArrayList<>();
        }
    }


}
