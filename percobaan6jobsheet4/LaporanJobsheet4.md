# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK
## JOBSHEET 4: RELASI ANTAR KELAS (CLASS RELATIONSHIP)

---

### **IDENTITAS MAHASISWA**
- **Mata Kuliah** : Pemrograman Berbasis Objek (PBO)
- **Topik** : Relasi Antar Kelas (Asosiasi, Agregasi, Komposisi, dan Ketergantungan)
- **Bahasa Pemrograman** : Java

---

## 1. TUJUAN PRAKTIKUM
1. Memahami konsep relasi antar kelas dalam pemrograman berorientasi objek (*Object-Oriented Programming*).
2. Mampu mendeklarasikan dan mengimplementasikan relasi antar objek (Asosiasi, Agregasi, Komposisi, dan Dependensi) di Java.
3. Mampu memanfaatkan objek dari kelas lain sebagai atribut maupun parameter metode.
4. Mampu menangani relasi dengan kardinalitas (*multiplicity*) 1-ke-1 maupun 1-ke-banyak (*Array of Objects*).

---

## 2. DASAR TEORI

Dalam OOP, sistem dibangun dari berbagai objek yang saling berinteraksi melalui relasi antar kelas:
1. **Asosiasi (Association)**: Relasi struktural umum antara dua kelas ("*has-a*" atau hubungan kepemilikan/penggunaan).
2. **Agregasi (Aggregation)**: Bentuk khusus dari asosiasi dengan relasi *whole-part* yang bersifat lemah. Objek bagian (*part*) dapat eksis secara independen tanpa objek utama (*whole*).
3. **Komposisi (Composition)**: Bentuk agregasi yang kuat (*strong whole-part*). Objek bagian dibuat di dalam objek utama dan siklus hidupnya bergantung penuh pada objek utama.
4. **Ketergantungan (Dependency)**: Relasi "*uses-a*" yang bersifat sementara, di mana suatu kelas menggunakan objek kelas lain sebagai parameter metode atau variabel lokal tanpa menyimpannya sebagai atribut.

---

## 3. HASIL DAN PEMBAHASAN PERCOBAAN

---

### **Percobaan 1: Relasi 1-ke-1 (Laptop dan Processor)**

#### **A. Deskripsi Percobaan**
Percobaan ini mendemonstrasikan relasi 1-ke-1 (*One-to-One*) di mana sebuah objek kelas `Laptop` memiliki satu atribut bertipe objek kelas `Processor`.

#### **B. Source Code**

1. **`Processor.java`**
```java
package percobaan1jobsheet4;

public class Processor {
    private String merk;
    private double cache;

    public Processor() {
    }

    public Processor(String merk, double cache) {
        this.merk = merk;
        this.cache = cache;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public double getCache() {
        return cache;
    }

    public void info() {
        System.out.printf("Merk Processor : %s\n", merk);
        System.out.printf("Cache Memory : %.2f\n", cache);
    }
}
```

2. **`Laptop.java`**
```java
package percobaan1jobsheet4;

public class Laptop {
    private String merk;
    private Processor proc;

    public Laptop() {
    }

    public Laptop(String merk, Processor proc) {
        this.merk = merk;
        this.proc = proc;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setProc(Processor proc) {
        this.proc = proc;
    }

    public Processor getProc() {
        return proc;
    }

    public void info() {
        System.out.println("Merk Laptop : " + merk);
        proc.info();
    }
}
```

3. **`Mainpercobaan1.java`**
```java
package percobaan1jobsheet4;

public class Mainpercobaan1 {
    public static void main(String[] args) {
        // Cara 1: Inisialisasi melalui Konstruktor berparameter
        Processor p = new Processor("Intel i5 ", 3);
        Laptop l = new Laptop("Thinkpad", p);
        l.info();

        // Cara 2: Inisialisasi melalui Setter
        Processor p1 = new Processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);
        Laptop l1 = new Laptop();
        l1.setMerk("Thinkpad");
        l1.setProc(p1);
        l1.info();

        // Cara 3: Instansiasi objek langsung sebagai argumen konstruktor
        Laptop l2 = new Laptop("Thinkpad", new Processor("Intel i5", 3));
        l2.info();
    }
}
```

#### **C. Output Program**
```text
Merk Laptop : Thinkpad
Merk Processor : Intel i5 
Cache Memory : 3,00
Merk Laptop : Thinkpad
Merk Processor : Intel i5
Cache Memory : 4,00
Merk Laptop : Thinkpad
Merk Processor : Intel i5
Cache Memory : 3,00
```

#### **D. Analisis**
- Objek `Laptop` memiliki atribut bertipe `Processor` (`private Processor proc;`).
- Program menguji 3 cara berbeda dalam mengaitkan objek `Processor` ke `Laptop`:
  1. Membuat objek `Processor` terlebih dahulu, lalu memasukkannya lewat konstruktor `Laptop`.
  2. Menggunakan *setter* (`setProc`).
  3. Melakukan *anonymous object instantiation* langsung pada parameter konstruktor `Laptop`.
- Method `info()` pada `Laptop` memanggil method `info()` milik objek `Processor` (`proc.info()`), menerapkan prinsip pendelegasian tugas (*delegation*).

---

### **Percobaan 2: Relasi Multi-Class (Pelanggan, Mobil, dan Sopir)**

#### **A. Deskripsi Percobaan**
Percobaan ini memodelkan sistem rental mobil di mana kelas `pelanggan` berelasi dengan kelas `mobil` dan `sopir` untuk menghitung total biaya sewa berdasarkan durasi (hari).

#### **B. Source Code**

1. **`mobil.java`**
```java
package percobaan2jobsheet4;

public class mobil {
    private String merk;
    private int biaya;
    
    public mobil() {
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public int hitungBiayaMobil(int hari) {
        return hari * biaya;
    }
}
```

2. **`sopir.java`**
```java
package percobaan2jobsheet4;

public class sopir {
    private String nama;
    private int biaya;

    public sopir() {
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public int hitungBiayaSopir(int hari) {
        return hari * biaya;
    }
}
```

3. **`pelanggan.java`**
```java
package percobaan2jobsheet4;

public class pelanggan {
    private String nama;
    private mobil mobil;
    private sopir sopir;
    private int hari;

    public pelanggan() {
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setMobil(mobil mobil) {
        this.mobil = mobil;
    }

    public mobil getMobil() {
        return mobil;
    }

    public void setSopir(sopir sopir) {
        this.sopir = sopir;
    }

    public sopir getSopir() {
        return sopir;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }

    public int getHari() {
        return hari;
    }

    public int hitungBiayaTotal() {
        return mobil.hitungBiayaMobil(hari) + sopir.hitungBiayaSopir(hari);
    }
}
```

4. **`mainpercobaan2.java`**
```java
package percobaan2jobsheet4;

public class mainpercobaan2 {
    public static void main(String[] args) {
        mobil m = new mobil();
        m.setMerk("Avanza");
        m.setBiaya(350000);

        sopir s = new sopir();
        s.setNama("John Doe");
        s.setBiaya(200000);

        pelanggan p = new pelanggan();
        p.setNama("John Doe");
        p.setMobil(m);
        p.setSopir(s);
        p.setHari(2);

        System.out.println("Biaya Total = " + p.hitungBiayaTotal());
    }
}
```

#### **C. Output Program**
```text
Biaya Total = 1100000
```

#### **D. Analisis**
- Kelas `pelanggan` memiliki atribut referensi ke kelas `mobil` dan `sopir`.
- Metode `hitungBiayaTotal()` pada `pelanggan` menghitung total biaya dengan memanggil metode `hitungBiayaMobil(hari)` pada objek `mobil` (350.000 × 2 = 700.000) dan `hitungBiayaSopir(hari)` pada objek `sopir` (200.000 × 2 = 400.000), menghasilkan total 1.100.000.

---

### **Percobaan 3: Multiplicity dan Null Handling (Kereta Api dan Pegawai)**

#### **A. Deskripsi Percobaan**
Percobaan ini mendemonstrasikan relasi antara `keretaapi` dengan kelas `pegawai` sebagai masinis dan asisten masinis, termasuk penanganan kondisi ketika objek asisten bernilai `null`.

#### **B. Source Code**

1. **`pegawai.java`**
```java
package percobaan3jobsheet4;

public class pegawai {
    private String nip;
    private String nama;

    public pegawai(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String info() {
        String info = "";
        info += "NIP       : " + getNip() + "\n";
        info += "Nama      : " + getNama();
        return info;
    }
}
```

2. **`keretaapi.java`**
```java
package percobaan3jobsheet4;

public class keretaapi {
    private String nama;
    private String kelas;
    private pegawai masinis;
    private pegawai assistent;

    public keretaapi(String nama, String kelas, pegawai masinis) {
        this.nama = nama;
        this.kelas = kelas;
        this.masinis = masinis;
    }

    public keretaapi(String nama, String kelas, pegawai masinis, pegawai assistent) {
        this.nama = nama;
        this.kelas = kelas;
        this.masinis = masinis;
        this.assistent = assistent;
    }

    public void setmasinis(pegawai masinis) {
        this.masinis = masinis;
    }

    public pegawai getmasinis() {
        return masinis;
    }

    public void setassitent(pegawai assistent) {
        this.assistent = assistent;
    }

    public String info() {
        String info = "";
        info += "Nama: " + this.nama + "\n";
        info += "Kelas: " + this.kelas + "\n";
        info += "Masinis: \n" + this.masinis.info() + "\n";
        if (this.assistent != null) {
            info += "Asisten: \n" + this.assistent.info() + "\n";
        }
        return info;
    }
}
```

3. **`mainpercobaan3.java`**
```java
package percobaan3jobsheet4;

public class mainpercobaan3 {
    public static void main(String[] args) {
        pegawai masinis = new pegawai("1234", "Faren Santoso");
        pegawai assistent = new pegawai("5678", "Patrick Bintang");
        keretaapi keretaapi = new keretaapi("Gaya Baru", "Bisnis", masinis, assistent);
        System.out.println(keretaapi.info());
    }
}
```

4. **`mainpertanyaan.java`**
```java
package percobaan3jobsheet4;

public class mainpertanyaan {
    public static void main(String[] args) {
        pegawai masinis = new pegawai("1234", "Faren Santoso");
        // Asisten bernilai null karena menggunakan konstruktor 3 parameter
        keretaapi keretaapi = new keretaapi("Gaya Baru", "Bisnis", masinis);
        System.out.println(keretaapi.info());
    }
}
```

#### **C. Output Program**
- **Output `mainpercobaan3` (dengan asisten):**
```text
Nama: Gaya Baru
Kelas: Bisnis
Masinis: 
NIP       : 1234
Nama      : Faren Santoso
Asisten: 
NIP       : 5678
Nama      : Patrick Bintang
```

- **Output `mainpertanyaan` (tanpa asisten):**
```text
Nama: Gaya Baru
Kelas: Bisnis
Masinis: 
NIP       : 1234
Nama      : Faren Santoso
```

#### **D. Analisis dan Pembahasan Masalah NullPointerException**
- Kelas `keretaapi` menyediakan *constructor overloading* (dengan atau tanpa asisten).
- Jika objek `assistent` bernilai `null` dan method `assistent.info()` dipanggil secara langsung tanpa pengecekan, Java akan melempar error `NullPointerException`.
- Solusi: Menambahkan kondisi percabangan `if (this.assistent != null)` sebelum memanggil `this.assistent.info()`, sehingga program dapat berjalan dengan aman baik saat asisten tersedia maupun tidak.

---

### **Percobaan 4: Relasi 1-ke-Banyak Menggunakan Array of Objects (Gerbong, Kursi, Penumpang)**

#### **A. Deskripsi Percobaan**
Percobaan ini mengimplementasikan relasi 1-ke-banyak (*One-to-Many*) di mana satu objek `gerbong` mengelola banyak objek `kursi` menggunakan array `kursi[]`, dan setiap `kursi` dapat diisi oleh satu objek `penumpang`.

#### **B. Source Code**

1. **`penumpang.java`**
```java
package percobaan4jobsheet4;

public class penumpang {
    private String ktp;
    private String nama;

    public penumpang(String ktp, String nama) {
        this.ktp = ktp;
        this.nama = nama;
    }

    public String getKtp() {
        return ktp;
    }

    public String getNama() {
        return nama;
    }

    public String info() {
        String info = "";
        info += "Ktp: " + ktp + "\n";
        info += "Nama: " + nama + "\n";
        return info;
    }
}
```

2. **`kursi.java`**
```java
package percobaan4jobsheet4;

public class kursi {
    private String nomor;
    private penumpang penumpang;

    public kursi(String nomor) {
        this.nomor = nomor;
    }

    public void setPenumpang(penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public penumpang getPenumpang() {
        return penumpang;
    }

    public String info() {
        String info = "";
        info += "Nomor : " + nomor + "\n";
        if (this.penumpang != null) {
            info += "Penumpang : \n" + penumpang.info() + "\n";
        }
        return info;
    }
}
```

3. **`gerbong.java`**
```java
package percobaan4jobsheet4;

public class gerbong {
    private String kode;
    private kursi[] arrayKursi;

    public gerbong(String kode, int jumlah) {
        this.kode = kode;
        this.arrayKursi = new kursi[jumlah];
        this.intKursi();
    }

    private void intKursi() {
        for (int i = 0; i < arrayKursi.length; i++) {
            arrayKursi[i] = new kursi(kode + "-" + (i + 1));
        }
    }

    public String getKode() {
        return kode;
    }

    // Memasukkan penumpang ke kursi berdasarkan nomor urut (1-indexed)
    public void setPenumpang(penumpang penumpang, int nomor) {
        this.arrayKursi[nomor - 1].setPenumpang(penumpang);
    }

    public String info() {
        String info = "";
        info += "Kode : " + kode + "\n";
        for (kursi kursi : arrayKursi) {
            info += kursi.info();
        }
        return info;
    }
}
```

4. **`mainpercobaan4.java`**
```java
package percobaan4jobsheet4;

public class mainpercobaan4 {
    public static void main(String[] args) {
        penumpang p = new penumpang("12345", "Mr. Krab");
        gerbong gerbong = new gerbong("A", 10);
        gerbong.setPenumpang(p, 1);
        System.out.println(gerbong.info());
    }
}
```

#### **C. Output Program**
```text
Kode : A
Nomor : A-1
Penumpang : 
Ktp: 12345
Nama: Mr. Krab

Nomor : A-2
Nomor : A-3
Nomor : A-4
Nomor : A-5
Nomor : A-6
Nomor : A-7
Nomor : A-8
Nomor : A-9
Nomor : A-10
```

#### **D. Analisis**
- Di dalam konstruktor `gerbong`, dibuat sejumlah objek `kursi` sesuai parameter `jumlah` melalui pemanggilan fungsi `intKursi()`.
- Metode `setPenumpang(penumpang, nomor)` menempatkan penumpang pada indeks tertentu (`nomor - 1`).
- Pada saat iterasi cetak `info()`, kursi yang kosong (`penumpang == null`) hanya mencetak nomor kursinya saja tanpa menimbulkan *exception*.

---

### **Percobaan 5: Relasi Komposisi (Mobil dan Mesin)**

#### **A. Deskripsi Percobaan**
Percobaan ini mendemonstrasikan konsep **Komposisi** (*Composition*), di mana kelas `Mobil` memiliki atribut objek `Mesin` yang diinstansiasi secara langsung di dalam konstruktor `Mobil`, menandakan kepemilikan mutlak dan siklus hidup yang terikat kuat.

#### **B. Source Code**

1. **`Mesin.java`**
```java
package percobaan5jobsheet4;

public class Mesin {
    private String tipe;

    public Mesin() {
        this.tipe = "4-Silinder";
    }

    public String getTipe() {
        return this.tipe;
    }
}
```

2. **`Mobil.java`**
```java
package percobaan5jobsheet4;

public class Mobil {
    private String merek;
    private Mesin mesin;

    public Mobil(String merek) {
        this.merek = merek;
        this.mesin = new Mesin(); // Mesin tercipta bersamaan dengan Mobil
    }

    public void tampilkanInfo() {
        System.out.println("Mobil : " + merek);
        System.out.println("Mesin : " + mesin.getTipe());
    }
}
```

3. **`Mainpercobaan5.java`**
```java
package percobaan5jobsheet4;

public class Mainpercobaan5 {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Avanza");
        mobil.tampilkanInfo();
    }
}
```

#### **C. Output Program**
```text
Mobil : Avanza
Mesin : 4-Silinder
```

#### **D. Analisis**
- Pada relasi komposisi, objek `Mesin` diinstansiasi langsung di dalam kelas `Mobil` (`this.mesin = new Mesin();`).
- Hal ini menunjukkan relasi *strong aggregation* (komposisi): jika objek `Mobil` dimusnahkan, maka objek `Mesin` di dalamnya juga ikut musnah, berbeda dengan agregasi biasa di mana komponen mesin di-passing dari luar.

---

### **Percobaan 6: Relasi Ketergantungan / Dependency (Laptop dan Printer)**

#### **A. Deskripsi Percobaan**
Percobaan ini mendemonstrasikan relasi **Dependency** (*Uses-A*), di mana kelas `Laptop` berinteraksi dengan kelas `Printer` bukan sebagai atribut permanen, melainkan sebagai parameter sementara pada metode `cetakDokumen()`.

#### **B. Source Code**

1. **`Printer.java`**
```java
package percobaan6jobsheet4;

public class Printer {
    private String merk;

    public Printer(String merk) {
        this.merk = merk;
    }

    public void cetak(String namaFile) {
        System.out.println("[" + merk + "] Mencetak " + namaFile + "...");
        System.out.println("[" + merk + "] Selesai Mencetak");
    }
}
```

2. **`Laptop.java`**
```java
package percobaan6jobsheet4;

public class Laptop {
    private String merk;

    public Laptop(String merk) {
        this.merk = merk;
    }

    // Dependency: Printer digunakan sebagai parameter method
    public void cetakDokumen(Printer printer, String namaFile) {
        System.out.println(merk + " mengirim dokumen ke printer....");
        printer.cetak(namaFile);
    }
}
```

3. **`Mainpercobaan6.java`**
```java
package percobaan6jobsheet4;

public class Mainpercobaan6 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Thinkpad");
        Printer printer = new Printer("Epson L3115");
        laptop.cetakDokumen(printer, "Laporan.pdf");
    }
}
```

#### **C. Output Program**
```text
Thinkpad mengirim dokumen ke printer....
[Epson L3115] Mencetak Laporan.pdf...
[Epson L3115] Selesai Mencetak
```

#### **D. Analisis**
- Kelas `Laptop` **tidak** menyimpan referensi atribut `Printer`.
- Hubungan antara `Laptop` dan `Printer` hanya terjadi saat method `cetakDokumen(Printer printer, String namaFile)` dipanggil. Ini merupakan implementasi murni dari konsep *Dependency* (*Loose Coupling*).

---

## 4. KESIMPULAN

Berdasarkan praktikum Jobsheet 4 yang telah diselesaikan, dapat diambil beberapa kesimpulan penting:

| Tipe Relasi | Karakteristik | Contoh Kasus pada Praktikum |
| :--- | :--- | :--- |
| **Asosiasi / Agregasi** | Relasi kepemilikan (*has-a*), objek luar dimasukkan via konstruktor / *setter*. Objek penyusun dapat berdiri sendiri. | `Laptop` memiliki `Processor`, `pelanggan` berelasi dengan `mobil` dan `sopir`. |
| **Relasi 1-to-Many** | Satu objek induk menaungi kumpulan objek anak menggunakan *array* atau koleksi. | `gerbong` memiliki array `kursi[]`, setiap `kursi` dapat menampung `penumpang`. |
| **Komposisi** | Relasi kepemilikan kuat (*strong whole-part*), objek bagian diciptakan di dalam objek induk dan siklus hidupnya terikat penuh. | `Mobil` menginstansiasi objek `Mesin` di dalam konstruktornya. |
| **Ketergantungan (Dependency)** | Relasi pemanfaatan sementara (*uses-a*), objek kelas lain hanya diterima sebagai parameter metode. | `Laptop` menggunakan objek `Printer` pada metode `cetakDokumen()`. |

Selain itu, pentingnya penanganan referensi `null` menggunakan validasi percabangan (`if != null`) sangat krusial untuk mencegah terjadinya *runtime exception* `NullPointerException` pada relasi antar objek.
