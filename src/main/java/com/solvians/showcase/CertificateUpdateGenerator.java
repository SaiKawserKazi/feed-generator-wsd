package com.solvians.showcase;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {

    private final int threads;
    private final int quotesPerThread;

    public CertificateUpdateGenerator(int threads, int quotesPerThread) {
        this.threads = threads;
        this.quotesPerThread = quotesPerThread;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        int total = threads * quotesPerThread;
        return IntStream.range(0, total)
                .mapToObj(i -> {
                    CertificateUpdate update = new CertificateUpdate();
                    update.setId(i);
                    update.setName("Certificate-" + i);
                    return update;
                });
    }
}
