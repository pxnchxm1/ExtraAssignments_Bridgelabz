package accountpackage.accountTypes;

import accountpackage.Account;
import accountpackage.AccountOperations;

public class SavingsAccount  extends Account implements AccountOperations {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(amount+super.getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if(this.getBalance()<amount){
            System.out.println("Insufficient Balance !! ");
        }else{
            super.setBalance(super.getBalance()-amount);
        }
    }

    @Override
    public double viewBalance() {
        return super.getBalance();
    }
    @Override
    public String showAccountType(){
        return "This is Savings Account ";
    }
}
