package com.bank;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.service.BankService;
import com.bank.util.FileService;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        BankService bankService =
                new BankService();

        bankService.loadAccounts();

        Scanner scanner =
                new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n=== BANK MENU ===");

            System.out.println("1. Create Account");
            System.out.println("2. Exit");

            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name =
                            scanner.nextLine();

                    System.out.print("Enter national ID: ");
                    String nationalId =
                            scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String accountNumber =
                            scanner.nextLine();

                    User user =
                            new User(name, nationalId);

                    Account account =
                            new Account(accountNumber, user);

                    bankService.createAccount(account);

                    break;

                case 2:

                    running = false;

                    System.out.println("Goodbye");

                    break;

                default:

                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }
}