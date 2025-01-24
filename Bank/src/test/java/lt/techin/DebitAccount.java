package lt.techin;

import ibank.Account;

import java.math.BigDecimal;

public class DebitAccount implements Account {
    private Account account;

    public DebitAccount(Account account) {
        this.account = account;
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
        if (account.getBalance().compareTo(amount) < 0) {
            return false;
        }
        return account.withdraw(amount);
    }
}
