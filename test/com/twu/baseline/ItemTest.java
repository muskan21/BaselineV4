package com.twu.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void shouldReturnZeroSalesTaxForNonImportedExemptedItems() {
        Item item = new Item("1 box of chocolates ", 47.50, 0, 0);
        double salesTax = item.calculateSalesTax();

        assertEquals(0, salesTax, 0.01);
    }

    @Test
    public void shouldReturn5PercentSalesTaxForImportedExemptedItems() {
        Item item = new Item("1 imported box of chocolates ", 47.50, 0, 5);
        double salesTax = item.calculateSalesTax();

        assertEquals(2.375, salesTax, 0.01);
    }

    @Test
    public void shouldReturnTenPercentSalesTaxForNonImportedNonExemptedItems() {
        Item item = new Item("1 bottle of perfume ", 0.85, 10, 0);
        double salesTax = item.calculateSalesTax();

        assertEquals(0.085, salesTax, 0.01);
    }

    @Test
    public void shouldReturnFifteenPercentSalesTaxForImportedNonExemptedItems() {
        Item item = new Item("1 imported bottle of perfume ", 27.99, 10, 5);
        double salesTax = item.calculateSalesTax();

        assertEquals(4.1985, salesTax, 0.01);
    }
}
