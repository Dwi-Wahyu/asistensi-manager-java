package org.kelompok5.models;

import java.util.ArrayList;

public class Asisten extends User {
    ArrayList<Praktikan> praktikanAsuhan;

    public Asisten(ArrayList<Praktikan> praktikanAsuhan) {
        this.praktikanAsuhan = praktikanAsuhan;
    }

    public Asisten(String nama, String nim, String password, String username, ArrayList<Praktikan> praktikanAsuhan) {
        super(nama, nim, password, username);
        this.praktikanAsuhan = praktikanAsuhan;
    }

}
