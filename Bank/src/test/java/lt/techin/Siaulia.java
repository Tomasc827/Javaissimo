package lt.techin;

import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Siaulia implements Bank {
    private List<Account> accounts;

    public Siaulia() {
        accounts = new ArrayList<Account>();
    }

    private boolean accountExists(String accountHolderName) {
        return getAccountByHolderName(accountHolderName) != null;
    }

    @Override
    public int getNumberOfAccounts() {
       return accounts.size();

    }

    @Override
    public BigDecimal getTotalReserves() {
      return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account openDebitAccount(String accountHolderName) {
        if (extracted(accountHolderName)) return null;
        Account newAccount = new AccountImpl(accountHolderName, BigDecimal.ZERO);
        DebitAccount debitAccount = new DebitAccount(newAccount);
        accounts.add(debitAccount);
        return debitAccount;
    }

    @Override
    public Account openCreditAccount(String accountHolderName, BigDecimal creditLimit) {
        if (extracted(accountHolderName)) return null;
        CreditAccount creditAccount = new CreditAccount(accountHolderName, creditLimit);
        accounts.add(creditAccount);
        return creditAccount;
    }

    private boolean extracted(String accountHolderName) {
        return getAccountByHolderName(accountHolderName) != null;
    }

    @Override
    public Account getAccountByHolderName(String accountHolderName) {
        return accounts.stream().filter(account -> account.getHolderName().equals(accountHolderName)).findFirst().orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
        return accounts.stream().filter(account -> account.getNumber().equals(s)).findFirst().orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        if (account != null) {
            accounts.remove(account);
        }
    }
}
