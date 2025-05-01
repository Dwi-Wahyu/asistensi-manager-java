package main;

public abstract class User {
    String nama, nim;

    private String password, username;

    public User() {

    }

    public User(String nama, String nim, String password, String username) {
        this.nama = nama;
        this.nim = nim;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) {
            System.out.printf("%s Berhasil login", this.nama);
            return true;
        } else {
            return false;
        }
    }

}
