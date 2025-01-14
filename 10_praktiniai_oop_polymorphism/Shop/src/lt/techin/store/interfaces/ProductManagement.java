package lt.techin.store.interfaces;

import lt.techin.store.model.Product;

import java.util.ArrayList;

public interface ProductManagement {
    void addProduct(Product product);
    void removeProduct(Product product);
    ArrayList<Product> getProducts();
}
