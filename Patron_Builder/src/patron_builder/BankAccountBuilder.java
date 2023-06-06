/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_builder;

/**
 *
 * @author HP
 */
public class BankAccountBuilder implements IBuilder {

    private long accountNumber;
    private String owner;
    private String type;
    private double balance;
    private double interestRate;

    public BankAccountBuilder(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountBuilder withOwner(String owner) {
        this.owner = owner;
        return this;  //By returning the builder each time, we can create a fluent interface.
    }
    
    public BankAccountBuilder withAccountBuilder(String type) {
        this.type = type;
        return this;
    }
    
    public BankAccountBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public BankAccountBuilder withRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    @Override
    public BankAccount build() {
        BankAccount account = new BankAccount();
        account.setAccountNumber(this.accountNumber);
        account.setOwner(this.owner);
        //account.set(this.type);
        account.setBalance(this.balance);
        account.setInterestRate(this.interestRate);
        return account;
    }


}
