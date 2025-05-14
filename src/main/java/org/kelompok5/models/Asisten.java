package org.kelompok5.models;

import java.util.ArrayList;

public class Asisten extends User {
    ArrayList<Praktikan> praktikanAsuhan;

    public Asisten(String id, String nama, String nim, String password, double nilai) {
        super(id, nama, nim, password, nilai);
        this.praktikanAsuhan = new ArrayList<>();
    }

    @Override
    public void showInfo() {
        System.out.println("=======================");
        System.out.println("     Detail Asisten    ");
        System.out.println("=======================");
        System.out.println("ID    : " + this.id);
        System.out.println("Nama  : " + this.nama);
        System.out.println("Nim   : " + this.nim);
        System.out.println("Nilai : " + this.nim);
        System.out.println("=======================");
    }

    public void tambahAsuhan(Praktikan praktikan) {
        if (praktikanAsuhan.contains(praktikan)) {
            System.out.println("Praktikan sudah menjadi asuhan asisten");
            return;
        }

        praktikanAsuhan.add(praktikan);
    }

    public void tampilkanDaftarPraktikanAsuhan() {
        System.out.println("Daftar Asuhan:");
        for (Praktikan p : praktikanAsuhan) {
            System.out.println("- " + p.nama + " (" + p.nim + ")");
        }
    }
}
