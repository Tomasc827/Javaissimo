import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ProtoLinkedList<Integer> list = new ProtoLinkedList<>();
        IntStream.range(0,10).forEach(list::add);
        System.out.println(list);
    }
}