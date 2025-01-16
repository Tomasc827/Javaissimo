import java.util.UUID;

public abstract class Container {
    private String id;
    private double maxWeight;

    public Container(double maxWeight) {
        this.id = UUID.randomUUID().toString();
        if(maxWeight <= 0) {
            throw new IllegalArgumentException("Max weight cannot be 0 or negative");
        }
        this.maxWeight = maxWeight;
    }

    public String getId() {
        return id;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\n Maximum Weight: " + maxWeight;
    }
}
