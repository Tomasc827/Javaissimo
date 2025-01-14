import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> items;


    public BoxWithMaxWeight(int capacity) {
        if (capacity <= 0 ) {
            throw new IllegalArgumentException("Box capacity cannot be 0 or negative.");
        }
        this.capacity = capacity;
        this.items = new ArrayList<>();

    }
    @Override
    public void add(Item item) {
        int currentWeight = 0;
        for (Item i : items) {
            currentWeight += i.getWeight();
        }

        if (currentWeight + item.getWeight() <= capacity) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Item too heavy, would exceed capacity limit.");
        }
        System.out.println(currentWeight);
    }

    public boolean isInBox(Item item) {
    return this.items.contains(item);
    }

}
