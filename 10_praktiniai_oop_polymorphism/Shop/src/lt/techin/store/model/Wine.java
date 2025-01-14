package lt.techin.store.model;

public class Wine extends AlcoholicBeverage {
    private static final double LOWER_TAX_RATE = 0.28;
    private static final double HIGHER_TAX_RATE = 0.72;
    private static final double VOLUME_THRESHOLD = 8.5;

    public Wine(String name, double price, double volume, double amount) {
        super(name,price,volume,amount,LOWER_TAX_RATE,HIGHER_TAX_RATE,VOLUME_THRESHOLD);
    }
    @Override
    public String getType() {
        return "Wine";
    }

    @Override
    public String toString() {
        System.out.println();
        return super.toString();
    }
}
