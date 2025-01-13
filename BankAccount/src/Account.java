import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Account {
    private int id;
    private BigDecimal balance;
    private BigDecimal annualInterestRate;
    private Date dateCreated;


    public Account(){
        this.id = 0;
        this.balance = BigDecimal.ZERO;
        this.annualInterestRate = BigDecimal.ZERO;
        this.dateCreated = new Date();

    }

    public Account( int id, BigDecimal balance) {
        if (id < 0 ) {
            throw new IllegalArgumentException("Id cannot have negative value");
        }
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Starting balance cannot be negative");
        }
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = BigDecimal.ZERO;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public BigDecimal getMonthlyInterestRate(){
            return this.annualInterestRate.divide(new BigDecimal(12),2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getMonthlyInterest() {
        return this.annualInterestRate.divide(new BigDecimal("100"), 10, RoundingMode.HALF_EVEN)
                .divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);
    }

    public BigDecimal withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        if (amount.compareTo(this.balance) > 0 ) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }
    public BigDecimal deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        this.balance = balance.add(amount);

        return this.balance;
    }

    public String toString() {
        return this.balance + " " + getMonthlyInterest() + " " + this.dateCreated;
    }
}
