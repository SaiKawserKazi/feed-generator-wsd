package com.solvians.showcase;


public class CertificateUpdate {

    private String name;
    private int id;

    public CertificateUpdate() {
        this.name = "Default";
        this.id = 0;
    }

    @Override
    public String toString() {
        return "CertificateUpdate{id=" + id + ", name='" + name + "'}";
    }
}
