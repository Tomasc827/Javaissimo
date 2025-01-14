public abstract class Product {
    protected String name;
    protected double price;
    protected double tax;

    public Product(String name, double price, double tax) {
        if(name.length() > 255) {
            throw new NameTooLongException("Name cannot exceed 255 characters");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        if(price < 0 || tax < 0) {
            throw new IllegalArgumentException("Price or tax cannot be negative");
        }
        if(tax > 99) {
            throw new TaxTooHighException("Tax is set too high");
        }
        this.price = price;
        this.tax = tax;
    }
    public Product(String name, double price) {
      this(name,price,0);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    public double priceInCurrencyTax(double currencyRate) {
        return calculateTax() * currencyRate;
    }

    public double priceInDollars(){
        return price * 1.0246;
    }

    public double priceInPounds(){
        return price * 0.8420;
    }

    public double priceInDollarsTax(){
        return priceInCurrencyTax(1.0246);
    }

    public double priceInPoundsTax(){
        return priceInCurrencyTax(0.8420);
    }

    public double calculateTax() {
        return price + (price * tax / 100);
    }

    @Override
    public String toString() {
        return String.format("\n Name: %s\n Tax: %.2f%%\n Price in Euro: %.2f\n Price in Dollars: %.2f\n Price in Pounds: %.2f",
                name, tax, calculateTax(), priceInDollarsTax(), priceInPoundsTax());
    }

}
