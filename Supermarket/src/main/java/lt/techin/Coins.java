package lt.techin;

public enum Coins {
    TenCent(0.10),
    FiftyCent(0.50),
    Euro(1.00),
    TwoEuro(2.00);
    private final double value;

    Coins(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
