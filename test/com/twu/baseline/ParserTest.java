package com.twu.baseline;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void shouldTokeniseTheInputToReturnTokens() {
        Parser parser = new Parser("1 box of chocolates at 12.49");
        String[] inputTokens = parser.tokenise();

        assertArrayEquals(new String[]{"1", "box", "of", "chocolates", "at", "12.49"}, inputTokens);
    }

    @Test
    public void shouldReturnAppropriateSetTokensToGiveItemNAme() {
        Parser parser = new Parser("1 box of chocolates at 12.49");
        String itemName = parser.itemName(new String[]{"1", "box", "of", "chocolates", "at", "12.49"});

        assertEquals("1 box of chocolates ", itemName);
    }

    @Test
    public void shouldReturnAppropriatePriceOfTheItemFromGivenInput() {
        Parser parser = new Parser("1 box of chocolates at 12.49");
        double itemprice = parser.itemPrice(new String[]{"1", "box", "of", "chocolates", "at", "12.49"});

        assertEquals(12.49, itemprice, 0.01);
    }

    @Test
    public void shouldReturnNanIfLastTokenIsNotPrice() {
        Parser parser = new Parser("1 box of chocolates");
        double itemprice = parser.itemPrice(new String[]{"1", "box", "of", "chocolates"});

        assertEquals(Double.NaN, itemprice, 0.01);
    }

    @Test
    public void shouldReturnZeroTaxPercentageForBookItems() {
        Parser parser = new Parser("1 book at 12.49");
        double taxPercentage = parser.getTaxPercentage("1 book ");

        assertEquals(0, taxPercentage, 0.01);
    }

    @Test
    public void shouldReturnZeroTaxPercentageForFoodItems() {
        Parser parser = new Parser("1 box of chocolates at 12.49");
        double taxPercentage = parser.getTaxPercentage("1 box of chocolates ");

        assertEquals(0, taxPercentage, 0.01);
    }

    @Test
    public void shouldReturnZeroTaxPercentageForHealthItems() {
        Parser parser = new Parser("1 packet of health pills at 9.75");
        double taxPercentage = parser.getTaxPercentage("1 packet of health pills ");

        assertEquals(0, taxPercentage, 0.01);
    }

    @Test
    public void shouldReturnTenTaxPercentageForAnyOtherItem() {
        Parser parser = new Parser("1 imported bottle of perfume at 47.50");
        double taxPercentage = parser.getTaxPercentage("1 imported bottle of perfume ");

        assertEquals(10, taxPercentage, 0.01);
    }

    @Test
    public void shouldReturnFivePercentageImportDutyForImportedItems() {
        Parser parser = new Parser("1 imported bottle of perfume at 47.50");
        double importDuty = parser.getImportDuty("1 imported bottle of perfume ");

        assertEquals(5, importDuty, 0.01);
    }

    @Test
    public void shouldReturnZeroPercentageImportDutyForNonImportedItems() {
        Parser parser = new Parser("1 bottle of perfume at 47.50");
        double importDuty = parser.getImportDuty("1 bottle of perfume ");

        assertEquals(0, importDuty, 0.01);
    }

    @Test
    public void shouldParseInputToReturnItemObject() {
        Parser parser = new Parser("1 bottle of perfume at 47.50");
        Item item = parser.parse();

        assertEquals(Item.class, item.getClass());
    }
}
