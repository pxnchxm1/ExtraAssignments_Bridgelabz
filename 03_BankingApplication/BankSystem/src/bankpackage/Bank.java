package bankpackage;

import accountpackage.Account;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    private String bankName;
    private String branchName;
    private  static int count;
    private final String bankCode;
    private List<Account> accounts = new ArrayList<>();
    public Bank(String bankName, String branchName){
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = generateCode();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String generateCode(){
        return "Bank-"+count++;
    }
    public Account getAccountByNumber(String number){
        for(Account a : accounts){
            if(a.getAccountNumber().equals(number)){
                return a;
            }
        }return null;
    }
    public abstract void openAccount(Account acc);
    public abstract void displayBankInfo();


}
