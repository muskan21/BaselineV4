package com.twu.baseline;

public class Parser {
    private String input;

    public Parser(String input) {
        this.input = input;
    }

    public String[] tokenise() {
        return input.split(" ");
    }
}
