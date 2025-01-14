package lt.techin.store.model;

public class SimpleProduct extends Product {


    public SimpleProduct(String name, double price) {
        super(name,price,21);
    }

    @Override
    public String toString() {
        System.out.println();
        return " Category: Generic goods " + super.toString();
    }

}
