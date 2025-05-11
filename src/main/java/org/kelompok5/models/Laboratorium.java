package org.kelompok5.models;

import java.util.ArrayList;

public class Laboratorium {
    private ArrayList<Praktikan> daftarPraktikan = new ArrayList<>();
    private ArrayList<Asisten> daftarAsisten = new ArrayList<>();
    private ArrayList<Tugas> daftarTugas = new ArrayList<>();

    // TODO: Haris buat logika asistensi
    // cek kalau tanggal sekarang melebihi satu minggu dari deadline tugas maka
    // kurangi nilai asistensi 10%, dan jika melebihi dua minggu kurangi nilai 30%
    public void laksanakanAsistensi(Tugas tugas, Asisten asisten, Praktikan praktikan) {
        if (!asisten.praktikanAsuhan.contains(praktikan)) {
            System.out.println("Praktikan bukan merupakan asuhan asisten");
            return;
        }
    }

    public void tambahDaftar(Praktikan praktikan) {
        if (daftarPraktikan.contains(praktikan)) {
            System.out.println("Praktikan sudah terdaftar");
            return;
        }

        daftarPraktikan.add(praktikan);
        System.out.println("Berhasil menambahkan praktikan");
    }

    public void tambahDaftar(Asisten asisten) {
        if (daftarAsisten.contains(asisten)) {
            System.out.println("Asisten sudah terdaftar");
            return;
        }

        if (asisten.getNilai() < 80) {
            System.out.println("Nilai asisten tidak mencukupi untuk menjadi asisten, Minimum = 80");
            return;
        }

        daftarAsisten.add(asisten);
        System.out.println("Berhasil menambahkan Asisten");
    }

    public void tambahDaftar(Tugas tugas) {
        if (daftarTugas.contains(tugas)) {
            System.out.println("Tugas sudah terdaftar");
            return;
        }

        daftarTugas.add(tugas);
        System.out.println("Berhasil menambahkan Tugas");
    }

    public void tampilkanDaftarPraktikan() {
        System.out.println("=======================");
        System.out.println("   Daftar Praktikan   ");
        System.out.println("=======================");
        for (Praktikan praktikan : daftarPraktikan) {
            System.out.printf("%s. %s \n", praktikan.id, praktikan.nama);
        }
        System.out.println("=======================");
    }

    public void tampilkanDaftarAsisten() {
        System.out.println("=======================");
        System.out.println("   Daftar Asisten   ");
        System.out.println("=======================");
        for (Asisten asisten : daftarAsisten) {
            System.out.printf("%s. %s", asisten.id, asisten.nama);
        }
        System.out.println("=======================");
    }

    public void tampilkanDaftarTugas() {
        System.out.println("=======================");
        System.out.println("   Daftar Tugas   ");
        System.out.println("=======================");
        for (Tugas tugas : daftarTugas) {
            System.out.println("-----------------------");
            System.out.println("Judul     : " + tugas.judul);
            System.out.println("Deskripsi : " + tugas.deskripsi);
            System.out.println("Deadline  : " + tugas.deadline);
            System.out.println("-----------------------");
        }
        System.out.println("=======================");
    }

}
