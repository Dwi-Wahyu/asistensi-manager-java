package org.kelompok5;

import org.kelompok5.models.Laboratorium;
import org.kelompok5.models.Praktikan;
import org.kelompok5.utils.Validator;
import org.json.simple.*;

public class App {
    static Validator validator = new Validator();

    public static void main(String[] args) {
        Laboratorium oop = new Laboratorium();

        String content = "{\"nama\":\"Kelompok 5\",\"anggota\":4}";

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(content);

        System.out.println("Nama: " + obj.get("nama"));

//        runApp();
    }

    public static void runApp() {
        System.out.println("=====================================");
        System.out.println(" Selamat Datang Di Asistensi Manager ");
        System.out.println("=====================================");
        System.out.println("Pilih Menu :");
        System.out.println("1. Login");
        System.out.println("2. Register");
        String menu = validator.inputString("-------------------------------------", "Tolong pilih menu");

        switch (menu) {
            case "1":
                showLoginMenu();
                break;
            case "2":
                showRegisterMenu();
                break;
            default:
                System.out.println("Menu Tidak Valid");
                break;
        }
    }

    public static void showLoginMenu() {
        System.out.println("Menu Login");
    }

    public static void showRegisterMenu() {
        System.out.println("Menu Register");
    }

    public static void loadDataPraktikan(String filePath, Laboratorium laboratorium) {

    }

    // TODO: Tolong Alya baca data dari file baru looping panggil fungsi
    // tambahDaftar dari class laboratorium untuk tambah asisten
    public static void loadDataAsisten(String filePath, Laboratorium laboratorium) {

    }

    // TODO: Tolong Alya baca data dari file baru looping panggil fungsi
    // tambahDaftar dari class laboratorium untuk tambah asisten
    public static void loadDataTugas(String filePath, Laboratorium laboratorium) {

    }

}
