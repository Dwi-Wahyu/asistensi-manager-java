package org.kelompok5;

import org.kelompok5.models.Laboratorium;
import org.kelompok5.models.Praktikan;
import org.kelompok5.models.User;
import org.kelompok5.utils.Validator;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
    static Validator validator = new Validator();
    static JSONParser jsonParser = new JSONParser();
    User user;

    public void setLoggedInUser(User user) {

    }

    public static void main(String[] args) {
        Laboratorium oop = new Laboratorium();

        loadDataPraktikan("src/main/resources/Praktikan.json", oop);

        oop.tampilkanDaftarPraktikan();

        runApp();
    }

    public static void runApp() {
        System.out.println("=====================================");
        System.out.println(" Selamat Datang Di Asistensi Manager ");
        System.out.println("=====================================");
        System.out.println("Pilih Menu :");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int menu = validator.inputInt("-------------------------------------", "Tolong pilih menu");

        switch (menu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
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
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String id = (String) jsonObject.get("id");
                String nama = (String) jsonObject.get("nama");
                String nim = (String) jsonObject.get("nim");
                String password = (String) jsonObject.get("password");
                double nilai = (double) jsonObject.get("nilai");

                Praktikan praktikan = new Praktikan(id, nama, nim, password, nilai);

                laboratorium.tambahDaftar(praktikan);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
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
