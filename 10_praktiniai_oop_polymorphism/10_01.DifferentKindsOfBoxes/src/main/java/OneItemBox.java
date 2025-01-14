import java.util.ArrayList;

public class OneItemBox extends  Box{

    private ArrayList<Item> items;

    public OneItemBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.items.contains(item)) {
            throw new IllegalArgumentException("Cannot add the same item.");
        } else if (this.items.size() >= 1) {
            throw new IllegalArgumentException("Only one item can be placed inside this box.");
        } else {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }

}
