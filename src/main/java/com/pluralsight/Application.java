package com.pluralsight;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        ArrayList<Transaction> transactions = readTransactions();

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader("transactions.csv");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(Pattern.quote("|"));
                System.out.println(line);

                Transaction transaction = new Transaction();

//                String employeeIdAsString = parts[0];
//                int employeeId = Integer.parseInt(employeeIdAsString);
//                transactions.setEmployeeId(employeeId);
//
//                String name = parts[1];
//                transactions.setName(name);
//
//                String hoursWorkedAsString = parts[2];
//                double hoursWorked = Double.parseDouble(hoursWorkedAsString);
//                transactions.setHoursWorked(hoursWorked);
//
//                String payRateAsString = parts[3];
//                double payRate = Double.parseDouble(payRateAsString);
//                transactions.setPayRate(payRate);

                transactions.add(transaction) ;

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;

    }
}
