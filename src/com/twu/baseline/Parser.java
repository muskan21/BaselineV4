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
}
