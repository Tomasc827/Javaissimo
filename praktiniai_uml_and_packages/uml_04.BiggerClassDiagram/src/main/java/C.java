import java.util.ArrayList;
import java.util.List;

public class C  extends B implements IC{
    private List<E> err;

    public C() {
        this.err = new ArrayList<>();
    }

    public void addE(E e) {
        err.add(e);
    }
}
