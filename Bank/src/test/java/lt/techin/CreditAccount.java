package lt.techin;

import java.math.BigDecimal;

public class CreditAccount extends AccountImpl {

    private BigDecimal creditLimit;


    public CreditAccount(String holderName, BigDecimal creditLimit) {
        super(holderName, BigDecimal.ZERO);
        if (creditLimit == null || creditLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Credit limit must be positive");
        }
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        BigDecimal availableBalance = getBalance().add(creditLimit);

        if (availableBalance.compareTo(amount) < 0) {
            return false;
        }
        balance = getBalance().subtract(amount);

        return true;
    }

    @Override
    public BigDecimal getBalance() {
        return super.getBalance();
    }

}
