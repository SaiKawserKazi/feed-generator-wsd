package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CertificateUpdateGeneratorTest {

    @Test
    public void generateQuotes_shouldReturnExpectedCount() {
        int threads = 2;
        int quotesPerThread = 5;

        CertificateUpdateGenerator generator = new CertificateUpdateGenerator(threads, quotesPerThread);
        Stream<CertificateUpdate> quotes = generator.generateQuotes();

        assertNotNull(quotes);
        assertEquals(threads * quotesPerThread, quotes.count());
    }
}
