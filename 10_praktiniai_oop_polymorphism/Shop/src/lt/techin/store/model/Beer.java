package lt.techin.store.model;

public class Beer extends AlcoholicBeverage {
    private static final double LOWER_TAX_RATE = 0.89;
    private static final double HIGHER_TAX_RATE = 1.26;
    private static final double VOLUME_THRESHOLD = 15;

    public Beer(String name, double price, double volume, double amount) {
        super(name,price,volume,amount,LOWER_TAX_RATE,HIGHER_TAX_RATE,VOLUME_THRESHOLD);
    }
    @Override
    public String getType() {
        return "Beer";
    }

    @Override
    public String toString() {
        System.out.println();
        return super.toString();
    }
}