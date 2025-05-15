package org.kelompok5.models;

import java.time.LocalDate;

public class Tugas {
    // TODO: buat logika status tugas

    public LocalDate deadline;
    public String judul, deskripsi;
    public String status = "BELUM_SELESAI";

    public Tugas(String judul, String deskripsi, LocalDate deadline) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}