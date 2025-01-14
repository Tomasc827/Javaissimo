import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1122,new BigDecimal("20000.00"));
        Transaction transaction = new Transaction('W',new BigDecimal(100), new BigDecimal(100),"Nice");
        account.setAnnualInterestRate(new BigDecimal("4.5"));
        account.withdraw(new BigDecimal("2500.00"));
        account.deposit(new BigDecimal("3000.00"));
        Checking acc = new Checking();
        acc.setBalance(new BigDecimal("1000.00"));
        acc.setAnnualInterestRate(new BigDecimal("4.5"));
        try {
            acc.withdraw(new BigDecimal("1501"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(acc);
        NewAccountClass acc2 = new NewAccountClass("Cheesus Christ", 420, new BigDecimal("1000.00"));
        acc2.setAnnualInterestRate(new BigDecimal("69.69"));
        acc2.deposit(new BigDecimal("30.00"));
        acc2.deposit(new BigDecimal("40.00"));
        acc2.deposit(new BigDecimal("50.00"));
        acc2.withdraw(new BigDecimal("5.00"));
        acc2.withdraw(new BigDecimal("4.00"));
        acc2.withdraw(new BigDecimal("2.00"));

        System.out.println(acc2.printInfo());
        System.out.println(transaction.realShit());
    }
}