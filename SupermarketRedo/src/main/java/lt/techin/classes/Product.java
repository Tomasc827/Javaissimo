package lt.techin.classes;

import lt.techin.exceptions.UpperThresholdException;
import lt.techin.exceptions.NameOrIdTooShortException;

public class Product {
    private final String name;
    private final double price;
    private final String id;


    public Product(String name, double price,String id) {
    validateProduct(name,price,id);
        this.id = id.toUpperCase();
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


    private void validateProduct(String name, double price,String id) {
        if (name == null || name.isEmpty() || name.length() > 255) {
            throw new IllegalArgumentException("Name cannot be null, empty or above 255 characters");
        }
        if (id == null || id.isEmpty() || id.length() > 255) {
            throw new IllegalArgumentException("Id cannot be null, empty or above 255 characters");
        }
        if (price < 0 ) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (name.length() <= 3 || id.length() <= 3) {
            throw new NameOrIdTooShortException("Name or id needs to be at least 3 symbols long");
        }

        if (price > 10000) {
            throw new UpperThresholdException("The limit for the supermarket price is 10000");
        }
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f",price) + "£,";
    }
}
