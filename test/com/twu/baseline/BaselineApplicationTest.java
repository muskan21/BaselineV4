package com.twu.baseline;

import org.junit.Test;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class BaselineApplicationTest {

    @Test
    public void shouldAcceptInputFromTheConsole() {
        BaselineApplication baselineApplication = new BaselineApplication();
        ByteArrayInputStream in = new ByteArrayInputStream("Input".getBytes());
        System.setIn(in);

        String input = baselineApplication.acceptInput();

        assertEquals("Input", input);
        System.setIn(System.in);
    }
}
