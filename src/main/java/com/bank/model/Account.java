package com.bank.model;
import com.bank.exception.InsufficientBalanceException;
import java.util.ArrayList;
import com.bank.model.Transaction;

public class Account {
    private String accountNumber;
    private  double balance;
    private  User owner;
    private ArrayList<Transaction> transactions = new ArrayList<>();

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

    public void deposit(double amount) {

        balance += amount;

        Transaction transaction =
                new Transaction("Deposit", amount);

        transactions.add(transaction);
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance"
            );
        }

        balance -= amount;

        Transaction transaction =
                new Transaction("Withdraw", amount);

        transactions.add(transaction);
    }

    public void printTransactionHistory() {

        for (Transaction transaction : transactions) {

            System.out.println(
                    transaction.getType()
                            + " : "
                            + transaction.getAmount()
            );
        }
    }
}
