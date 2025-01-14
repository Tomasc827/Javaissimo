import java.util.ArrayList;

public class Box implements Packable{

    private double capacity;
    private ArrayList<Packable> items;


    public Box(double capacity) {

        this.capacity = capacity;
        if (this.capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be 0 or negative");
        }


        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (weight() + item.weight() > capacity) {
            throw new ItemTooHeavyException("Item would exceed the capacity");
        } else this.items.add(item);

    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, " + "total weight " + weight() +" kg";
    }



    @Override
    public double weight() {
        double currentWeight = 0;
        for(Packable one : items) {
            currentWeight += one.weight();
        }
        return currentWeight;
    }
}
