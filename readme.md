# **README - Sistem Manajemen Praktikum**

**Package: `org.kelompok5.models`**

## **1. Deskripsi**

`User` adalah kelas _abstract_ yang menjadi _parent class_ untuk semua jenis pengguna dalam sistem manajemen praktikum (misalnya: `Asisten`, `Praktikan`, `Admin`, dll). Kelas ini menyediakan atribut dan method dasar yang akan diwarisi oleh kelas turunannya.

---

## **2. Fitur & Method**

### **Atribut**

| Nama       | Tipe Data          | Deskripsi                                                  |
| ---------- | ------------------ | ---------------------------------------------------------- |
| `nama`     | `String`           | Menyimpan nama pengguna                                    |
| `nim`      | `String`           | Menyimpan NIM pengguna                                     |
| `password` | `String` (private) | Menyimpan password pengguna (di-_encrypt_ jika diperlukan) |
| `nilai`    | `double` (private) | Menyimpan nilai pengguna (jika ada)                        |

### **Method**

#### **1. Konstruktor**

```java
public User(String nama, String nim, String password, double nilai)
```
