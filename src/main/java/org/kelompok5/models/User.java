package org.kelompok5.models;

// User.java (Abstract Class)
public abstract class User {
    String nama, nim, username, id;
    private String password;
    private double nilai;

    public User(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    // Abstract method (polymorphism)
    public abstract void showInfo();

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public double getNilai() {
        return nilai;
    }
}
