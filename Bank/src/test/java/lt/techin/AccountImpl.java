package lt.techin;

import ibank.Account;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountImpl implements Account {

    private String number;
    private String name;
    protected BigDecimal balance;

    public AccountImpl(String name,BigDecimal balance) {
        if (name == null || balance == null) {
            throw new IllegalArgumentException("Name or balance cannot be null");
        }
        if (name.length() > 255) {
            throw new UpperCharacterLimitException("Name length must be between 0 and 255 characters");
        }
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (name.length() <= 3) {
            throw new LowerCharacterLimitException("Name length must be at least 3 characters long");
        }

        this.number = UUID.randomUUID().toString();
        this.name = name;
        this.balance = balance;
    }



    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHolderName() {
        return name;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            return false;

        }
        balance = balance.add(amount);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
           return false;
        }
        if (balance.compareTo(amount) < 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }
}
