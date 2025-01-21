package lt.techin;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name,double price, int stock) {
        validateProduct(name,price,stock);
        this.name = name;
        this.price = price;
        this.stock = stock;

    }
    public Product(String name, double price) {
        validateProduct(name,price,0);
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    private void validateProduct(String name, double price, int stock) {
        if(name == null || name.isEmpty() || name.length() > 255) {
            throw new IllegalArgumentException("Name cannot be empty, null or longer than 255 characters");
        }
        if(price < 0 || stock < 0) {
            throw new IllegalArgumentException("Price or stock cannot be negative");
        }
        if(stock > 200 || price > 10000) {
            throw new UpperThresholdException("The upper limit for stock is 200 and price is 10000 for this supermarket");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f",price) + "€: " + (stock == 0 ? "Out of stock" : "In Stock " + stock);
    }

}
