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
}
