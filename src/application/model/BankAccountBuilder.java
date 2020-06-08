package application.model;


public class BankAccountBuilder {

    private int customerId;
    private String accountType;
    private int accountNo;

    public BankAccountBuilder withCustomerId(int id){
        this.customerId = id;
        return this;
    }

    public BankAccountBuilder withAccountType(String type){
        this.accountType = type;
        return this;
    }

    public  BankAccountBuilder withAccountNo(int accountNo){
        this.accountNo = accountNo;
        return this;
    }

    public BankAccount build(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCustomerId(this.customerId);
        bankAccount.setAccountType(this.accountType);
        bankAccount.setAccountNo(this.accountNo);
        return bankAccount;
    }
}
