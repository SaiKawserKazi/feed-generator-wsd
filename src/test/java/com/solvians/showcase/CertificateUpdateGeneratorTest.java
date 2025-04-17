package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CertificateUpdateGeneratorTest {

    @Test
    public void generateQuotes() {
        int threads = 10;
        int quotes = 100;

        CertificateUpdateGenerator cerUpGen = new CertificateUpdateGenerator(threads, quotes);
        Stream<CertificateUpdate> quotesStream = cerUpGen.generateQuotes();

        assertNotNull(quotesStream);
        assertEquals(threads * quotes, quotesStream.count());
    }
}

