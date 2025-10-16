package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String description;
    private String vendor;
    private double amount;

    public Transaction() {
        this.transactionDate = null;
        this.transactionTime = null;
        this.description = "";
        this.vendor = "";
        this.amount = 0;
    }


    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String description, String vendor, double amount) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%-12s  %s-12 %-27s  %-20s  %.2f",
                transactionDate,
                transactionTime,
                description,
                vendor,
                amount
        );
    }
    public void add(Transaction transaction) {
    }
}

