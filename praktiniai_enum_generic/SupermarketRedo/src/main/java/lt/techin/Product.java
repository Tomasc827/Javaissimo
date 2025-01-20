package lt.techin;

import java.util.UUID;

public class Product {
    private final String name;
    private final double price;
    private final String id;


    public Product(String name, double price,String id) {
    validateProduct(name,price);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }


    private void validateProduct(String name, double price) {
        if (name == null || name.isEmpty() || name.length() > 255) {
            throw new IllegalArgumentException("Name cannot be null, empty or above 255 characters");
        }
        if (price < 0 ) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (price > 10000) {
            throw new UpperThresholdException("The limit for the supermarket price is 10000");
        }
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f",price) + "£";
    }
}
