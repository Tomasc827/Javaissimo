package lt.techin;

import java.util.HashMap;

public class ProductStorage {
    private final HashMap<String,Product> products;
    private final HashMap<String,Integer> inventory;

    public ProductStorage() {
        this.products =new HashMap<>();
        this.inventory = new HashMap<>();
        initialProducts();

    }

    public void initialProducts() {
        Product eggs = new Product("Eggs",3.00,"EGGS");
        Product fish = new Product("Fish",5.00,"FISH");
        products.put(eggs.getId(),eggs);
        products.put(fish.getId(),fish);

        inventory.put(eggs.getId(),20);
        inventory.put(fish.getId(),25);
    }
    public int getStock(String productId) {
        return inventory.getOrDefault(productId,0);
    }

    public Product getProduct(String id) {
        Product product = products.get(id);
        if (product == null) {
            throw new SoldOutException("Product is not available");
        }
        if (getStock(id) <= 0) {
            throw new SoldOutException("Product sold out");
        }

        return product;
    }

    public void updateStock(String productId,int quantity) {
        checkProduct(productId);
        inventory.put(productId,quantity);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        products.forEach((id,product) -> {
            int stock = inventory.get(id);
            System.out.printf("%s - %s (Quantity: %d)%n",
                    id,product.toString(),stock);
        });
    }

    public void reduceStock(String productId) {
        checkProduct(productId);
        int currentStock = inventory.get(productId);
        if (currentStock <=0) {
            throw new SoldOutException("Product sold out");
        }
        inventory.put(productId,currentStock - 1);
    }

    private void checkProduct(String productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product does not exist");
        }
    }


}
