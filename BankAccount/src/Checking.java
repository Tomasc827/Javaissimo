import java.math.BigDecimal;

public class Checking extends Account{

    private static final BigDecimal overdraftLimit = new BigDecimal("500");

    public Checking() {
        super();
    }


    @Override
    public BigDecimal withdraw(BigDecimal amount) {

            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative");
            }

            BigDecimal newBalance = getBalance().subtract(amount);

            if (newBalance.compareTo(overdraftLimit.negate()) <0 ) {
                throw new IllegalArgumentException("Withdrawal amount would exceed overdraft limit");
            }
             setBalance(newBalance);
            return getBalance();

    }
    @Override
    public String toString() {
        return super.toString();
    }

}
