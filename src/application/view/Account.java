package application.view;

import java.util.StringJoiner;

public class Account {
    private long accountNo;
    private String name;
    private String creationDate;
    private String type;
    private double amount;

    public Account() {
    }

    public Account(long accountNo, String name, String creationDate, String type, double amount) {
        this.accountNo = accountNo;
        this.name = name;
        this.creationDate = creationDate;
        this.type = type;
        this.amount = amount;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
