package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CertificateUpdateTaskTest {

    @Test
    void testGenerateCertificateUpdate() throws Exception {
        CertificateUpdateTask task = new CertificateUpdateTask();
        String result = task.call();

        System.out.println("Generated result: " + result);

        assertTrue(result.matches("\\d{13},[A-Z0-9]{12},\\d+\\.\\d{2},\\d+,\\d+\\.\\d{2},\\d+"));
    }

}

