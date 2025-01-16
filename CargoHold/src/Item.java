public class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        if(name.length() > 255) {
            throw new NameTooLongException("Items name should not exceed 255 characters");
        }
        if(weight <= 0) {
            throw new IllegalArgumentException("Item weight cannot be 0 or negative");
        }
        if(weight > 100) {
            throw  new ItemTooHeavyException("Item cannot exceed 100kg");
        }
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return name + " " + weight + " kg";
    }


}
