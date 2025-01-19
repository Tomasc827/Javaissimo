import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


    List<Integer> l = new ArrayList<>();
        Random random = new Random();
        Box<Integer> box = new Box<>(random.nextInt(10000),random.nextInt(10000,15000));
        Box<String> box2 = new Box<>(UUID.randomUUID().toString(),UUID.randomUUID().toString());
        box.lock();
        System.out.println(box.isLocked());
        box.unlock();
        System.out.println(box.getFirst());
        System.out.println(box.getSecond());
        System.out.println(box2);
        System.out.println(box);
        IntStream.range(0,10).map(x -> random.nextInt(99999)).forEach(l::add);
        System.out.println(lastElement(l));
        System.out.println(l);
        System.out.println(box.isLocked());
    }

    public static <T> T lastElement(List<T> list) {
        return list.get(list.size() - 1);

    }
    public static <T> T lastElement(T[] arr) {
        return arr[arr.length - 1];
    }


}