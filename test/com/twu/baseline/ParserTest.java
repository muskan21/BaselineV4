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
}
