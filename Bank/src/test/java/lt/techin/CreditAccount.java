package lt.techin;

import ibank.Account;

import java.math.BigDecimal;

public class CreditAccount implements Account {
    private Account account;
    private BigDecimal creditLimit;

    public CreditAccount(Account account, BigDecimal creditLimit) {
        this.account = account;
        if (creditLimit == null || creditLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Credit limit must be positive");
        }
        this.creditLimit = creditLimit;

    }


    @Override
    public String getNumber() {
        return account.getNumber();
    }

    @Override
    public String getHolderName() {
        return account.getHolderName();
    }

    @Override
    public BigDecimal getBalance() {
        return account.getBalance();
    }

    @Override
    public boolean deposit(BigDecimal amount) {
        return account.deposit(amount);
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        BigDecimal availableBalance = account.getBalance().add(creditLimit);
        if (availableBalance.compareTo(amount) < 0) {
            return false;
        }

        boolean success = account.withdraw(amount);
        return success;
    }

}
