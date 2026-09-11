# Laporan Jobsheet 3 — Getter & Setter pada Java (Studi Kasus: Koperasi)

**Mata Kuliah:** Pemrograman Berbasis Objek  
**Topik:** Getter, Setter, dan Encapsulation  
**Folder:** `koperasigetter`  
**Tanggal:** 11 September 2026  

---

## 1. Tujuan

- Memahami penerapan **getter** dan **setter** dalam enkapsulasi Java.
- Mampu membuat class dengan atribut `private` yang diakses melalui method getter dan setter.
- Mensimulasikan operasi koperasi simpan pinjam menggunakan OOP.

---

## 2. Dasar Teori

**Getter** dan **Setter** adalah method khusus yang digunakan untuk membaca (get) dan mengubah (set) nilai atribut `private` dari sebuah class.

| Jenis | Nama Konvensi | Fungsi |
|---|---|---|
| Getter | `getNamaAtribut()` | Mengembalikan nilai atribut |
| Setter | `setNamaAtribut(nilai)` | Mengubah nilai atribut |

Pola ini merupakan implementasi dari **enkapsulasi**, salah satu pilar utama OOP.

---

## 3. Struktur Program

### 3.1 Class `Anggotta` — [`Anggotta.java`](./Anggotta.java)

Class ini merepresentasikan anggota koperasi dengan tiga atribut `private`:

| Atribut | Tipe | Keterangan |
|---|---|---|
| `nama` | `String` | Nama anggota koperasi |
| `alamat` | `String` | Alamat anggota koperasi |
| `simpanan` | `float` | Saldo simpanan anggota |

**Method-method pada `Anggotta.java`:**

| Method | Return | Keterangan |
|---|---|---|
| `Anggotta(String, String)` | — | Constructor untuk inisialisasi nama dan alamat |
| `setNama(String)` | `void` | Setter untuk atribut nama |
| `setAlamat(String)` | `void` | Setter untuk atribut alamat |
| `getNama()` | `String` | Getter untuk atribut nama |
| `getAlamat()` | `String` | Getter untuk atribut alamat |
| `getSimpanan()` | `float` | Getter untuk atribut simpanan |
| `setor(float)` | `void` | Menambah saldo simpanan |
| `pinjam(float)` | `void` | Mengurangi saldo simpanan |

**Source Code `Anggotta.java`:**
```java
package koperasigetter;

public class Anggotta {
    private String nama;
    private String alamat;
    private float simpanan;

    Anggotta(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.simpanan = simpanan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String nama) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public float getSimpanan() {
        return simpanan;
    }

    public void setor(float uang) {
        simpanan += uang;
    }

    public void pinjam(float uang) {
        simpanan -= uang;
    }
}
```

---

### 3.2 Class `koperasidemo` — [`koperasidemo.java`](./koperasidemo.java)

Class ini berisi method `main` sebagai titik masuk program untuk mendemonstrasikan operasi koperasi.

**Source Code `koperasidemo.java`:**
```java
package koperasigetter;

public class koperasidemo {
    public static void main(String[] args) {
        Anggotta anggotta1 = new Anggotta("Faren Afanda", "Nganjuk");
        System.out.println("Simpanan " + anggotta1.getNama() + " : Rp. " + anggotta1.getSimpanan());

        anggotta1.setNama("Faren Afanda");
        anggotta1.setAlamat("Nganjuk");
        anggotta1.setor(10000);
        System.out.println("Simpanan " + anggotta1.getNama() + " : Rp. " + anggotta1.getSimpanan());

        anggotta1.pinjam(1000);
        System.out.println("Simpanan " + anggotta1.getNama() + " : Rp. " + anggotta1.getSimpanan());
    }
}
```

---

## 4. Alur Eksekusi Program

```
[mulai]
    │
    ▼
anggotta1 = new Anggotta("Faren Afanda", "Nganjuk")
    → nama="Faren Afanda", alamat="Nganjuk", simpanan=0
    │
    ▼
getSimpanan()         → cetak: "Simpanan Faren Afanda : Rp. 0.0"
    │
    ▼
setNama() / setAlamat() → memperbarui data anggota
    │
    ▼
setor(10000)          → simpanan = 0 + 10000 = 10000
    │
    ▼
getSimpanan()         → cetak: "Simpanan Faren Afanda : Rp. 10000.0"
    │
    ▼
pinjam(1000)          → simpanan = 10000 - 1000 = 9000
    │
    ▼
getSimpanan()         → cetak: "Simpanan Faren Afanda : Rp. 9000.0"
    │
   [selesai]
```

---

## 5. Output Program

```
Simpanan Faren Afanda : Rp. 0.0
Simpanan Faren Afanda : Rp. 10000.0
Simpanan Faren Afanda : Rp. 9000.0
```

---

## 6. Analisis & Pembahasan

1. **Getter digunakan untuk membaca data** — Method `getNama()`, `getAlamat()`, dan `getSimpanan()` memungkinkan pihak luar membaca nilai atribut tanpa bisa mengubahnya secara langsung.

2. **Setter digunakan untuk mengubah data** — Method `setNama()` dan `setAlamat()` mengontrol bagaimana nilai atribut diperbarui, memungkinkan validasi tambahan jika diperlukan.

3. **Operasi bisnis terenkapsulasi** — Method `setor()` dan `pinjam()` mencerminkan logika bisnis koperasi. Nilai `simpanan` hanya dapat berubah melalui dua method ini, bukan dari luar class.

4. **Catatan perbaikan bug** — Pada constructor `Anggotta`, terdapat inisialisasi `this.simpanan = simpanan` di mana parameter `simpanan` tidak ada dalam constructor. Seharusnya diinisialisasi dengan `0` atau ditambahkan parameter `float simpanan` ke constructor.

---

## 7. Kesimpulan

- **Getter** dan **Setter** adalah implementasi konkret dari enkapsulasi OOP.
- Atribut `private` dilindungi dari akses langsung; perubahan hanya melalui method yang telah didefinisikan.
- Pola getter/setter memungkinkan penambahan validasi logika bisnis di masa mendatang tanpa mengubah cara penggunaan class dari luar.
- Studi kasus koperasi ini menunjukkan bagaimana OOP dapat merepresentasikan entitas dunia nyata (anggota koperasi) beserta operasinya (setor, pinjam) secara terstruktur.
