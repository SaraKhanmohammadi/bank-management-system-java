package com.bank.service;
import com.bank.model.Account;
import java.util.ArrayList;
import com.bank.util.FileService;

public class BankService {

    private ArrayList<Account> accounts = new ArrayList<>();
    private FileService fileService = new FileService();
    public void createAccount(Account account) {
        accounts.add(account);
        String data =
                account.getAccountNumber()
                        + ","
                        + account.getOwner().getName();

        fileService.saveAccount(data);
        System.out.println("Account created successfully");
    }


    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Account not found");
            return;
        }
        try {

            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
