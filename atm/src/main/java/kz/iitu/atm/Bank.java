package kz.iitu.atm;

import java.util.ArrayList;
import java.util.List;

public class Bank implements BankService {
    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void checkBalance(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber)
                System.out.println("Your balance is " + accounts.get(i).getBalance());
        }
    }

    @Override
    public void withdraw(int accountNumber, int amount) {
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountNumber() == accountNumber && accounts.get(i).getBalance() >= amount) {
                System.out.println("Withdraw succesfull");
                accounts.get(i).setBalance(accounts.get(i).getBalance() - amount);
            }else
                System.out.println("Balance is less than amount");
        }
    }

    @Override
    public void topUp(int accountNumber, int top) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber)
                accounts.get(i).setBalance(accounts.get(i).getBalance() + top);
        }
    }

    public boolean checkAccount(int accountNumber, int currentCin) {
        boolean ans;
        for (int i = 0; i < accounts.size(); i++) {
            if((accounts.get(i).getAccountNumber() == accountNumber) && accounts.get(i).getPin() == currentCin){
                ans == true;
            }else
                ans == false;
        }
        return ans;
    }

    public void changePin(int accountNumber, int oldPin, int newPin) {
        for (int i = 0; i < accounts.size(); i++) {
            if((accounts.get(i).getAccountNumber() == accountNumber) && accounts.get(i).getPin() == oldPin){
                accounts.get(i).setPin(newPin);
            }else
                System.out.println("Error");
        }
    }
}
