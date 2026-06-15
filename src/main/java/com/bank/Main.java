package com.bank;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.service.BankService;

public class Main {
    public  static  void main(String[] args){

        User user = new User("Sara", "1234567890" );
        Account account = new Account("ACC1001", user);
        User secondUser= new User("Hamid", "9876543210");
        Account secondAccount = new Account("ACC2001", secondUser);
        BankService bankService = new BankService();
        bankService.createAccount(account);
        bankService.createAccount(secondAccount);
        account.deposit(500);

        try {

            account.withdraw(200);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Current Balance: " + account.getBalance());


        Account foundAccount = bankService.findAccount("ACC1001");
        if (foundAccount != null){
            System.out.println("Account found: "+ foundAccount.getAccountNumber());
        }
        bankService.transfer("ACC1001", "ACC2001", 1000);
        System.out.println("First Account Balance: " + account.getBalance());

        System.out.println("Second Account Balance: " + secondAccount.getBalance());
        System.out.println("Transaction History:");
        account.printTransactionHistory();
    }

}
