package lt.techin.store.model;

import lt.techin.store.exceptions.NameTooLongException;
import lt.techin.store.interfaces.ProductManagement;

import java.util.ArrayList;

public class Store implements ProductManagement {
    private ArrayList<Product> products;
    private String line;
    private String city;

    public Store(String line, String city) {
        this.products = new ArrayList<>();
        if(line.length() > 255) {
            throw new NameTooLongException("Line cannot exceed 255 characters");
        }
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Line cannot be null or empty");
        }
        if(city.length() > 255) {
            throw new NameTooLongException("City cannot exceed 255 characters");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.line = line;
        this.city = city;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("\n Line: %s\n City: %s\n", line, city));
        for (Product one : products) {
            result.append("\n").append(one);
        }
        return result.toString();
    }
}
