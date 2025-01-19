import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Pipe<T>{
    private List<T> list;

    public Pipe() {
        this.list = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        list.add(value);
    }

    public T takeFromPipe() {
       if(list.isEmpty()) {
           return null;
       }
     return list.remove(0);
    }

    public boolean isInPipe() {
        return !list.isEmpty();
    }

    public void putAllIntoPipe(T... values) {
        Arrays.stream(values).forEach(this::putIntoPipe);
    }


    public Stream<T> stream() {
        return list.stream();
    }
}
