package org.kelompok5.models;

public class Praktikan extends User {
    KartuControl kartuControl;

    public Praktikan(KartuControl kartuControl) {
        this.kartuControl = kartuControl;
    }

    public Praktikan(String nama, String nim, String password, String username, KartuControl kartuControl) {
        super(nama, nim, password, username);
        this.kartuControl = kartuControl;
    }
}
