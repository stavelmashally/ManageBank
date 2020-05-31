package application.model;
import java.util.Date;

public class Transaction {

    private int transactionId;
    private Date transactionDate;
    private double amount;
    private String status;
    private String transactionType;
    private int fromAccount;
    private int toAccount;

    public Transaction(int transactionId, Date transactionDate, double amount, String status, String transactionType, int fromAccount, int toAccount) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.status = status;
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Transaction(double amount, String transactionType, int fromAccount, int toAccount) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Transaction(){

    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
