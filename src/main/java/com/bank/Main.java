package com.bank;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankService();

        bankService.loadAccounts();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n=== BANK MENU ===");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter national ID: ");
                    String nationalId = scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();

                    User user =
                            new User(name, nationalId);

                    Account account =
                            new Account(accountNumber, user);

                    bankService.createAccount(account);

                    break;

                case 2:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String depositAccountNumber =
                            scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double depositAmount =
                            scanner.nextDouble();

                    Account depositAccount =
                            bankService.findAccount(
                                    depositAccountNumber
                            );

                    if (depositAccount != null) {

                        depositAccount.deposit(
                                depositAmount
                        );

                        bankService.saveAllAccounts();

                        System.out.println(
                                "Deposit successful"
                        );

                    } else {

                        System.out.println(
                                "Account not found"
                        );
                    }

                    break;

                case 3:

                    scanner.nextLine();

                    System.out.print(
                            "Enter account number: "
                    );

                    String withdrawAccountNumber =
                            scanner.nextLine();

                    System.out.print(
                            "Enter amount: "
                    );

                    double withdrawAmount =
                            scanner.nextDouble();

                    Account withdrawAccount =
                            bankService.findAccount(
                                    withdrawAccountNumber
                            );

                    if (withdrawAccount != null) {

                        try {

                            withdrawAccount.withdraw(
                                    withdrawAmount
                            );

                            bankService.saveAllAccounts();

                            System.out.println(
                                    "Withdraw successful"
                            );

                        } catch (Exception e) {

                            System.out.println(
                                    e.getMessage()
                            );
                        }

                    } else {

                        System.out.println(
                                "Account not found"
                        );
                    }

                    break;

                case 4:

                    scanner.nextLine();

                    System.out.print(
                            "From account: "
                    );

                    String fromAccount =
                            scanner.nextLine();

                    System.out.print(
                            "To account: "
                    );

                    String toAccount =
                            scanner.nextLine();

                    System.out.print(
                            "Enter amount: "
                    );

                    double transferAmount =
                            scanner.nextDouble();

                    bankService.transfer(
                            fromAccount,
                            toAccount,
                            transferAmount
                    );

                    bankService.saveAllAccounts();

                    break;

                case 5:

                    scanner.nextLine();

                    System.out.print(
                            "Enter account number: "
                    );

                    String balanceAccountNumber =
                            scanner.nextLine();

                    Account balanceAccount =
                            bankService.findAccount(
                                    balanceAccountNumber
                            );

                    if (balanceAccount != null) {

                        System.out.println(
                                "Current Balance: "
                                        + balanceAccount.getBalance()
                        );

                    } else {

                        System.out.println(
                                "Account not found"
                        );
                    }

                    break;

                case 6:

                    scanner.nextLine();

                    System.out.print(
                            "Enter account number: "
                    );

                    String historyAccountNumber =
                            scanner.nextLine();

                    Account historyAccount =
                            bankService.findAccount(
                                    historyAccountNumber
                            );

                    if (historyAccount != null) {

                        historyAccount
                                .printTransactionHistory();

                    } else {

                        System.out.println(
                                "Account not found"
                        );
                    }

                    break;

                case 7:

                    running = false;

                    System.out.println(
                            "Goodbye"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid option"
                    );
            }
        }

        scanner.close();
    }
}