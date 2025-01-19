import java.util.ArrayList;

public class Hideout<T>{
    private T obj;

    public Hideout() {
        this.obj =null;
    }

    public void putIntoHideout(T toHide) {
        obj = toHide;
    }
    public T takeFromHideout() {
        T objReturn = obj;
        obj = null;
        return objReturn;

    }

    public boolean isInHideout() {
        return obj != null;
    }

}
