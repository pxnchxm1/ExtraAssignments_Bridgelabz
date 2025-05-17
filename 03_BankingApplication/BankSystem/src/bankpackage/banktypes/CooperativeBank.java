package bankpackage.banktypes;

import accountpackage.Account;
import bankpackage.Bank;

import java.sql.SQLOutput;

public class CooperativeBank extends Bank {
    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account acc) {
            getAccounts().add(acc);
    }

    @Override
    public void displayBankInfo() {
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name "+ " : "+getBankName());
        System.out.println("Branch "+ " : "+getBranchName());
        System.out.println("Bank Code : "+getBankCode());
        System.out.println(" --- Account Details ---");
        for(Account a : getAccounts()){
            System.out.println("Account Type : "+a.showAccountType());
            System.out.println("Holder : "+a.getAccountHolder());
            System.out.println("Account Number : "+a.getAccountNumber());
            System.out.println("Balance : ₹"+a.getBalance());
        }
    }
}
