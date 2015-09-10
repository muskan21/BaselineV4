package com.twu.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void shouldReturnZeroSalesTaxForImportedNonExemptedItems() {
        Item item = new Item("1 bottle of perfume ", 47.50, 0, 0);
        double salesTax = item.calculateSalesTax();

        assertEquals(0, salesTax, 0.01);
    }

    @Test
    public void shouldReturn5PercentSalesTaxForImportedNonExemptedItems() {
        Item item = new Item("1 imported bottle of perfume ", 47.50, 0, 5);
        double salesTax = item.calculateSalesTax();

        assertEquals(2.375, salesTax, 0.01);
    }
}
