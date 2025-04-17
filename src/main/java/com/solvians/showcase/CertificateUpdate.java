package com.solvians.showcase;


public class CertificateUpdate {

    private String name;
    private int id;

    public CertificateUpdate() {
        this.name = "Default";
        this.id = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "CertificateUpdate{id=" + id + ", name='" + name + "'}";
    }
}
