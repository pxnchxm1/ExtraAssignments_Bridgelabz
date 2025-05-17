import accountpackage.Account;
import accountpackage.AccountOperations;
import accountpackage.accountTypes.CurrentAccount;
import accountpackage.accountTypes.LoanAccount;
import accountpackage.accountTypes.SavingsAccount;
import bankpackage.Bank;
import bankpackage.banktypes.CooperativeBank;
import bankpackage.banktypes.NationalizedBank;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank;

        System.out.print("Enter bank name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter branch name: ");
        String branchName = sc.nextLine();

        System.out.println("Type of Bank?");
        System.out.println("1 - Nationalized Bank");
        System.out.println("2 - Cooperative Bank");
        System.out.print("Enter your choice (1/2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        if (choice == 2) {
            bank = new CooperativeBank(bankName, branchName);
        } else {
            bank = new NationalizedBank(bankName, branchName);
        }

        int ch;
        do {
            System.out.println("\n1 - Open Account");
            System.out.println("2 - View Balance");
            System.out.println("3 - Deposit Amount");
            System.out.println("4 - Withdraw Amount");
            System.out.println("5- Display Bank Info");
            System.out.println("6- Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (ch) {
                case 1: {
                    System.out.print("Enter holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    System.out.println("Enter type of account:");
                    System.out.println("1 - SavingsAccount");
                    System.out.println("2 - CurrentAccount");
                    System.out.println("3 - LoanAccount");
                    int accountType = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (accountType) {
                        case 1:
                            bank.openAccount(new SavingsAccount(number,name, balance));
                            break;
                        case 2:
                            bank.openAccount(new CurrentAccount(number,name, balance));
                            break;
                        case 3:
                            bank.openAccount(new LoanAccount(number,name, balance));
                            break;
                        default:
                            System.out.println("Invalid account type!");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    Account acc = bank.getAccountByNumber(accNo);
                    if (acc != null) {
                        System.out.println("Account balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    Account acc = bank.getAccountByNumber(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        if(acc instanceof AccountOperations){
                            ((AccountOperations) acc).deposit(amt);
                            System.out.println("Deposit successful. New Balance: ₹" + acc.getBalance());

                        }
                       } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    Account acc = bank.getAccountByNumber(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        if(acc instanceof  AccountOperations){
                            ((AccountOperations)acc).withdraw(amt);
                            System.out.println("Withdrawal successful. New Balance: ₹" + acc.getBalance());

                        }

                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 5 : {
                    bank.displayBankInfo();
                }break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (ch != 6);
    }
}
