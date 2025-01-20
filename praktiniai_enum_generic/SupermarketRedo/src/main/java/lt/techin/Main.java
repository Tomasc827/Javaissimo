package lt.techin;

public class Main {
    public static void main(String[] args) {
//        Product product = new Product("was",2);
        CashRegister c = new CashRegister();
        c.addCoin(0.10);
        c.addCoin(0.10);
        c.addCoin(0.50);
        c.addCoin(1.00);
        c.addCoin(1.00);
        c.addCoin(1.00);
        c.addCoin(2.00);
        c.printAllCoins();
        ProductStorage p = new ProductStorage();
        p.displayProducts();
    }
}