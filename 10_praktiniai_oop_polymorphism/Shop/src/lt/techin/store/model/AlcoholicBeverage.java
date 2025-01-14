package lt.techin.store.model;

import lt.techin.store.exceptions.AlcoholAmountTooHighException;
import lt.techin.store.exceptions.VolumeTooHighException;

public abstract class AlcoholicBeverage extends Product {
    protected double volume;
    protected double amount;
    protected final double lowerTaxRate;
    protected final double higherTaxRate;
    protected final double volumeThreshold;

    public AlcoholicBeverage(String name, double price,double volume, double amount,
                             double lowerTaxRate, double higherTaxRate,double volumeThreshold) {
        super(name, price);
        this.tax = 21;
        if (volume > 100) {
            throw new VolumeTooHighException("Volume is set too high for an alcoholic beverage");
        }
        if (volume <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Volume or amount cannot be negative or 0");
        }
        if (amount > 10.00) {
            throw new AlcoholAmountTooHighException("The store only allows up to 10 liters of alcohol on one product");
        }
        this.volume = volume;
        this.amount = amount;
        this.lowerTaxRate = lowerTaxRate;
        this.higherTaxRate = higherTaxRate;
        this.volumeThreshold = volumeThreshold;
    }
    @Override
    public double priceInCurrencyTax(double currencyRate) {
        return calculateAlcoholTax() * currencyRate;
    }
    @Override
    public double priceInDollarsTax(){
        return priceInCurrencyTax(1.0246);
    }
    @Override
    public double priceInPoundsTax(){
        return priceInCurrencyTax(0.8420);
    }

    public double calculateAlcoholTax() {
        double alcoholTax = volume <= volumeThreshold ? lowerTaxRate : higherTaxRate;
        return calculateTax() + (alcoholTax * amount) ;
    }

    public String getType() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("\n Type: %s \n Name: %s \n Category: Alcoholic Beverages\n Tax: %.2f%%\n Volume: %.1f%%\n Amount: %.1fl \n Lower Tax Rate: %.2f€\n Higher Tax Rate: %.2f€\n Volume Threshold: %.1f%%\n Price in Euro: %.2f\n Price in Dollars: %.2f\n Price in Pounds: %.2f",
                getType(),name, tax, volume, amount,lowerTaxRate,higherTaxRate,volumeThreshold, calculateAlcoholTax(), priceInDollarsTax(), priceInPoundsTax());
    }
}
