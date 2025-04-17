package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testMainWithValidArgs() {
        String[] args = {"5", "10"};
        final PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        App.main(args);

        String output = baos.toString();
        assertTrue(output.contains("Generating 10 certificate updates using 5 threads"));
        System.setOut(originalOut);
    }

    @Test
    void testMainWithInvalidArgs() {
        String[] args = {"5"};
        final PrintStream originalErr = System.err;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(baos));

        App.main(args);

        String output = baos.toString();
        assertTrue(output.contains("Expect at least number of threads and number of quotes. But got: 1"));

        System.setErr(originalErr);
    }
}
