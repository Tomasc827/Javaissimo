package lt.techin;

import java.util.HashMap;

public class SupermarketServiceImplementation implements SupermarketService {
    private final ProductStorage productStorage;
    private final CashRegister cashRegister;
    private Product selectedProduct;
    private double currentPayment;

    public SupermarketServiceImplementation(ProductStorage productStorage, CashRegister cashRegister ) {
        this.productStorage =productStorage;
        this.cashRegister = cashRegister;
        this.currentPayment = 0.0;
    }




    @Override
    public Product getSelectedProduct() {
        selectedProductCheck();
        return selectedProduct;
    }

    @Override
    public void selectProduct(String id) {
        selectedProduct = productStorage.getProduct(id);
        currentPayment = 0.0;
    }


    @Override
    public void addPayment(double amount) {
 selectedProductCheck();
    cashRegister.addCoin(amount);
    currentPayment += amount;
    }

    @Override
    public double getRemainingPayment() {
    selectedProductCheck();
        return Math.max(0, selectedProduct.getPrice() - currentPayment);
    }

    @Override
    public void completeTransaction() {
     selectedProductCheck();
        if (currentPayment < selectedProduct.getPrice()) {
            throw new IllegalStateException("Not enough payment provided");
        }
        double changeAmount = currentPayment - selectedProduct.getPrice();
        if (changeAmount > 0) {
            cashRegister.calcChange(changeAmount);
        }
        productStorage.reduceStock(selectedProduct.getId());
        cashRegister.clearCurrentTransaction();
        selectedProduct = null;
        currentPayment = 0.0;
    }

    @Override
    public void cancelTransaction() {
    if (currentPayment > 0) {
       cashRegister.returnPayment();
    }
    selectedProduct = null;
    currentPayment = 0.0;
    }

    private void selectedProductCheck() {
        if (selectedProduct == null) {
            throw new IllegalStateException("No product selected");
        }
    }
}
