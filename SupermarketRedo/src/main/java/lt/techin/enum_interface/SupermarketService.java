package lt.techin.enum_interface;

import lt.techin.classes.Product;

public interface SupermarketService {
    Product getSelectedProduct();
    void selectProduct(String id);
    void addPayment(double amount);
    double getRemainingPayment();
    void completeTransaction();
    void cancelTransaction();
    void getProducts();
    void getCashRegisterValues();
}
