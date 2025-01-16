
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String file = scanner.nextLine().trim();
        List<String> text = read(file);
        for(String one : text) {
            System.out.println(one);
        }

    }

    public static List<String> read (String file) {
        List<String> text = new ArrayList<>();
        try  {
            text = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        } return text;
    }

}
