package main;

import java.util.Date;
// TODO Haris : buat logika asistensi antara praktikan dan asisten
public class Asistensi {
    private String namaTugas;
    private String status;
    private Date tanggal;

    public String getNamaTugas(){
        return namaTugas;
    }
    public String getStatus(){
        return status();
    }
    public Date getTanggal() {
        return tanggal;
    }

    public Asistensi(String namaTugas, Date tanggal){
        this.namaTugas = namaTugas;
        this.tanggal = tanggal;
        this.status = "Belum selesai";
    }
    public void selesaikan(){
        this.status = "Selesai";
        System.out.println("Asistensi selesai!");
    }
    public void proses(Asisten asisten, Praktikan praktikan){
        System.out.println("Asisten " + asisten.getNama() + " membantu " + praktikan.getNama());//nanti saya buatkan method getNama di User
        System.out.println("Tugas: " + namaTugas);
    }

}
