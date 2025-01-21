package lt.techin;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("fish",2);
        System.out.println(product);
        CashRegister c = new CashRegister();
        c.addCoin(0.5,0);
    }
}
