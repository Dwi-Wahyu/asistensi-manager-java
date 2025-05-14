package org.kelompok5.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

enum StatusAsistensi {
    TERLAMBAT,
    TEPAT_WAKTU,
}

// TODO Haris : buat logika asistensi antara praktikan dan asisten
public class Asistensi {
    private Tugas tugas;
    private LocalDate tanggal;
    private int nilaiAsistensi = 100;
    private StatusAsistensi statusAsistensi;

    public Asistensi(Tugas tugas, LocalDate tanggal, int nilaiAsistensi, StatusAsistensi statusAsistensi) {
        this.tugas = tugas;
        this.tanggal = tanggal;
        this.nilaiAsistensi = nilaiAsistensi;
        this.statusAsistensi = (tanggal.isAfter(tugas.deadline)) ? StatusAsistensi.TERLAMBAT
                : StatusAsistensi.TEPAT_WAKTU;

        long selisihHari = tugas.deadline.until(tanggal, ChronoUnit.DAYS);
        if (selisihHari > 7) {
            nilaiAsistensi = (int) (nilaiAsistensi * 0.7);
        } else if (selisihHari > 14) {
            nilaiAsistensi = (int) (nilaiAsistensi * 0.9);
        }

    }
}