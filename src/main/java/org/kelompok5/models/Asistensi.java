package org.kelompok5.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

enum StatusAsistensi {
    TERLAMBAT,
    TEPAT_WAKTU
}

public class Asistensi {
    Tugas tugas;
    LocalDate tanggal;
    int nilaiAsistensi;
    StatusAsistensi statusAsistensi;

    public Asistensi(Tugas tugas, LocalDate tanggal) {
        this.tugas = tugas;
        this.tanggal = tanggal;
        this.nilaiAsistensi = 100; // Nilai awal
        // Tentukan status berdasarkan tanggal vs. deadline
        this.statusAsistensi = (tanggal.isAfter(tugas.deadline)) ? StatusAsistensi.TERLAMBAT : StatusAsistensi.TEPAT_WAKTU;

        // Logika asistensi: cek keterlambatan
        // cek kalau tanggal sekarang melebihi satu minggu dari deadline tugas maka
        // kurangi nilai asistensi 10%, dan jika melebihi dua minggu kurangi nilai 30%
        long selisihHari = tugas.deadline.until(tanggal, ChronoUnit.DAYS);
        if (selisihHari > 14) {
            nilaiAsistensi = (int) (nilaiAsistensi * 0.7); // Kurangi 30%
        } else if (selisihHari > 7) {
            nilaiAsistensi = (int) (nilaiAsistensi * 0.9); // Kurangi 10%
        }
    }
}