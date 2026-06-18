package com.bank.util;

import com.bank.model.Account;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileService {
    public void saveAccount(String data) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    "data/accounts.txt",
                                    true
                            )
                    );

            writer.write(data);

            writer.newLine();

            writer.close();

            System.out.println("Account saved to file");

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }



    }
    public ArrayList<String> readAccounts() {

        ArrayList<String> accounts =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/accounts.txt"
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                accounts.add(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        return accounts;
    }
    public void overwriteAccounts(
            ArrayList<Account> accounts) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    "data/accounts.txt",
                                    false
                            )
                    );

            for (Account account : accounts) {

                String data =
                        account.getAccountNumber()
                                + ","
                                + account.getOwner().getName()
                                + ","
                                + account.getOwner().getNationalId()
                                + ","
                                + account.getBalance();

                writer.write(data);

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
