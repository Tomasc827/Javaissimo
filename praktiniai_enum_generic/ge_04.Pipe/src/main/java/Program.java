
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here

        Pipe<String> pipe = new Pipe<>();

        pipe.putAllIntoPipe("never","gonna","give","you","up");
        pipe.stream().forEach(System.out::println);

        Pipe<Integer> numPipe = new Pipe<>();
        numPipe.putAllIntoPipe(1,2,3,4,5);
        System.out.println(numPipe.stream().reduce(0, (acc, x) -> acc + x));
        Stream.generate(numPipe::takeFromPipe).takeWhile(Objects::nonNull).collect(Collectors.toList());
        System.out.println(numPipe.takeFromPipe());

    }
}
