package org.kelompok5.models;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// TODO : Haris
// - Buatkan attr dan method KartuKontrol
// - Buat behavior untuk menampilkan riwayat asistensi
public class KartuKontrol {
    ArrayList<Asistensi> riwayatAsistensi;
    Praktikan praktikan;
    Laboratorium laboratorium;

    public KartuKontrol(Praktikan praktikan, Laboratorium laboratorium) {
        this.riwayatAsistensi = new ArrayList<>();
        this.praktikan = praktikan;
        this.laboratorium = laboratorium;
    }
    public void tambahAsistensi(Asistensi asistensi) {
        for (Asistensi a : riwayatAsistensi) {
            if (a.tugas.judul.equals(asistensi.tugas.judul)) {
                System.out.println("Tugas " + asistensi.tugas.judul + " sudah ada di riwayat");
                return;
            }
        }
        riwayatAsistensi.add(asistensi);
        System.out.println("Asistensi untuk tugas " + asistensi.tugas.judul + " berhasil ditambahkan");
    }
    // Buat output seperti kartu kontrol lab tampilkan nama, nim praktikan, nama
    // asisten
    // Looping riwayat asistensi munculkan tanggal dan status
    public void showInfo() {
        System.out.println("==============================");
        System.out.println("   Kartu Kontrol Praktikan   ");
        System.out.println("==============================");
        System.out.println("Nama Praktikan: " + praktikan.nama);
        System.out.println("NIM: " + praktikan.nim);
    
        String namaAsisten = "Belum ada asisten";
        for (Asisten asisten : laboratorium.getDaftarAsisten()) {
            if (asisten.praktikanAsuhan != null && asisten.praktikanAsuhan.contains(praktikan)) {
                namaAsisten = asisten.nama;
                break;
            }
        }
        System.out.println("Asisten: " + namaAsisten); // Ditambahkan spasi untuk kejelasan
    
        System.out.println("==============================");
        System.out.println("No  Tanggal        Nilai");
        System.out.println("==============================");
    
        if (riwayatAsistensi.isEmpty()) {
            System.out.println("  Belum ada asistensi");
        } else {
            int index = 1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
            for (Asistensi asistensi : riwayatAsistensi) {
                String tanggalFormatted = asistensi.tanggal.format(formatter);
                System.out.printf("%2d  %s  %d%n", index++, tanggalFormatted, asistensi.nilaiAsistensi);
            }
        }
        System.out.println("==============================");
    }
}