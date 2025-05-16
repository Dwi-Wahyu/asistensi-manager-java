# AsistensiManager

Sebuah aplikasi untuk memudahkan manajemen asistensi di laboratorium komputer. Aplikasi ini menyediakan fitur untuk mengatur tugas, praktikan, asisten, dan mencatat riwayat asistensi.

## Fitur Utama

- Manajemen user (Praktikan dan Asisten)
- Pembuatan dan penugasan tugas
- Pencatatan asistensi dengan sistem penilaian otomatis
- Kartu kontrol untuk memantau riwayat asistensi praktikan
- Penyimpanan data dalam format JSON

## Kelas Utama

### 1. User (Abstract Class)

Kelas dasar untuk semua user dalam sistem.

**Atribut:**

- `nama` - Nama user
- `nim` - Nomor Induk Mahasiswa
- `password` - Password untuk login
- `nilai` - Nilai user

**Method:**

- `showInfo()` - Menampilkan informasi user (abstract method)
- Getter dan setter untuk atribut

### 2. Praktikan

Kelas turunan dari User untuk praktikan di laboratorium.

**Atribut Tambahan:**

- `kartuKontrol` - Objek KartuKontrol untuk mencatat riwayat asistensi
- `asisten` - Asisten pembimbing praktikan

**Method:**

- `tampilkanKartuKontrol()` - Menampilkan riwayat asistensi
- `showInfo()` - Implementasi dari method abstract di User

### 3. Asisten

Kelas turunan dari User untuk asisten di laboratorium.

**Atribut Tambahan:**

- `praktikanAsuhan` - Daftar praktikan yang dibimbing

**Method:**

- `tambahAsuhan()` - Menambahkan praktikan ke dalam asuhan
- `tampilkanDaftarPraktikanAsuhan()` - Menampilkan daftar praktikan asuhan
- `showInfo()` - Implementasi dari method abstract di User

### 4. Tugas

Kelas untuk merepresentasikan tugas di laboratorium.

**Atribut:**

- `judul` - Judul tugas
- `deskripsi` - Deskripsi tugas
- `deadline` - Tenggat waktu tugas
- `status` - Status tugas (BELUM_SELESAI/SELESAI)

**Method:**

- `setStatus()` - Mengubah status tugas

### 5. Asistensi

Kelas untuk mencatat asistensi yang dilakukan.

**Atribut:**

- `tugas` - Tugas yang diasistensi
- `tanggal` - Tanggal asistensi
- `nilaiAsistensi` - Nilai asistensi (dihitung otomatis)
- `statusAsistensi` - Status asistensi (TERLAMBAT/TEPAT_WAKTU)

**Method:**

- Getter untuk semua atribut

### 6. KartuKontrol

Kelas untuk mencatat riwayat asistensi praktikan.

**Atribut:**

- `riwayatAsistensi` - Daftar asistensi yang telah dilakukan
- `praktikan` - Praktikan pemilik kartu kontrol

**Method:**

- `tambahAsistensi()` - Menambahkan asistensi ke riwayat
- `showInfo()` - Menampilkan informasi kartu kontrol

### 7. Laboratorium

Kelas utama yang mengatur semua operasi sistem.

**Atribut:**

- `daftarPraktikan` - Daftar praktikan terdaftar
- `daftarAsisten` - Daftar asisten terdaftar
- `daftarTugas` - Daftar tugas yang ada

**Method:**

- `laksanakanAsistensi()` - Melakukan asistensi untuk tugas tertentu
- `tambahDaftar()` - Menambahkan user/tugas ke sistem
- `tampilkanDaftar*()` - Berbagai method untuk menampilkan daftar
- `cariUser()` - Mencari user berdasarkan NIM dan password
- `get*By*()` - Berbagai method getter untuk mencari objek

### 8. Validator

Kelas utilitas untuk memvalidasi dan mengambil input dari pengguna melalui terminal/console.

**Atribut:**

- `scanner` - Objek `Scanner` yang digunakan untuk membaca input dari pengguna.

**Method:**

- `inputString(String placeholder, String pesanError)`  
  Meminta input string dari pengguna. Jika input kosong (hanya spasi atau kosong), maka akan ditampilkan pesan error dan pengguna diminta untuk mengulang hingga input valid diberikan.

- `inputString(String placeholder, String pesanError, String[] validInput)`  
  Meminta input string dari pengguna dan memvalidasi apakah input tersebut termasuk dalam daftar input yang diperbolehkan (`validInput`).  
  Jika input kosong atau tidak sesuai, maka akan ditampilkan pesan error dan pengguna diminta untuk mengulang hingga input valid diberikan.

> Metode tambahan dapat ditambahkan ke dalam kelas ini untuk mendukung validasi tipe data lain seperti `int`, `double`, atau `boolean`.

### 9. AuthService

Kelas untuk mengatur autentikasi user.

**Method:**

- `register()` - Mendaftarkan user baru
- `login()` - Proses login user
- `logout()` - Proses logout

### 10. JsonHelper

Kelas utilitas untuk menyimpan dan memuat data dari/tabel file JSON.

**Method:**

- `simpanDataUser()` - Menyimpan data user ke file
- `loadDataUser()` - Memuat data user dari file
- `simpanDataTugas()` - Menyimpan data tugas ke file
- `loadDataTugas()` - Memuat data tugas dari file

## Cara Penggunaan

1. Jalankan aplikasi dan login sebagai asisten/praktikan
2. Untuk asisten:
   - Tambahkan tugas untuk praktikan
3. Untuk praktikan:
   - Lihat kartu kontrol untuk memantau riwayat asistensi
   - Lihat daftar tugas yang harus diselesaikan
   - Asistensi tugas

## Persyaratan Sistem

- Java 8 atau lebih baru
- Library org.json.simple
