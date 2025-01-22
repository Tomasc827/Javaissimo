package lt.techin.enum_interface;

public enum Coins {
    TEN_CENT(0.10),
    TWENTY_CENT(0.20),
    FIFTY_CENT(0.50),
    POUND(1.00),
    TWO_POUND(2.00),
    Five_POUND(5.00);

    private final double value;

     Coins (double coins) {
     this.value = coins;
    }

    public double getValue() {
        return value;
    }
}
