package com.bank.model;

public class Account {
    private String accountNumber;
    private  double balance;
    private  User owner;


    public Account(String accountNumber, User owner){

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }


    public  String getAccountNumber(){
        return accountNumber;

    }

    public double getBalance(){
        return balance;
    }

    public User getOwner(){
        return  owner;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public  void withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }
}
