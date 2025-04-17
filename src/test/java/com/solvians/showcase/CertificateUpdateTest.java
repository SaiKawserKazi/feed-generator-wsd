package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CertificateUpdateTest {

    @Test
    public void testCertificateUpdateDefaultValues() {
        CertificateUpdate update = new CertificateUpdate();
        assertNotNull(update);
    }
}
