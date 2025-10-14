package com.pluralsight;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions;

    public static void main(String[] args) {

         transactions = readTransactions();

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

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
                    displayLedger();
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
        System.out.println("===== Main Menu =====");
        System.out.println("(D) Add Deposit");
        System.out.println("(P) Make Payment (Debit)");
        System.out.println("(L) Display Ledger Screen");
        System.out.println("(X) Exit");
    }

    public static void addDeposit(){
        System.out.print("Add deposit: ");
        int transaction = scanner.nextInt();
        scanner.nextLine(); //eats the carriage return

        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // create a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // write to the file
            bufferedWriter.write(transaction);
            // close the writer
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }

    // Main menu loop
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
                    displayReports();
                    break;
                case "H":
                    System.out.println("Exiting to Home Screen");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // blank line for spacing
        }
    }

    public static void displayLedger() {
        System.out.println("===== Ledger =====");
        System.out.println("(A) Display All Entries");
        System.out.println("(D) Display only the entries that re deposits into the account");
        System.out.println("(P) Display only the negative entries or payments");
        System.out.println("(R) Reports");
        System.out.println("(H) Go Back to Home Page..");
    }

    // Example menu actions
    public static void displayAllEntries() {
        for (Transaction transaction : transactions) {
            System.out.println(transactions.toString());
        }
    }

    public static void displayDeposits() {

    }
    public static void displayPayments() {

    }
    public static void displayReports() {

    }
    private static void makePayment() {
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

                String description = parts[2];
                transaction.setDescription(description);
//                OR
//                employee.setName(parts[1]);


//                String hoursWorkedAsString = parts[2];
//                double hoursWorked = Double.parseDouble(hoursWorkedAsString);
//                employee.setHoursWorked(hoursWorked);
////                OR
//                employee.setHoursWorked(Double.parseDouble(parts[2]));


            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;

    }
}





