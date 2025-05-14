package org.kelompok5;

import java.io.FileReader;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.kelompok5.models.Asisten;
import org.kelompok5.models.Laboratorium;
import org.kelompok5.models.Praktikan;
import org.kelompok5.models.Tugas;
import org.kelompok5.models.User;
import org.kelompok5.services.AuthService;
import org.kelompok5.utils.Validator;

public class App {
    static Validator validator = new Validator();
    static JSONParser jsonParser = new JSONParser();
    static Laboratorium laboratorium = new Laboratorium();
    static AuthService authService = new AuthService(laboratorium);

    public static void main(String[] args) {

        loadDataUser("src/main/resources/Users.json", laboratorium);
        loadDataTugas("src/main/resources/Tugas.json", laboratorium);

        runApp();
    }

    public static void runApp() {
        System.out.println("=====================================");
        System.out.println(" Selamat Datang Di Asistensi Manager ");
        System.out.println("=====================================");
        System.out.println("Pilih Menu :");
        System.out.println("1. Login");
        System.out.println("2. Register");
        String[] validMenu = { "1", "2" };
        String menu = validator.inputString("-------------------------------------", "Tolong pilih menu", validMenu);

        switch (menu) {
            case "1":
                User user = authService.login();

                if (user != null) {
                    if (user instanceof Asisten) {
                        menuAsisten();
                    } else if (user instanceof Praktikan) {
                        menuPraktikan();
                    }
                }
                break;
            case "2":
                authService.register();
                break;
        }
    }

    private static void menuAsisten() {
        while (true) {
            System.out.println("\n=== MENU ASISTEN ===");
            System.out.println("1. Tampilkan praktikan asuhan");
            System.out.println("2. Tambah praktikan asuhan");
            System.out.println("3. Logout");
            String[] validMenu = { "1", "2", "3" };
            String pilih = validator.inputString("Pilih: ", "ERROR: Pilihan tidak valid", validMenu);

            switch (pilih) {
                case "1":
                    ((Asisten) authService.getLoggedInUser()).tampilkanDaftarPraktikanAsuhan();
                    break;
                case "2":
                    laboratorium.tampilkanDaftarPraktikan();
                    String nim = validator.inputNIM("Masukkan NIM praktikan:", "NIM tidak valid");
                    Praktikan praktikan = laboratorium.getPraktikanByNIM(nim);
                    if (praktikan != null) {
                        ((Asisten) authService.getLoggedInUser()).tambahAsuhan(praktikan);
                    } else {
                        System.out.println("Praktikan tidak ditemukan.");
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void menuPraktikan() {
        while (true) {
            System.out.println("\n=== MENU PRAKTIKAN ===");
            System.out.println("1. Tampilkan info saya");
            System.out.println("2. Tampilkan kartu kontrol");
            System.out.println("3. Asistensi Tugas Praktikum");
            System.out.println("4. Logout");
            String[] validMenu = { "1", "2", "3", "4" };
            String pilih = validator.inputString("Pilih: ", "ERROR: Pilihan tidak valid", validMenu);

            switch (pilih) {
                case "1":
                    authService.getLoggedInUser().showInfo();
                    break;
                case "2":
                    ((Praktikan) authService.getLoggedInUser()).tampilkanKartuKontrol();
                    break;
                case "3":

                    break;
                case "4":
                    authService.logout();
                    break;
            }
        }
    }

    public static void loadDataUser(String filePath, Laboratorium laboratorium) {
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String id = (String) jsonObject.get("id");
                String nama = (String) jsonObject.get("nama");
                String nim = (String) jsonObject.get("nim");
                String password = (String) jsonObject.get("password");
                double nilai = (double) jsonObject.get("nilai");

                JSONArray asuhanArray = (JSONArray) jsonObject.get("praktikanAsuhan");

                Asisten asisten = new Asisten(id, nama, nim, password, nilai);
                for (Object asuhanObject : asuhanArray) {
                    JSONObject praktikanObject = (JSONObject) asuhanObject;

                    String idPraktikan = (String) praktikanObject.get("id");
                    String namaPraktikan = (String) praktikanObject.get("nama");
                    String nimPraktikan = (String) praktikanObject.get("nim");
                    String passwordPraktikan = (String) praktikanObject.get("password");
                    double nilaiPraktikan = (double) praktikanObject.get("nilai");

                    Praktikan praktikan = new Praktikan(idPraktikan, namaPraktikan, nimPraktikan, passwordPraktikan,
                            nilaiPraktikan);

                    asisten.tambahAsuhan(praktikan);
                    laboratorium.tambahDaftar(praktikan);
                }

                laboratorium.tambahDaftar(asisten);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // TODO: Tolong Alya baca data dari file baru looping panggil fungsi
    // tambahDaftar dari class laboratorium untuk tambah asisten
    public static void loadDataTugas(String filePath, Laboratorium laboratorium) {
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String judul = (String) jsonObject.get("judul");
                String deskripsi = (String) jsonObject.get("deskripsi");
                String deadlineStr = (String) jsonObject.get("deadline");

                LocalDate deadline = LocalDate.parse(deadlineStr);

                Tugas tugas = new Tugas(judul, deskripsi, deadline);

                laboratorium.tambahDaftar(tugas);
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat data tugas: " + e.getMessage());
        }
    }
}
