package application.model;
import java.util.Date;

public class BankAccount {

    private int  accountNo;
    private int customerId;
    private double balance;
    private Date creationDate;
    private String accountType;

    public BankAccount(int customerId, Date creationDate, String accountType) {
        this.customerId = customerId;
        this.creationDate = creationDate;
        this.accountType = accountType;
    }

    public BankAccount(){
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
