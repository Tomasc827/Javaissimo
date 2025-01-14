import java.util.ArrayList;

public class MisplacingBox extends Box{

    private ArrayList<Item> items;

    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }

    @Override
    public void add(Item Item) {
        this.items.add(Item);
    }


}
