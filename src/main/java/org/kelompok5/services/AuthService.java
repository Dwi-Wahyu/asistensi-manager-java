package org.kelompok5.services;

import org.kelompok5.models.*;
import org.kelompok5.utils.Validator;

public class AuthService {
    private Validator validator;
    private Laboratorium laboratorium;
    private User loggedInUser;

    public AuthService(Laboratorium laboratorium) {
        this.laboratorium = laboratorium;
        this.validator = new Validator();
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void register() {
        System.out.println("\n=== REGISTER ===");
        String role = validator.inputString("Pilih Role (asisten/praktikan)", "Role tidak valid",
                new String[] { "asisten", "praktikan" });
        String id = validator.InputId("Masukkan ID (awali huruf):", "ID harus diawali huruf");
        String nama = validator.inputNama("Masukkan Nama:", "Nama minimal 3 karakter");
        String nim = validator.inputNIM("Masukkan NIM:", "Format NIM tidak valid");
        String password = validator.inputPassword("Masukkan Password:", "Password minimal 6 karakter");
        double nilai = validator.inputNilai("Masukkan Nilai (0-100):", "Nilai harus antara 0 dan 100");

        // Cek apakah NIM sudah digunakan
        if (laboratorium.nimSudahTerdaftar(nim)) {
            System.out.println("ERROR: NIM sudah terdaftar!");
            return;
        }

        if (role.equals("asisten")) {
            Asisten asisten = new Asisten(id, nama, nim, password, nilai);
            laboratorium.tambahDaftar(asisten);
        } else {
            Praktikan praktikan = new Praktikan(id, nama, nim, password, nilai);
            laboratorium.tambahDaftar(praktikan);
        }

        System.out.println("Registrasi berhasil!");
    }

    public User login() {
        System.out.println("\n=== LOGIN ===");
        String nim = validator.inputString("Masukkan NIM:", "NIM tidak boleh kosong");
        String password = validator.inputString("Masukkan Password:", "Password tidak boleh kosong");

        User user = laboratorium.cariUser(nim, password);

        if (user != null) {
            System.out.println("Login berhasil! Selamat datang, " + user.nama);
            this.loggedInUser = user;
        } else {
            System.out.println("Login gagal! NIM atau password salah.");
        }

        return user;
    }

    public void logout() {
        this.loggedInUser = null;
    }
}
