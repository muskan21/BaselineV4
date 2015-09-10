package com.twu.baseline;

public class Item {
    private String itemName;
    private double itemPrice;
    private double taxPercentage;
    private double importDuty;

    public Item(String itemName, double itemPrice, double taxPercentage, double importDuty) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.taxPercentage = taxPercentage;
        this.importDuty = importDuty;
    }

    public double calculateSalesTax() {
        return 0;
    }
}
