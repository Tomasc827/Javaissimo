package lt.techin;

public interface SupermarketService {
    Product getSelectedProduct();
    void selectProduct(String id);
    void addPayment(double amount);
    double getRemainingPayment();
    void completeTransaction();
    void cancelTransaction();
}
