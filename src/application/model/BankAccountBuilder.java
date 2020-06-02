package application.model;


public class BankAccountBuilder {

    private int customerId;
    private String accountType;

    public BankAccountBuilder withCustomerId(int id){
        this.customerId = id;
        return this;
    }

    public BankAccountBuilder withAccountType(String type){
        this.accountType = type;
        return this;
    }

    public BankAccount build(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCustomerId(this.customerId);
        bankAccount.setAccountType(this.accountType);
        return bankAccount;
    }
}
