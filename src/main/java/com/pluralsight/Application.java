package com.pluralsight;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = readTransactions();

    public static void main(String[] args) {

            runMainMenu();
            scanner.close();
    }

    // Main menu loop
    public static void runMainMenu() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    runLedger();
                    break;
                case"X":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing

        }
    }

    // Display menu
    public static void displayMenu() {
        System.out.println("""
                ======= Main Menu =======
                (D) Add Deposit
                (P) Make Payment (Debit)
                (L) Display Ledger Screen
                (X) Exit""");
    }

    public static void addDeposit(){

        try {
            System.out.print("Add deposit amount: ");

            // create a FileWriter
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // create a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            double userDepositAmount = 0;
            Transaction transaction = null;
            try {
                userDepositAmount = scanner.nextDouble();
                scanner.nextLine();
                transaction = new Transaction(LocalDate.now(),
                        LocalTime.now(),
                        "Deposit",
                        "User",
                        userDepositAmount
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            bufferedWriter.write(transaction.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }

    private static void makePayment() {

        try {
            System.out.print("Add payment amount: ");

            // create a FileWriter
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // create a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            double userPaymentAmount = 0;
            Transaction transaction = null;
            try {
                userPaymentAmount = scanner.nextDouble();
                scanner.nextLine();
                transaction = new Transaction(LocalDate.now(),
                        LocalTime.now(),
                        "Payment",
                        "User",
                        -userPaymentAmount
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            bufferedWriter.write(transaction.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }

    // Ledger loop
    public static void runLedger() {
        boolean running = true;

        while (running) {
            displayLedger();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase(); // normalize input

            switch (choice) {
                case "A":
                    displayAllEntries();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    runReports();
                    break;
                case "H":
                    System.out.println("Exiting to Home Screen...");
                    running = false;

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing
        }
    }

    public static void displayLedger() {
        System.out.println("""
                ========= Ledger =========
                (A) Display All Entries
                (D) Display deposits
                (P) Display payments
                (R) Reports
                (H) Home Page""");
    }

    // Menu actions
    // Display All Entries
    public static void displayAllEntries() {

        for (Transaction transaction : transactions) {
            System.out.println(transaction);

        }
    }

    // Display Deposits
    public static void displayDeposits() {
        System.out.println(transactions);

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() >= 0) {
                System.out.println(transaction);

            }

        }

    }
    // Display Payments
    public static void displayPayments() {

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);

            }
        }
    }
    //Open Reports Menu
    public static void runReports() {
        boolean running = true;

        while (running) {
            displayReports();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    displayMonthToDate();
                    break;
                case "2":
                    displayPreviousMonth();
                    break;
                case"3":
                    displayYearToDate();
                    break;
                case"4":
                    displayPreviousYear();
                    break;
                case"5":
                    displayByVendor();
                    break;
                case"0":
                    System.out.println("Returining to Ledger Screen...");
                    runLedger();
                case "H":
                    System.out.println("Exiting to Home Screen...");
                    running = false;
                    runMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing
        }
    }
    public static void displayReports() {
        System.out.println("""
                ========= Reports =========
                (1) Display by Month to Date
                (2) Display Previous Month
                (3) Display Year to Date
                (4) Display Previous Year
                (5) Display by Vendor
                (0) Return to Ledger
                (H) Exit to Home Screen""");

    }

    public static void displayMonthToDate(){
        System.out.println("Month to Date");

    }
    public static void displayPreviousMonth(){
        System.out.println("Previous Month");

    }
    public static void displayYearToDate(){
        System.out.println("Year to Date");

    }
    public static void displayPreviousYear(){
        System.out.println("Previous Year");

    }
    public static void displayByVendor(){

        System.out.println("Enter vendor name: ");
        String searchVendor = scanner.nextLine().trim();

        boolean found = false;

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(searchVendor)) {
                System.out.println(transaction);
                found = true;
            }
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
                //might need sout here
                if(parts.length != 5) continue;

                Transaction transaction = new Transaction();

                String transactionDateAsString = parts[0];
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate transactionDate = LocalDate.parse(transactionDateAsString, formatter1);
                transaction.setTransactionDate(transactionDate);

                String transactionTimeAsString = parts[1];
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime transactionTime = LocalTime.parse(transactionTimeAsString, formatter2);
                transaction.setTransactionTime(transactionTime);

                String description = parts[2];
                transaction.setDescription(description);


                String vendor = parts[3];
                transaction.setVendor(vendor);

                String amountAsString = parts[4];
                double amount = Double.parseDouble(amountAsString);
                transaction.setAmount(amount);
                transactions.add(transaction);

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;

    }
}





