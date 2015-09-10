package com.twu.baseline;

public class Parser {
    private String input;

    public Parser(String input) {
        this.input = input;
    }

    public String[] tokenise() {
        return input.split(" ");
    }

    public String itemName(String[] inputTokens) {
        String itemname = "";
        for(int count = 0; count < inputTokens.length - 2; count++)
            itemname = itemname + inputTokens[count] + " ";
        return itemname;
    }

    public double itemPrice(String[] inputTokens) {
        double price = Double.NaN;
        try {
            price = Double.parseDouble(inputTokens[inputTokens.length - 1]);
        }
        catch (NumberFormatException e) {
        }
        finally {
            return price;
        }
    }

    public double getTaxPercentage(String itemName) {
        if(itemName.toLowerCase().contains("book") || itemName.toLowerCase().contains("pills") || itemName.toLowerCase().contains("chocolate"))
            return 0;
        else
            return 10;
    }

    public double getImportDuty(String itemNAme) {
        if(itemNAme.toLowerCase().contains("imported"))
            return 5;
        else
            return 0;
    }

    public Item parse() {
        Item item = new Item(itemName(tokenise()), itemPrice(tokenise()), getTaxPercentage(itemName(tokenise())), getImportDuty(itemName(tokenise())));
        return item;
    }
}
