package com.bank.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
}
