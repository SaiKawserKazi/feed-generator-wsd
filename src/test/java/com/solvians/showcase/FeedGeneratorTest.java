package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FeedGeneratorTest {

    @Test
    void testGenerateMultipleQuotes() throws Exception {
        FeedGenerator generator = new FeedGenerator(4, 5);
        List<String> results = generator.generate();

        assertEquals(5, results.size());
        for (String result : results) {
            assertTrue(result.matches("\\d{13},[A-Z]{2}\\w{9}\\d,\\d+\\.\\d{2},\\d+,\\d+\\.\\d{2},\\d+"));
        }
    }
}

