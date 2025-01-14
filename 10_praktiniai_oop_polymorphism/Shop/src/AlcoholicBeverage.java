public abstract class AlcoholicBeverage extends Product {
    private double volume;
    private double amount;
    private double alcoholTax;

    public AlcoholicBeverage(String name, double price, double volume, double amount, double alcoholTax) {
        super(name, price, 21);
        if (volume > 100) {
            throw new VolumeTooHighException("Volume is set too high for an alcoholic beverage");
        }
        if (volume <= 0 || amount <= 0 || alcoholTax <= 0) {
            throw new IllegalArgumentException("Volume, amount or alcohol tax cannot be negative or 0");
        }
        if (alcoholTax > 100) {
            throw new TaxTooHighException("Alcohol tax is too high");
        }
        if (amount > 10.00) {
            throw new AlcoholAmountTooHighException("The store only allows up to 10 liters of alcohol on one product");
        }
        this.volume = volume;
        this.amount = amount;
        this.alcoholTax = alcoholTax;

         double calculateAlcoholTax;
    }
}
