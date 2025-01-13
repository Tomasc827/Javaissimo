import java.math.BigDecimal;
import java.util.ArrayList;

public class NewAccountClass extends Account{
    private ArrayList<Transaction> transactions;
    private String name;

    public NewAccountClass(String name, int id, BigDecimal balance) {
        super(id,balance);
        this.name = name;
        this.transactions = new ArrayList<>();
    }
    @Override
    public BigDecimal withdraw(BigDecimal amount) {
        BigDecimal newBalance = super.withdraw(amount);
        transactions.add(new Transaction('W',amount,newBalance,"Withdrawal"));
        return newBalance;
    }
    @Override
    public BigDecimal deposit(BigDecimal amount) {
        BigDecimal newBalance = super.deposit(amount);
        transactions.add(new Transaction('D', amount, newBalance,"Deposit"));
        return newBalance;
    }



    public String printInfo(){
        System.out.println();
        System.out.println(" Name: " + this.name + "\n ID: " + getId() + "\n Annual interest rate  " + getAnnualInterestRate() + "%" + "\n Current balance: " + getBalance());
        for(Transaction one : transactions) {
            System.out.println(one);
        }
        return "";
    }

}
