package com.bank;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.service.BankService;

public class Main {
    public  static  void main(String[] args){

        User user = new User("Sara", "1234567890" );
        Account account = new Account("Acc1001", user);
        BankService bankService = new BankService();
        bankService.createAccount(account);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Current Balance: " + account.getBalance());


        Account foundAccount = bankService.findAccount("ACC1001");
        if (foundAccount != null){
            System.out.println("Account found: "+ foundAccount.getAccountNumber());
        }


    }

}
