# Laporan Praktikum Pemrograman Berbasis Objek
## Pertemuan 7: Overloading dan Overriding

- **Mata Kuliah:** Praktikum Pemrograman Berbasis Objek (RTI253008)
- **Topik:** Overloading dan Overriding
- **Bahasa Pemrograman:** Java (JDK 21+)
- **Lokasi Proyek:** `jobsheet7`

---

## Daftar Isi
1. [Tujuan / Capaian Praktikum](#a-capaian-praktikum)
2. [Ringkasan Teori](#b-ringkasan-teori)
3. [Percobaan 1: Overloading Method (Perkalian)](#c-percobaan-1-overloading-method-perkalian)
4. [Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)](#d-percobaan-2-pemilihan-overload-oleh-compiler-resolusi)
5. [Percobaan 3: Overloading Konstruktor (Kucing)](#e-percobaan-3-overloading-konstruktor-kucing)
6. [Percobaan 4: Dasar Overriding (Ikan dan Piranha)](#f-percobaan-4-dasar-overriding-ikan-dan-piranha)
7. [Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)](#g-percobaan-5-overloading-dan-overriding-bersama-karyawan-staff-manager)
8. [Tugas Mandiri](#h-tugas-mandiri)
   - [Tugas 1: Overloading pada Class Segitiga](#tugas-1-overloading-pada-class-segitiga)
   - [Tugas 2: Overriding pada Manusia, Dosen, dan Mahasiswa](#tugas-2-overriding-pada-manusia-dosen-dan-mahasiswa)
   - [Tugas 3: Pertanyaan Singkat & Tabel Perbandingan](#tugas-3-jawab-singkat)

---

## A. Capaian Praktikum
Setelah menyelesaikan praktikum ini, mahasiswa mampu:
1. Menjelaskan konsep *overloading* dan *overriding* beserta perbedaannya (*signature*, tipe kembalian, dan aturan akses).
2. Membuat *overloading* method dan konstruktor berdasarkan jumlah, tipe, dan urutan parameter, serta memanggil konstruktor lain dengan `this(...)`.
3. Memprediksi *overload* yang dipilih compiler berdasarkan urutan *widening*, *boxing*, dan *varargs*.
4. Menerapkan *overriding* dengan `@Override` dan `super.namaMethod()`, serta menerapkan aturan akses, tipe kembalian (*covariant return*), `final`, dan `exception`.
5. Menggabungkan *overloading* dan *overriding* pada hierarki kelas `Karyawan` – `Staff` – `Manager`.

---

## B. Ringkasan Teori

### 1. Method Overloading
*Overloading* adalah penulisan beberapa method dengan nama yang sama di dalam satu class (atau hierarki class), namun memiliki daftar parameter (*signature*) yang berbeda.
- **Pembeda Overloading:** Jumlah parameter, tipe data parameter, atau urutan tipe data parameter.
- **Bukan Pembeda:** Tipe kembalian (*return type*), nama variabel parameter, dan *access modifier*.
- Pemilihan method yang dipanggil ditentukan saat waktu kompilasi (*compile-time polymorphism* / *early binding*).

### 2. Resolusi Overload oleh Compiler
Ketika terdapat beberapa method overloaded yang kompatibel, compiler Java mencocokkannya melalui 3 fase berurutan (JLS §15.12.2):
1. **Fase 1 (Widening Primitif):** Pencocokan identitas tipe dan pelebaran tipe primitif (misal `int` ke `long`, `int` ke `double`) tanpa autoboxing atau varargs.
2. **Fase 2 (Autoboxing / Widening Reference):** Pencocokan dengan pembungkusan nilai primitif ke wrapper class (misal `int` ke `Integer`), yang kemudian dapat diperlebar ke supertipe objek (misal `Integer` ke `Object`).
3. **Fase 3 (Varargs):** Pencocokan dengan parameter variabel bertipe array (`T...`).

### 3. Constructor Overloading
Konstruktor juga dapat di-overload agar objek dapat diinstansiasi dengan beberapa variasi argumen. Konstruktor dapat memanggil konstruktor lain dalam kelas yang sama menggunakan pernyataan `this(...)` pada baris pertama tubuh konstruktor.

### 4. Method Overriding
*Overriding* terjadi saat subclass mendeklarasikan ulang method yang diwarisi dari superclass dengan nama dan daftar parameter (*signature*) yang sama persis, untuk memberikan perilaku yang lebih spesifik (*runtime polymorphism* / *late binding*).
- **Aturan Overriding:**
  1. *Signature* (nama method dan parameter) harus sama persis.
  2. Tipe kembalian harus sama, atau merupakan subtipe dari tipe kembalian superclass (*covariant return type*).
  3. Hak akses (*access modifier*) tidak boleh lebih sempit daripada superclass (harus sama atau lebih luas).
  4. Tidak boleh melempar *checked exception* baru atau yang lebih luas dari yang dideklarasikan oleh method superclass.
  5. Method `static`, `private`, dan `final` **tidak dapat di-override**.

---

## C. Percobaan 1: Overloading Method (Perkalian)

### 1. Struktur Kode Program
- **`Perkalian.java`**
  ```java
  package jobsheet7;

  public class Perkalian {
      public int kali(int a, int b){
          return a * b;
      }
      public int kali (int a, int b, int c){
          return a * b * c;
      }
      public double kali(double a, double b){
          return a * b;
      }
      public void tampilkan(int nomor, String label){
          System.out.println(nomor + ". " + label);
      }
      public void tampilkan(String label, int nomor){
          System.out.println(label + "# " + nomor);
      }
  }
  ```
- **`MainPercobaan1.java`**
  ```java
  package jobsheet7;

  public class MainPercobaan1 {
      public static void main (String [] args){
          Perkalian p = new Perkalian();
          System.out.println("kali (25, 43)          = " + p.kali(25, 43));
          System.out.println("kali (34, 23, 56)      = " + p.kali(34, 23, 56));
          System.out.println("kali (25.5, 4.0)       = " + p.kali(25.5, 4.0));
      }
  }
  ```

### 2. Output Program
```text
kali (25, 43)          = 1075
kali (34, 23, 56)      = 43792
kali (25.5, 4.0)       = 102.0
```

### 3. Hasil Eksperimen (Langkah 4)
| Tambahan pada class Perkalian / Main | Hasil & Pesan Error | Penjelasan |
| :--- | :--- | :--- |
| `public long kali(int a, int b) { return (long) a * b; }` | **Pesan error:** `method kali(int,int) is already defined in class Perkalian` | Tipe kembalian bukan bagian dari *method signature*. Compiler mendeteksi dua method dengan signature identik `kali(int, int)`. |
| `public int kali(int x, int y) { return x * y; }` | **Pesan error:** `method kali(int,int) is already defined in class Perkalian` | Nama variabel parameter tidak membedakan method; compiler hanya melihat tipe parameternya `(int, int)`. |
| Pada main: `p.kali(5, 2.5)`, `p.kali(2, 3)`, `p.kali(2.0, 3)` | **Output:**<br>`12.5`<br>`6`<br>`6.0` | `kali(5, 2.5)` dan `kali(2.0, 3)` mencocokkan `kali(double, double)` melalui pelebaran primitif (*widening* `int -> double`), sedangkan `kali(2, 3)` mencocokkan `kali(int, int)`. |

### 4. Jawaban Pertanyaan Percobaan 1
1. **Sebutkan method hasil overloading pada Perkalian dan pembeda tiap pasangannya:**
   - `kali(int, int)` dan `kali(int, int, int)`: Pembedanya adalah **jumlah parameter** (2 parameter vs 3 parameter).
   - `kali(int, int)` dan `kali(double, double)`: Pembedanya adalah **tipe data parameter** (`int` vs `double`).
   - `tampilkan(int, String)` dan `tampilkan(String, int)`: Pembedanya adalah **urutan tipe data parameter** (`int, String` vs `String, int`).
2. **Pada `p.kali(25.5, 4.0)`, versi `kali()` mana yang dipanggil? Mengapa bukan versi `int`?**
   - Yang dipanggil adalah `kali(double, double)`.
   - **Alasan:** Literal pecahan `25.5` dan `4.0` bertipe `double`. Java mencari method yang parameternya cocok secara langsung (*exact match*). Tipe `double` tidak dapat dipersempit (*narrowing*) ke `int` secara otomatis tanpa *explicit casting*.
3. **Mengapa `tampilkan(int, String)` dan `tampilkan(String, int)` sah sebagai overloading, sedangkan dua method yang hanya beda tipe kembalian atau nama parameter tidak?**
   - Signature ditentukan oleh **nama method dan urutan tipe parameternya**. Pemanggil dapat dibedakan secara unik oleh compiler saat memanggil `tampilkan(1, "A")` vs `tampilkan("A", 1)`.
   - Sebaliknya, nama variabel tidak dikirim oleh pemanggil, dan tipe kembalian tidak dapat diandalkan oleh compiler untuk resolusi (terutama jika hasil pemanggilan method tidak ditampung ke variabel atau diabaikan).
4. **Pada eksperimen ketiga, mengapa `kali(5, 2.5)` menghasilkan 12.5 dan bukan error?**
   - Karena Java mengizinkan **Widening Primitive Conversion**. Argumen `5` bertipe `int` secara otomatis diperlebar menjadi `5.0` bertipe `double` sehingga cocok dengan method `kali(double a, double b)`. Hasil `5.0 * 2.5 = 12.5`.

---

## D. Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)

### 1. Struktur Kode Program
- **`Resolusi.java`**
  ```java
  package jobsheet7;

  public class Resolusi {
      public static void tampil(long x) {
          System.out.println(" tampil(long)        : " + x);
      }
      public static void tampil(Integer x){
          System.out.println(" tampil(integer)     :" + x);
      }
      public static void tampil(Object x){
          System.out.println(" tampil (Object)     :" + x);
      }
      public static void tampil(int...x){
          System.out.println("tampil(int...)       :" + x.length + " elemen");
      }
  }
  ```
- **`MainPercobaan2.java`**
  ```java
  package jobsheet7;

  public class MainPercobaan2 {
      public static void main(String [] args){
          Resolusi.tampil(5);
          Resolusi.tampil(5L);
          Resolusi.tampil(Integer.valueOf(7));
          Resolusi.tampil(3.5);
          Resolusi.tampil("Java");
          Resolusi.tampil();
          Resolusi.tampil(1, 2, 3);
      }
  }
  ```

### 2. Output & Tabel Prediksi (Langkah 2)
| Pemanggilan | Prediksi | Hasil Sebenarnya | Keterangan / Fase Resolusi |
| :--- | :--- | :--- | :--- |
| `tampil(5)` | `tampil(long) : 5` | `tampil(long) : 5` | Fase 1: Widening primitif `int -> long` |
| `tampil(5L)` | `tampil(long) : 5` | `tampil(long) : 5` | Fase 1: Exact match `long` |
| `tampil(Integer.valueOf(7))` | `tampil(Integer) : 7` | `tampil(Integer) : 7` | Fase 1: Exact match tipe referensi `Integer` |
| `tampil(3.5)` | `tampil(Object) : 3.5` | `tampil(Object) : 3.5` | Fase 2: Autoboxing `double -> Double`, lalu widening reference `Double -> Object` |
| `tampil("Java")` | `tampil(Object) : Java` | `tampil(Object) : Java` | Fase 1: Widening reference `String -> Object` |
| `tampil()` | `tampil(int...) : 0 elemen` | `tampil(int...) : 0 elemen` | Fase 3: Varargs kosong (panjang array 0) |
| `tampil(1, 2, 3)` | `tampil(int...) : 3 elemen` | `tampil(int...) : 3 elemen` | Fase 3: Varargs dengan 3 elemen |

### 3. Eksperimen Kumulatif (Langkah 3)
| Kondisi | Overload yang Dipanggil oleh `tampil(5)` | Penjelasan |
| :--- | :--- | :--- |
| Semua overload aktif | `tampil(long)` | Fase 1: Widening `int -> long` dipilih lebih dulu daripada boxing. |
| `tampil(long)` dikomentari | `tampil(Integer)` | Fase 1 gagal, masuk Fase 2: `5` di-autoboxing menjadi `Integer`. |
| `tampil(long)` dan `tampil(Integer)` dikomentari | `tampil(Object)` | Fase 2: `5` di-boxing ke `Integer`, lalu polimorfisme `Integer` adalah `Object`. |
| `tampil(long)`, `tampil(Integer)`, dan `tampil(Object)` dikomentari | `tampil(int...)` | Fase 1 & 2 gagal, masuk Fase 3: Varargs `int...`. |

### 4. Eksperimen Widening lalu Boxing (Langkah 4)
Class `Eksperimen2`:
```java
public class Eksperimen2 {
    static void tampilLong(Long x) {
        System.out.println("Long: " + x);
    }
    public static void main(String[] args) {
        tampilLong(5);
    }
}
```
- **Pesan error:** `incompatible types: int cannot be converted to Long`
- **Konsep:** Java tidak mengizinkan operasi *widening* primitif yang langsung dilanjutkan *boxing* (`int -> long -> Long`) dalam satu pemanggilan method. Java hanya mendukung *boxing* lalu *widening* tipe referensi (`int -> Integer -> Object`).

### 5. Jawaban Pertanyaan Percobaan 2
1. **Mengapa `tampil(5)` memilih `tampil(long)` dan bukan `tampil(Integer)`?**
   - Karena compiler memproses resolusi overload dalam 3 fase. **Fase 1 (Widening primitif)** memiliki prioritas lebih tinggi daripada **Fase 2 (Autoboxing)**. Nilai `5` (`int`) diperlebar menjadi `long` di Fase 1, sehingga compiler langsung berhenti dan memilih `tampil(long)`.
2. **Jelaskan perpindahan overload pada tiap baris tabel Langkah 3:**
   - Urutan prioritas compiler: `widening primitif (long)` $\rightarrow$ `autoboxing (Integer)` $\rightarrow$ `boxing + reference widening (Object)` $\rightarrow$ `varargs (int...)`. Setiap kali opsi teratas dikomentari, compiler beralih ke mekanisme berikutnya yang paling kompatibel.
3. **Mengapa `tampilLong(5)` gagal, sedangkan `tampil(5)` dapat berakhir pada `tampil(Object)`?**
   - `tampilLong(5)` membutuhkan dua langkah: *widening* `int` ke `long` lalu *boxing* ke `Long`. Kombinasi ini dilarang oleh Java Language Specification.
   - Sedangkan pada `tampil(Object)`: `5` di-boxing ke `Integer`, kemudian `Integer` diperlakukan sebagai supertipe referensinya yaitu `Object` (*widening reference*), yang sah di Java.
4. **Tantangan: Prediksi output `Resolusi.tampil((short) 3)` dan `Resolusi.tampil('A')`:**
   - `Resolusi.tampil((short) 3)` menghasilkan `tampil(long) : 3`. (Tipe `short` otomatis di-widening ke `long`).
   - `Resolusi.tampil('A')` menghasilkan `tampil(long) : 65`. (Tipe `char` memiliki nilai ASCII/Unicode 65 dan di-widening ke `long`).

---

## E. Percobaan 3: Overloading Konstruktor (Kucing)

### 1. Struktur Kode Program
- **`Kucing.java`**
  ```java
  package jobsheet7;

  public class Kucing {
      private String nama;
      private int umur;

      public Kucing (String nama) {
          this(nama, 1);
          System.out.println("Konstruktor 1 parameter selesai");
      }

      public Kucing(String nama, int umur){
          this.nama = nama;
          this.umur = umur;
          System.out.println("Konstruktor 2 parameter selesai");
      }

      public void info(){
          System.out.println("Kucing " + nama + ", umur " + umur + " tahun");
      }
  }
  ```
- **`MainPercobaan3.java`**
  ```java
  package jobsheet7;

  public class MainPercobaan3 {
      public static void main (String [] args){
          Kucing a = new Kucing("Tom");
          a.info();
          System.out.println();
          Kucing b = new Kucing("Garfield", 5);
          b.info();
      }
  }
  ```

### 2. Output Program
```text
Konstruktor 2 parameter selesai
Konstruktor 1 parameter selesai
Kucing Tom, umur 1 tahun

Konstruktor 2 parameter selesai
Kucing Garfield, umur 5 tahun
```

### 3. Eksperimen Konstruktor Default (Langkah 4)
Ketika memanggil `Kucing c = new Kucing();`:
- **Pesan error:** `constructor Kucing in class Kucing cannot be applied to given types; required: java.lang.String or java.lang.String,int; found: no arguments`
- **Konsep:** Ketika pemrogram telah mendefinisikan minimal satu konstruktor berparameter sendiri, compiler Java tidak akan lagi menyediakan konstruktor *default* (tanpa parameter).

### 4. Jawaban Pertanyaan Percobaan 3
1. **Mengapa "Konstruktor 2 parameter selesai" tercetak lebih dulu daripada "Konstruktor 1 parameter selesai" pada `new Kucing("Tom")`?**
   - Pada baris pertama konstruktor 1 parameter terdapat pemanggilan `this(nama, 1)`. Perintah ini mendelegasikan eksekusi langsung ke konstruktor 2 parameter terlebih dahulu. Setelah seluruh isi konstruktor 2 parameter selesai dijalankan dan mencetak pesannya, kontrol program baru kembali ke konstruktor 1 parameter untuk mengeksekusi sisa perintahnya.
2. **Apa keuntungan `this(nama, 1)` dibandingkan menyalin isi konstruktor kedua ke konstruktor pertama?**
   - **Mencegah Redundansi Kode (DRY - Don't Repeat Yourself):** Logika inisialisasi hanya ditulis satu kali di konstruktor utama.
   - **Kemudahan Perawatan (Maintainability):** Jika logika inisialisasi atau validasi berubah, kita hanya perlu mengubah satu konstruktor tanpa risiko ketidakkonsistenan.
3. **Penambahan konstruktor 0 parameter:**
   ```java
   public Kucing() {
       this("Tanpa Nama");
       System.out.println("Konstruktor 0 parameter selesai");
   }
   ```
   - **Urutan eksekusi ketiga konstruktor:** Konstruktor 0 parameter memanggil konstruktor 1 parameter, konstruktor 1 parameter memanggil konstruktor 2 parameter.
   - **Output saat `new Kucing()`:**
     ```text
     Konstruktor 2 parameter selesai
     Konstruktor 1 parameter selesai
     Konstruktor 0 parameter selesai
     ```

---

## F. Percobaan 4: Dasar Overriding (Ikan dan Piranha)

### 1. Struktur Kode Program
- **`Ikan.java`**
  ```java
  package jobsheet7;

  public class Ikan {
      public void swim(){
          System.out.println("Ikan bisa berenang");
      }
      public Ikan beranak(){
          return new Ikan();
      }
  }
  ```
- **`Piranha.java`**
  ```java
  package jobsheet7;

  public class Piranha extends Ikan {
      @Override 
      public void swim(){
          super.swim();
          System.out.println("Piranha bisa makan daging");
      }
      @Override 
      public Piranha beranak(){
          return new Piranha();
      }
  }
  ```
- **`MainPercobaan4.java`**
  ```java
  package jobsheet7;

  public class MainPercobaan4 {
      public static void main (String [] args ){
          Ikan a = new Ikan();
          Piranha c = new Piranha();

          a.swim();
          c.swim();

          Piranha anak = c.beranak();
          System.out.println("Tipe objek anak: " + anak.getClass().getSimpleName());
      }
  }
  ```

### 2. Output Program
```text
Ikan bisa berenang
Ikan bisa berenang
Piranha bisa makan daging
Tipe objek anak: Piranha
```

### 3. Eksperimen Melanggar Aturan Overriding (Langkah 4)
| Perubahan Kode | Pesan Error Pertama | Aturan Overriding yang Dilanggar |
| :--- | :--- | :--- |
| Hapus `public` pada `swim()` di `Piranha` | `attempting to assign weaker access privileges; was public` | Hak akses method overriding tidak boleh lebih sempit daripada method superclass (dari `public` menjadi `package-private`). |
| Tambahkan `final` pada `swim()` di `Ikan` | `overridden method is final` | Method bertanda `final` di superclass dilarang keras untuk di-override oleh subclass. |
| Ubah `swim()` di `Piranha` menjadi `swim(int jarak)`, `@Override` tetap ada | `method does not override or implement a method from a supertype` | Signature (parameter) harus identik. Karena ada `@Override`, compiler memvalidasi dan gagal menemukan `swim(int)` di superclass. |
| Tambahkan `throws Exception` pada `swim()` di `Piranha` | `overridden method does not throw Exception` | Overriding method tidak boleh melempar *checked exception* baru atau lebih luas daripada yang dideklarasikan oleh superclass. |

### 4. Jawaban Pertanyaan Percobaan 4
1. **Bandingkan `a.swim()` dan `c.swim()`. Apa peran `super.swim()`, dan apa yang tercetak bila baris itu dihapus?**
   - `a.swim()` memanggil method milik superclass `Ikan` dan mencetak `"Ikan bisa berenang"`.
   - `c.swim()` memanggil method override milik `Piranha` yang di dalamnya mengeksekusi `super.swim()` lalu mencetak `"Piranha bisa makan daging"`.
   - Peran `super.swim()` adalah memanggil implementasi dasar dari superclass agar perilakunya tetap dipertahankan. Jika dihapus, `c.swim()` hanya akan mencetak `"Piranha bisa makan daging"`.
2. **Apa manfaat covariant return pada `beranak()`? Apakah `Piranha anak = a.beranak();` valid? Mengapa?**
   - **Manfaat:** Subclass dapat mengembalikan tipe yang lebih spesifik (`Piranha` alih-alih `Ikan`), sehingga pemanggil tidak perlu melakukan type-casting manual `(Piranha) c.beranak()`.
   - `Piranha anak = a.beranak();` **TIDAK VALID** (Compile Error: `incompatible types: Ikan cannot be converted to Piranha`). Reference `a` bertipe `Ikan`, dan method `beranak()` pada `Ikan` mengembalikan objek bertipe `Ikan`. Di Java, superclass tidak bisa otomatis ditugaskan ke reference subclass.
3. **Sebutkan aturan overriding yang dilanggar pada tiap baris tabel Langkah 4:**
   - Baris 1: Aturan *Access Modifier* (hak akses tidak boleh dipersempit).
   - Baris 2: Aturan *Non-final Method* (method final dilarang di-override).
   - Baris 3: Aturan *Signature Matching* (parameter method harus sama persis).
   - Baris 4: Aturan *Exception Hierarchy* (tidak boleh melempar checked exception baru/lebih luas).
4. **Pada baris ketiga tabel, apa yang terjadi bila `@Override` dihapus? Apakah `swim(int)` overriding atau overloading?**
   - Kode akan **berhasil dikompilasi (lolos kompilasi)**.
   - Method `swim(int)` berstatus **overloading**, bukan overriding, karena nama method sama tetapi parameternya berbeda. Pemanggilan `c.swim()` tanpa parameter akan tetap mengeksekusi method warisan dari `Ikan`.
5. **Tantangan: Jika `swim()` di `Ikan` dibuat `private` dan `Piranha` memiliki `@Override public void swim()`, apa yang terjadi? Mengapa?**
   - Terjadi **Compile Error** pada anotasi `@Override`: `method does not override or implement a method from a supertype`.
   - **Alasan:** Method `private` hanya terlihat di dalam kelas asalnya dan **tidak diwariskan** ke subclass. Karena tidak diwariskan, subclass tidak dapat meng-override-nya. Method `swim()` di `Piranha` dianggap sebagai method baru yang mandiri.

---

## G. Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)

### 1. Struktur Kode Program
- **`Karyawan.java`**
  ```java
  package jobsheet7;

  public class Karyawan {
      protected String nip;
      protected String nama;
      protected String golongan;
      protected double gajiPokok;

      public Karyawan(String nip, String nama, String golongan) {
          this.nip = nip;
          this.nama = nama;
          this.golongan = golongan;
          this.gajiPokok = hitungGajiPokok(golongan);
      }

      private static double hitungGajiPokok(String golongan) {
          return switch (golongan) {
              case "1" -> 5000000;
              case "2" -> 3000000;
              case "3" -> 2000000;
              case "4" -> 1000000;
              case "5" -> 750000;
              default -> throw new IllegalArgumentException("Golongan tidak valid: " + golongan);
          };
      }

      public String getNama() {
          return nama;
      }
      public double getGaji() {
          return gajiPokok;
      }

      public void lihatInfo() {
          System.out.println("NIP          : " + nip);
          System.out.println("Nama         : " + nama);
          System.out.println("Golongan     : " + golongan);
          System.out.printf("Gaji Pokok   : %.0f%n", gajiPokok);
      }
  }
  ```
- **`Staff.java`**
  ```java
  package jobsheet7;

  public class Staff extends Karyawan {
      private int jamLembur;
      private double tarifLembur;

      public Staff(String nip, String nama, String golongan, int jamLembur, double tarifLembur) {
          super(nip, nama, golongan);
          this.jamLembur = jamLembur;
          this.tarifLembur = tarifLembur;
      }

      // OVERLOADING: nama sama dengan getGaji() Karyawan, tetapi parameter berbeda
      public double getGaji(int jamLembur, double tarifLembur) {
          return super.getGaji() + jamLembur * tarifLembur;
      }

      // OVERRIDING: signature sama persis dengan getGaji() Karyawan
      @Override
      public double getGaji() {
          return getGaji(jamLembur, tarifLembur);
      }

      @Override
      public void lihatInfo() {
          super.lihatInfo();
          System.out.println("Jam Lembur   : " + jamLembur);
          System.out.printf("Tarif/Jam    : %.0f%n", tarifLembur);
      }
  }
  ```
- **`Manager.java`**
  ```java
  package jobsheet7;

  public class Manager extends Karyawan {
      private double tunjangan;
      private String bagian;
      private Staff[] bawahan;

      public Manager(String nip, String nama, String golongan, double tunjangan, String bagian, Staff[] bawahan) {
          super(nip, nama, golongan);
          this.tunjangan = tunjangan;
          this.bagian = bagian;
          this.bawahan = bawahan;
      }

      @Override
      public double getGaji() {
          return super.getGaji() + tunjangan;
      }

      public void viewStaff() {
          System.out.println("----------------------------------------");
          for (Staff s : bawahan) {
              s.lihatInfo();
              System.out.println("----------------------------------------");
          }
      }

      @Override 
      public void lihatInfo() { 
          System.out.println("Manager      : " + bagian);
          super.lihatInfo();
          System.out.printf("Tunjangan    : %.0f%n", tunjangan);
          viewStaff();
      }
  }
  ```
- **`MainPercobaan5.java`**
  ```java
  package jobsheet7;

  public class MainPercobaan5 {
      public static void main(String[] args) {
          Staff usman = new Staff("0003", "Usman", "2", 10, 10000);
          Staff anugrah = new Staff("0005", "Anugrah", "2", 10, 55000);

          Manager tedjo = new Manager("101", "Tedjo", "1", 5000000, "Administrasi", new Staff[] {usman, anugrah});
          tedjo.lihatInfo();

          System.out.println();
          System.out.println("Simulasi Lembur Usman 20 jam @ 15000 = " + (long) usman.getGaji(20, 15000));
      }
  }
  ```

### 2. Output Program
```text
Manager      : Administrasi
NIP          : 101
Nama         : Tedjo
Golongan     : 1
Gaji Pokok   : 5000000
Tunjangan    : 5000000
----------------------------------------
NIP          : 0003
Nama         : Usman
Golongan     : 2
Gaji Pokok   : 3000000
Jam Lembur   : 10
Tarif/Jam    : 10000
----------------------------------------
NIP          : 0005
Nama         : Anugrah
Golongan     : 2
Gaji Pokok   : 3000000
Jam Lembur   : 10
Tarif/Jam    : 55000
----------------------------------------

Simulasi Lembur Usman 20 jam @ 15000 = 3300000
```

### 3. Jawaban Pertanyaan Percobaan 5
1. **Tunjuk method yang termasuk overloading dan overriding pada ketiga class:**
   - **Overloading:**
     - Pada class `Staff`: Method `getGaji(int jamLembur, double tarifLembur)` meng-overload `getGaji()` dari superclass `Karyawan`. Pembedanya adalah adanya dua parameter numerik `(int, double)` dibandingkan tanpa parameter.
   - **Overriding:**
     - Pada class `Staff`: Method `getGaji()` dan `lihatInfo()` meng-override method `getGaji()` dan `lihatInfo()` milik `Karyawan`.
     - Pada class `Manager`: Method `getGaji()` dan `lihatInfo()` meng-override method `getGaji()` dan `lihatInfo()` milik `Karyawan`.
2. **Mengapa `getGaji(int, double)` memakai `super.getGaji()`, sedangkan `getGaji()` memanggil `getGaji(jamLembur, tarifLembur)`? Apa yang terjadi bila `getGaji(int, double)` diganti `return getGaji() + jamLembur * tarifLembur;`?**
   - `getGaji(int, double)` memanggil `super.getGaji()` untuk mengambil gaji pokok murni dari `Karyawan` tanpa menyertakan tunjangan atau lembur lain.
   - `getGaji()` memanggil `getGaji(jamLembur, tarifLembur)` untuk mendelegasikan perhitungan lembur bawaan atribut objek tanpa menduplikasi rumus matematika.
   - Jika `getGaji(int, double)` diubah menjadi `return getGaji() + ...`: Terjadi **rekursi timbal-balik tak berujung (infinite recursion)** yang memicu runtime error `java.lang.StackOverflowError` karena kedua method saling memanggil satu sama lain tanpa henti.
3. **Apa akibatnya pada gaji Staff bila `getGaji()` di Staff ditulis `return jamLembur * tarifLembur;`? Apakah gaji Manager ikut berubah?**
   - Gaji Staff hanya akan bernilai sebesar upah lemburnya saja, sedangkan gaji pokok dari golongannya tidak ikut terhitung.
   - Gaji Manager **TIDAK ikut berubah**, karena perhitungan gaji Manager dihitung dari `super.getGaji() + tunjangan`, di mana `super` merujuk ke gaji pokok `Manager` sendiri di class `Karyawan`, bukan gaji para staf bawahannya.
4. **Apa hubungan Manager dengan Staff (is-a atau has-a)? Tunjuk atributnya dan bandingkan dengan hubungan Manager dengan Karyawan:**
   - Hubungan **Manager dengan Staff** adalah **has-a (Agregasi)**, ditunjukkan oleh atribut `private Staff[] bawahan;`. Seorang Manager *memiliki* relasi agregasi ke sejumlah objek Staff.
   - Hubungan **Manager dengan Karyawan** adalah **is-a (Pewarisan / Inheritance)**, ditunjukkan oleh `public class Manager extends Karyawan`. Manager *adalah seorang* Karyawan dan mewarisi seluruh karakteristik dasar Karyawan.

---

## H. Tugas Mandiri

### Tugas 1: Overloading pada Class Segitiga

#### 1. Implementasi Source Code
- **`jobsheet7/Tugas/Segitiga.java`**
  ```java
  package jobsheet7.Tugas;

  public class Segitiga {
      private int sudut;

      private void validasiSudut(int... sudutDiketahui) {
          int jumlah = 0;
          for (int s : sudutDiketahui) {
              if (s <= 0 || s >= 180) {
                  throw new IllegalArgumentException("Sudut tidak valid: " + s);
              }
              jumlah += s;
          }
          if (jumlah <= 0 || jumlah >= 180) {
              throw new IllegalArgumentException("Jumlah sudut tidak valid: " + jumlah);
          }
      }

      // OVERLOADING 1: satu parameter
      public int sisaSudut(int sudutA) {
          validasiSudut(sudutA);
          sudut = 180 - sudutA;
          return sudut;
      }

      // OVERLOADING 2: dua parameter
      public int sisaSudut(int sudutA, int sudutB) {
          validasiSudut(sudutA, sudutB);
          sudut = 180 - (sudutA + sudutB);
          return sudut;
      }

      // OVERLOADING 3: tiga parameter (keliling sembarang)
      public int keliling(int sisiA, int sisiB, int sisiC) {
          return sisiA + sisiB + sisiC;
      }

      // OVERLOADING 4: dua parameter (keliling siku-siku dengan phytagoras)
      public double keliling(int sisiA, int sisiB) {
          double c = Math.sqrt(sisiA * sisiA + sisiB * sisiB);
          return sisiA + sisiB + c;
      }

      public int getSudut() {
          return sudut;
      }
  }
  ```
- **`jobsheet7/Tugas/MainTugas1.java`**
  ```java
  package jobsheet7.Tugas;

  public class MainTugas1 {
      public static void main(String[] args) {
          Segitiga t = new Segitiga();
          System.out.println("Jumlah dua sudut lain : " + t.sisaSudut(60));
          System.out.println("Sudut ketiga          : " + t.sisaSudut(60, 50));
          System.out.println("Keliling 3, 4, 5      : " + t.keliling(3, 4, 5));
          System.out.println("Keliling siku 3, 4    : " + t.keliling(3, 4));
          System.out.println("Keliling siku 5, 12   : " + t.keliling(5, 12));
      }
  }
  ```

#### 2. Output Program Tugas 1
```text
Jumlah dua sudut lain : 120
Sudut ketiga          : 70
Keliling 3, 4, 5      : 12
Keliling siku 3, 4    : 12.0
Keliling siku 5, 12   : 30.0
```

#### 3. Jawaban Pertanyaan Analisis Tugas 1
- **(a) `keliling(3, 4, 5)` dan `keliling(3, 4)` bertipe kembalian berbeda. Apakah itu yang membuatnya sah sebagai overloading? Apa pembeda sebenarnya?**
  - **Bukan.** Perbedaan tipe kembalian (`int` vs `double`) bukan merupakan syarat yang mengesahkan overloading. Jika dua method hanya berbeda tipe kembaliannya saja dengan parameter yang sama persis, Java akan menolak dengan error duplikasi method.
  - **Pembeda sebenarnya** adalah **jumlah parameter**: `keliling(int, int, int)` memiliki 3 parameter, sedangkan `keliling(int, int)` memiliki 2 parameter.
- **(b) Apa yang terjadi bila `t.keliling(3, 4.0)` dipanggil? Tuliskan pesan error dan alasannya.**
  - **Hasil:** Terjadi **Compile Error**:
    ```text
    no suitable method found for keliling(int,double)
    ```
  - **Alasan:** Class `Segitiga` hanya menyediakan method `keliling(int, int, int)` dan `keliling(int, int)`. Argumen kedua yang diberikan adalah `4.0` bertipe `double`. Nilai bertipe `double` tidak dapat dikonversi secara otomatis (*narrowing*) ke tipe `int` karena berpotensi menghilangkan data pecahan, dan tidak ada overload yang menerima signature `(int, double)`.

---

### Tugas 2: Overriding pada Manusia, Dosen, dan Mahasiswa

#### 1. Implementasi Source Code
- **`jobsheet7/Tugas/Manusia.java`**
  ```java
  package jobsheet7.Tugas;

  public class Manusia {
      public void bernafas() {
          System.out.println("Manusia bernafas dengan paru-paru");
      }

      public void makan() {
          System.out.println("Manusia makan nasi");
      }
  }
  ```
- **`jobsheet7/Tugas/Dosen.java`**
  ```java
  package jobsheet7.Tugas;

  public class Dosen extends Manusia {
      @Override
      public void makan() {
          super.makan();
          System.out.println("Dosen makan di kantin fakultas");
      }

      public void lembur() {
          System.out.println("Dosen lembur menilai ujian");
      }
  }
  ```
- **`jobsheet7/Tugas/Mahasiswa.java`**
  ```java
  package jobsheet7.Tugas;

  public class Mahasiswa extends Manusia {
      @Override
      public void makan() {
          System.out.println("Mahasiswa makan di kantin kampus");
      }

      public void tidur() {
          System.out.println("Mahasiswa tidur di perpustakaan");
      }
  }
  ```
- **`jobsheet7/Tugas/MainTugas2.java`**
  ```java
  package jobsheet7.Tugas;

  public class MainTugas2 {
      public static void main(String[] args) {
          Manusia manusia = new Manusia();
          Dosen dosen = new Dosen();
          Mahasiswa mhs = new Mahasiswa();

          System.out.println("== Manusia ==");
          manusia.bernafas();
          manusia.makan();

          System.out.println("== Dosen ==");
          dosen.bernafas();
          dosen.makan();
          dosen.lembur();

          System.out.println("== Mahasiswa ==");
          mhs.bernafas();
          mhs.makan();
          mhs.tidur();
      }
  }
  ```

#### 2. Output Program Tugas 2
```text
== Manusia ==
Manusia bernafas dengan paru-paru
Manusia makan nasi
== Dosen ==
Manusia bernafas dengan paru-paru
Manusia makan nasi
Dosen makan di kantin fakultas
Dosen lembur menilai ujian
== Mahasiswa ==
Manusia bernafas dengan paru-paru
Mahasiswa makan di kantin kampus
Mahasiswa tidur di perpustakaan
```

#### 3. Jawaban Pertanyaan Analisis Tugas 2
- **(a) Mengapa `bernafas()` pada objek `Mahasiswa` mencetak teks milik `Manusia`, sedangkan `makan()` tidak?**
  - Objek `Mahasiswa` mewarisi method `bernafas()` dari superclass `Manusia` tanpa meng-override-nya, sehingga ketika dipanggil, kode asli superclass yang dieksekusi.
  - Sedangkan method `makan()` di-override oleh class `Mahasiswa` secara mandiri tanpa memanggil `super.makan()`, sehingga implementasi asal superclass tertimpa sepenuhnya oleh implementasi baru milik `Mahasiswa`.
- **(b) Bandingkan hasil `makan()` pada `Dosen` dan `Mahasiswa`, lalu jelaskan peran `super.makan()`:**
  - Method `makan()` pada `Dosen` mencetak dua baris (`"Manusia makan nasi"` lalu `"Dosen makan di kantin fakultas"`), sedangkan pada `Mahasiswa` hanya mencetak satu baris (`"Mahasiswa makan di kantin kampus"`).
  - Peran `super.makan()` pada `Dosen` adalah memanggil implementasi method `makan()` dari superclass `Manusia` terlebih dahulu sehingga perilaku dasar tetap dijalankan sebelum menambahkan perilaku khusus dosen. Sebaliknya, `Mahasiswa` menggantikan perilaku tersebut secara total (*full replacement*).

---

### Tugas 3: Jawab Singkat

#### 1. Tabel Perbandingan Overloading vs Overriding
| Aspek | Overloading | Overriding |
| :--- | :--- | :--- |
| **Lokasi terjadi** | Di dalam satu kelas yang sama atau antara superclass dan subclass | Wajib terjadi pada hierarki kelas (antara superclass dan subclass) |
| **Signature (parameter)** | Wajib berbeda (jumlah, tipe data, atau urutan tipe parameter) | Wajib sama persis (nama method dan tipe parameter identik) |
| **Tipe kembalian** | Boleh sama, boleh berbeda (bukan syarat penentu) | Harus sama persis, atau merupakan subtipe (*covariant return*) |
| **Access modifier** | Bebas / tidak terikat aturan inheritance | Tidak boleh lebih ketat daripada method di superclass |
| **Peran `@Override`** | Dilarang digunakan (akan memicu compile error jika dipasang) | Sangat dianjurkan untuk validasi kompilasi bahwa method benar-benar meng-override |

#### 2. Kapan Anda memilih overloading dan kapan overriding? Berikan satu contoh dari jobsheet!
- **Kapan memilih Overloading:** Ketika kita memerlukan method dengan nama yang sama untuk fungsi serupa namun mampu menerima format atau jenis input yang berbeda dalam satu kelas.
  - *Contoh Jobsheet:* Method `kali(int, int)` dan `kali(int, int, int)` pada class `Perkalian`. Keduanya melakukan perkalian, namun salah satunya menerima 2 bilangan dan yang lain menerima 3 bilangan.
- **Kapan memilih Overriding:** Ketika subclass perlu mendefinisikan ulang atau memodifikasi perilaku method yang diwarisi dari superclass agar perilakunya sesuai dengan karakteristik spesifik subclass (*polimorfisme runtime*).
  - *Contoh Jobsheet:* Method `getGaji()` pada class `Manager` dan `Staff` yang meng-override `getGaji()` milik `Karyawan` untuk menghitung gaji total sesuai komponen tunjangan atau lembur masing-masing.

#### 3. Mengapa method `static`, `private`, dan `final` tidak dapat di-override?
- **Method `static`:** Terikat pada kelas (*class level*) saat waktu kompilasi (*compile-time binding*), bukan pada objek saat waktu berjalan (*runtime dynamic dispatch*); jika ditulis ulang di subclass, ia hanya menyembunyikan (*method hiding*), bukan meng-override.
- **Method `private`:** Ruang lingkupnya tertutup hanya di dalam kelas deklarasinya sendiri dan tidak diwariskan ke subclass, sehingga subclass tidak memiliki akses untuk meng-override-nya.
- **Method `final`:** Kata kunci `final` secara eksplisit menginstruksikan compiler bahwa implementasi method tersebut bersifat mutlak dan tidak boleh diubah oleh subclass mana pun.
