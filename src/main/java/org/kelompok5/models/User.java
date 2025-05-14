package org.kelompok5.models;

// User.java (Abstract Class)
public abstract class User {
    public String nama, nim, id;
    private String password;
    private double nilai;

    public User(String id, String nama, String nim, String password, double nilai) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
        this.password = password;
    }

    // Abstract method (polymorphism)
    public abstract void showInfo();

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public double getNilai() {
        return nilai;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
