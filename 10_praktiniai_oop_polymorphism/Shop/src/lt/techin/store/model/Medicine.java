package lt.techin.store.model;

public class Medicine extends Product {


    public Medicine(String name, double price) {
        super(name,price,9);
    }
    @Override
    public String toString() {
        System.out.println();
        return " Category: Medicinal goods " + super.toString();
    }

}
