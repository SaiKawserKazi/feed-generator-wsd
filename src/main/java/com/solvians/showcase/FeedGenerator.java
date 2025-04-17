package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FeedGenerator {
    private final int numThreads;
    private final int numQuotes;

    public FeedGenerator(int numThreads, int numQuotes) {
        this.numThreads = numThreads;
        this.numQuotes = numQuotes;
    }

    public List<String> generate() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < numQuotes; i++) {
            futures.add(executor.submit(new CertificateUpdateTask()));
        }

        List<String> results = new ArrayList<>();
        for (Future<String> future : futures) {
            results.add(future.get());
        }

        executor.shutdown();
        return results;
    }
}
