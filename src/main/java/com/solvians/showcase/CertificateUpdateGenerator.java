package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<CertificateUpdate> updateList = new ArrayList<>();
        for (int i = 0; i < threads * quotes; i++) {
            CertificateUpdate update = new CertificateUpdate();
            update.setId(random.nextInt(1, 1000));
            update.setName("Quote " + random.nextInt(1, 1000));
            updateList.add(update);
        }

        return updateList.stream().parallel();
    }
}
