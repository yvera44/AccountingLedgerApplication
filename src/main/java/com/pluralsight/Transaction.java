package com.pluralsight;

public class Transaction {

    private String transactionDate;
    private String itemType;
    private String descriptions;
    private String vendorName;
    private double itemPrice;

    public Transaction() {
        this.transactionDate = "";
        this.itemType = "";
        this.descriptions = "";
        this.vendorName = "";
        this.itemPrice = 0;
    }

//constructor
    public Transaction(String transactionDate, String itemType, String descriptions, String vendorName, double itemPrice) {
        this.transactionDate = transactionDate;
        this.itemType = itemType;
        this.descriptions = descriptions;
        this.vendorName = vendorName;
        this.itemPrice = itemPrice;
    }

//getters and setters
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("transactionDate='").append(transactionDate).append('\'');
        sb.append(", itemType='").append(itemType).append('\'');
        sb.append(", descriptions='").append(descriptions).append('\'');
        sb.append(", vendorName='").append(vendorName).append('\'');
        sb.append(", itemPrice=").append(itemPrice);
        sb.append('}');
        return sb.toString();
    }
}

