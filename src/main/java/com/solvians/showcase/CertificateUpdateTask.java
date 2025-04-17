package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdateTask implements Callable<String> {

    @Override
    public String call() {
        long timestamp = System.currentTimeMillis();
        String isin = ISINGenerator.generateISIN();
        double bidPrice = 100.00 + ThreadLocalRandom.current().nextDouble() * 100.00;
        int bidSize = 1000 + ThreadLocalRandom.current().nextInt(4000);
        double askPrice = 100.00 + ThreadLocalRandom.current().nextDouble() * 100.00;
        int askSize = 1000 + ThreadLocalRandom.current().nextInt(9000);
        LocalDate maturityDate = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(730));

        return String.format("%d,%s,%.2f,%d,%.2f,%d", timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }
}
