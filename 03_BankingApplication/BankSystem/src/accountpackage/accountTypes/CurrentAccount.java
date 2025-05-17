package accountpackage.accountTypes;

import accountpackage.Account;
import accountpackage.AccountOperations;

public class CurrentAccount extends Account implements AccountOperations {

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient Balance !!");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public double viewBalance() {
        return super.getBalance();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public String showAccountType() {
        return "This is a Current Account.";
    }
}
