# JAWABAN PERTANYAAN PRAKTIKUM JOBSHEET 6
## INHERITANCE (PEWARISAN)

**Mata Kuliah:** Praktikum Pemrograman Berbasis Objek (RTI253008)  
**Pertemuan:** 6 (Minggu 6)  
**Topik:** Pewarisan (*Inheritance*), Hak Akses (*Access Modifiers*), Kata Kunci `super` & `this`, Konstruktor (*Constructor Chaining*), dan *Method Overriding*

---

## DAFTAR ISI
- [Percobaan 1: Single Inheritance dengan extends (ClassA dan ClassB)](#percobaan-1-single-inheritance-dengan-extends-classa-dan-classb)
- [Percobaan 2: Hak Akses pada Pewarisan (private dan protected)](#percobaan-2-hak-akses-pada-pewarisan-private-dan-protected)
- [Percobaan 3: Kata Kunci this dan super (Bangun dan Tabung)](#percobaan-3-kata-kunci-this-dan-super-bangun-dan-tabung)
- [Percobaan 4: Konstruktor dan Multilevel Inheritance (ClassA, ClassB, ClassC)](#percobaan-4-konstruktor-dan-multilevel-inheritance-classa-classb-classc)
- [Percobaan 5: Konstruktor Berparameter dan Overriding (Komputer, Desktop, Laptop)](#percobaan-5-konstruktor-berparameter-dan-overriding-komputer-desktop-laptop)
- [Pertanyaan Tugas Mandiri (Tugas 1, Tugas 2, dan Tugas 4)](#pertanyaan-tugas-mandiri)

---

## Percobaan 1: Single Inheritance dengan extends (ClassA dan ClassB)

### 1. Mengapa kompilasi pada Langkah 5 gagal? Tuliskan pesan error pertama beserta file dan baris tempat error muncul.
**Jawaban:**
Kompilasi gagal karena `ClassB` belum dideklarasikan sebagai subclass dari `ClassA` (belum menggunakan kata kunci `extends ClassA`). Akibatnya, `ClassB` tidak mengenali dan tidak mewarisi variabel `x` dan `y` maupun method `getNilai()` yang didefinisikan pada `ClassA`.

* **Pesan Error Pertama:**
  ```text
  ClassB.java:11: error: cannot find symbol
          System.out.println("jumlah: " + (x + y + z));
                                           ^
    symbol:   variable x
    location: class ClassB
  ```
  *(Serta error berikutnya pada `symbol: variable y` di `ClassB.java:11` dan `hitung.x`, `hitung.y`, `hitung.getNilai()` di `MainPercobaan1.java`)*.

---

### 2. Baris kode mana yang diubah pada Langkah 6, dan apa artinya? Sebutkan class yang berperan sebagai superclass dan subclass.
**Jawaban:**
* **Baris yang diubah:** Baris deklarasi kelas pada `ClassB.java`:
  ```java
  public class ClassB extends ClassA {
  ```
* **Artinya:** Kata kunci `extends ClassA` menyatakan bahwa `ClassB` merupakan turunan (*subclass*) dari `ClassA`. Dengan demikian, `ClassB` mewarisi seluruh member (*state* dan *behavior*) yang berstatus non-private dari `ClassA`.
* **Peran Class:**
  - **Superclass (Induk):** `ClassA`
  - **Subclass (Anak):** `ClassB`

---

### 3. Setelah diperbaiki, sebutkan atribut dan method yang dapat dipakai oleh objek hitung. Kelompokkan mana yang dideklarasikan di ClassA dan mana yang dideklarasikan di ClassB.
**Jawaban:**
* **Dideklarasikan di `ClassA` (diwarisi oleh `hitung`):**
  - Atribut: `public int x`, `public int y`
  - Method: `public void getNilai()`
* **Dideklarasikan di `ClassB` (milik subclass sendiri):**
  - Atribut: `public int z`
  - Method: `public void getNilaiZ()`, `public void getJumlah()`

---

### 4. Pada MainPercobaan1, hitung.x = 20 ditulis pada objek ClassB, padahal atribut x tidak dideklarasikan di ClassB. Mengapa hal ini diperbolehkan?
**Jawaban:**
Hal ini diperbolehkan karena adanya konsep **Inheritance (Pewarisan)**. Melalui deklarasi `class ClassB extends ClassA`, `ClassB` secara otomatis mewarisi semua atribut berstatus `public` milik `ClassA`, termasuk variabel `x` dan `y`. Objek `hitung` yang diinstansiasi dari `ClassB` memiliki representasi fisik memori untuk variabel `x`, `y`, dan `z`.

---

### 5. Atribut x dan y pada ClassA dibuat public, sehingga dapat diubah langsung dari MainPercobaan1. Apa risiko dari desain seperti ini?
**Jawaban:**
Risiko dari desain tersebut adalah **pelanggaran prinsip Enkapsulasi (*Encapsulation*)**:
1. **Tidak ada validasi / kontrol data:** Siapa pun dapat mengubah nilai `x` dan `y` sembarangan dari luar class tanpa melalui aturan atau validasi tertentu.
2. **Ketergantungan tinggi (*Tight Coupling*):** Jika struktur tipe data atau nama atribut di `ClassA` diubah di masa mendatang, seluruh kode luar yang mengakses langsung variabel tersebut akan rusak/error (*breaking change*).

---

### 6. Coba tambahkan class ClassD lalu ubah deklarasi menjadi public class ClassB extends ClassA, ClassD. Apa yang terjadi? Apa yang dapat Anda simpulkan tentang jumlah superclass langsung pada Java?
**Jawaban:**
* **Yang terjadi:** Terjadi *compile-time error*:
  ```text
  ClassB.java:3: error: '{' expected
  public class ClassB extends ClassA, ClassD {
                                    ^
  ```
* **Kesimpulan:** Java **tidak mendukung *Multiple Inheritance* untuk class** (*Multiple Class Inheritance*). Di Java, sebuah class hanya boleh memiliki **tepat satu superclass langsung** (*Single Inheritance*). Jika ingin menerapkan banyak kontrak tipe, Java menggunakan mekanisme `implements` untuk *Interface*.

---

## Percobaan 2: Hak Akses pada Pewarisan (private dan protected)

### 1. Di file dan baris mana error pada Langkah 5 muncul, dan apa pesannya? Mengapa error tidak muncul di MainPercobaan2?
**Jawaban:**
* **Lokasi Error:** `ClassB.java` baris 15 pada method `getJumlah()`.
* **Pesan Error:**
  ```text
  ClassB.java:15: error: x has private access in ClassA
          System.out.println("jumlah: " + (x + y + z));
                                           ^
  ClassB.java:15: error: y has private access in ClassA
          System.out.println("jumlah: " + (x + y + z));
                                               ^
  ```
* **Mengapa tidak muncul di `MainPercobaan2`:** Karena `MainPercobaan2` hanya memanggil method-method yang berstatus `public` (`setX()`, `setY()`, `setZ()`, `getNilai()`, dll). Pemanggilan method `public` tersebut sepenuhnya sah. Error terjadi di dalam `ClassB` karena method `getJumlah()` mencoba membaca langsung variabel `x` dan `y` yang berstatus `private` milik `ClassA`.

---

### 2. Jelaskan penyebab error tersebut dengan merujuk pada tabel kontrol pengaksesan (Langkah 1).
**Jawaban:**
Berdasarkan tabel kontrol akses Java, member dengan access modifier **`private`** hanya dapat diakses oleh **class yang sama** tempat member tersebut dideklarasikan. Member `private` **tidak dapat diakses oleh subclass manapun**, meskipun berada dalam package yang sama. Karena variabel `x` dan `y` di `ClassA` bersifat `private`, `ClassB` tidak memiliki hak akses langsung terhadap kedua variabel tersebut.

---

### 3. Pada kode awal, MainPercobaan2 memanggil hitung.setX(20) dan tidak error, padahal x bersifat private. Mengapa pemanggilan ini diperbolehkan, dan di mana nilai x tersimpan?
**Jawaban:**
* **Alasan diperbolehkan:** Method `setX(int x)` dideklarasikan dengan access modifier `public` di `ClassA` dan diwarisi ke `ClassB`. Method `setX` berada dalam class yang sama dengan variabel `x` (yaitu `ClassA`), sehingga method tersebut berhak memanipulasi variabel private `x`.
* **Tempat nilai tersimpan:** Nilai `20` tersimpan di dalam memori heap pada instance objek `hitung` (bagian state internal instance yang dialokasikan untuk atribut `x` milik superclass `ClassA`).

---

### 4. Bandingkan Perbaikan A (protected) dan Perbaikan B (private + getter) dari sisi encapsulation. Mana yang Anda pilih untuk program sungguhan? Jelaskan alasannya.
**Jawaban:**
* **Perbandingan:**
  - **Perbaikan A (`protected`):** Memberi izin kepada subclass (dan class lain dalam satu package) untuk membaca/mengubah atribut secara langsung tanpa setter/getter. Enkapsulasinya lebih longgar.
  - **Perbaikan B (`private` + getter/setter):** Menjaga atribut tetap terisolasi di dalam class pemiliknya (*strong encapsulation*). Subclass maupun class luar hanya bisa mengakses lewat method perantara.
* **Pilihan untuk program sungguhan:** **Perbaikan B (`private` + getter/setter)**.
* **Alasan:** Karena Perbaikan B menerapkan prinsip enkapsulasi sejati (*data hiding*). Kita dapat menambahkan logika validasi pada setter, mencegah modifikasi ilegal, serta mengubah implementasi internal tanpa memengaruhi class turunan.

---

### 5. Andaikan ClassA dan ClassB berada di package yang berbeda. Berdasarkan tabel, apakah ClassB tetap dapat mengakses atribut protected milik ClassA? Bagaimana jika atributnya default (tanpa modifier)?
**Jawaban:**
* **Jika `protected`:** **Ya, `ClassB` tetap dapat mengakses atribut `protected` milik `ClassA`**, karena modifier `protected` mengizinkan akses oleh subclass meskipun berada di package yang berbeda.
* **Jika `default` (tanpa modifier / *package-private*):** **Tidak bisa**, karena access level `default` hanya dapat diakses oleh class-class yang berada dalam package yang sama. Jika beda package, subclass tidak dapat mengakses member berstatus `default`.

---

## Percobaan 3: Kata Kunci this dan super (Bangun dan Tabung)

### 1. Jelaskan fungsi super pada super.phi = phi; dan super.r = r; di method setSuperPhi() dan setSuperR() milik Tabung.
**Jawaban:**
Fungsi `super` adalah untuk secara eksplisit menunjuk dan mengakses variabel/atribut `phi` dan `r` yang didefinisikan pada **superclass** (`Bangun`), guna memastikan nilai parameter yang diterima dimasukkan ke variabel milik kelas induk, bukan variabel lokal maupun variabel milik subclass.

---

### 2. Jelaskan fungsi super dan this pada ekspresi super.phi * super.r * super.r * this.t di method volume().
**Jawaban:**
* `super.phi` dan `super.r`: Mengambil nilai atribut `phi` dan `r` yang berasal dari superclass (`Bangun`).
* `this.t`: Mengambil nilai atribut `t` (tinggi) yang dimiliki secara langsung oleh class itu sendiri (`Tabung`).

---

### 3. Mengapa Tabung tidak mendeklarasikan atribut phi dan r, tetapi tetap dapat mengaksesnya? Apa yang terjadi bila pada Bangun keduanya diubah menjadi private?
**Jawaban:**
* **Alasan dapat mengakses:** Karena `Tabung` merupakan turunan (`extends Bangun`) dan atribut `phi` serta `r` pada `Bangun` dideklarasikan dengan modifier `protected`.
* **Jika diubah menjadi `private`:** Class `Tabung` akan mengalami **compile error** saat mencoba mengakses `super.phi` atau `super.r`, karena member `private` tidak dapat diakses oleh subclass.

---

### 4. Pada Eksperimen 1, apakah output berubah ketika super.phi diganti this.phi? Jelaskan mengapa.
**Jawaban:**
* **Hasil:** Output **tidak berubah** (tetap `942.0`).
* **Penjelasan:** Karena pada `Tabung` tidak ada pendeklarasian ulang variabel bernama `phi`. Ketika `this.phi` dipanggil, Java akan mencari variabel `phi` di class `Tabung`, dan karena tidak ditemukan, Java otomatis merujuk ke variabel `phi` yang diwarisi dari superclass (`Bangun`). Jadi `this.phi` dan `super.phi` merujuk ke variabel fisik yang sama.

---

### 5. Pada Eksperimen 2, mengapa r, this.r, dan super.r menghasilkan nilai yang berbeda? Pada kondisi apa awalan super. menjadi wajib dipakai?
**Jawaban:**
* **Penyebab perbedaan nilai:** Terjadi peristiwa **Variable Shadowing / Variable Hiding**. Class `Tabung` mendeklarasikan variabelnya sendiri bernama `protected int r = 5;`.
  - `r` dan `this.r` merujuk ke variabel `r` milik `Tabung` yang bernilai `5`.
  - `super.r` merujuk ke variabel `r` milik superclass `Bangun` yang telah diisi nilai `10`.
* **Kondisi wajib menggunakan `super.`:** Awalan `super.` **wajib dipakai** ketika subclass mendefinisikan atribut atau method dengan nama yang sama persis seperti atribut/method superclass (*shadowing/overriding*), dan subclass perlu secara spesifik mengakses versi milik superclass.

---

## Percobaan 4: Konstruktor dan Multilevel Inheritance (ClassA, ClassB, ClassC)

### 1. Sebutkan class yang berperan sebagai superclass dan subclass pada percobaan ini beserta alasannya. Mengapa ClassB disebut berperan ganda?
**Jawaban:**
* **Hierarki Class:**
  - `ClassA`: Superclass murni bagi `ClassB`.
  - `ClassB`: Subclass dari `ClassA`, sekaligus Superclass bagi `ClassC`.
  - `ClassC`: Subclass dari `ClassB`.
* **Mengapa `ClassB` berperan ganda:** Karena `ClassB` menerapkan **Multilevel Inheritance**; ia bertindak sebagai *subclass / child class* (turunan dari `ClassA`) dan pada saat yang sama bertindak sebagai *superclass / parent class* bagi `ClassC`.

---

### 2. Program hanya membuat satu objek (new ClassC()), tetapi tiga baris tercetak. Jelaskan mengapa konstruktor ClassA dan ClassB ikut dijalankan.
**Jawaban:**
Dalam Java, saat sebuah objek subclass dibuat, Java menerapkan mekanisme **Constructor Chaining**. Sebelum konstruktor subclass mengeksekusi tubuh kodenya, konstruktor superclass langsungnya harus dijalankan terlebih dahulu untuk memastikan seluruh atribut dan state dasar yang diwarisi telah terinisialisasi secara sempurna. Rantai ini terus berlanjut ke atas hingga mencapai `java.lang.Object`.

---

### 3. Pada Modifikasi 1, mengapa output tidak berbeda dari sebelumnya meskipun super(); ditambahkan secara eksplisit?
**Jawaban:**
Karena jika kita tidak menuliskan `super()` secara eksplisit pada baris pertama konstruktor, compiler Java secara **otomatis menyisipkan panggilan `super()` (konstruktor default tanpa argumen)** di baris paling awal. Sehingga penulisan `super()` eksplisit menghasilkan alur eksekusi yang sama persis dengan panggilan implisit oleh compiler.

---

### 4. Pada Modifikasi 2 terjadi error. Aturan apa yang dilanggar, dan mengapa Java menetapkan aturan tersebut?
**Jawaban:**
* **Aturan yang dilanggar:** Aturan bahwa pemanggilan konstruktor superclass (`super(...)`) atau konstruktor lain (`this(...)`) **harus menjadi pernyataan pertama (*first statement*)** di dalam konstruktor.
* **Pesan Error:** `error: call to super must be first statement in constructor`.
* **Alasan Java menetapkan aturan ini:** Untuk menjamin keamanan inisialisasi objek. Superclass bertanggung jawab atas state dasar objek. Jika subclass diizinkan menjalankan kode sebelum superclass selesai diinisialisasi, ada risiko kode subclass mengakses variabel superclass yang belum siap (*uninitialized state*).

---

### 5. Tuliskan urutan proses (bernomor) yang terjadi ketika new ClassC() dieksekusi, dimulai dari pemanggilan konstruktor ClassC hingga seluruh output tercetak.
**Jawaban:**
1. Eksekusi `new ClassC()` memanggil konstruktor `ClassC()`.
2. Di baris pertama `ClassC()`, terpanggil `super()` yang merujuk ke konstruktor `ClassB()`.
3. Di baris pertama `ClassB()`, secara implisit terpanggil `super()` yang merujuk ke konstruktor `ClassA()`.
4. Di baris pertama `ClassA()`, terpanggil konstruktor `Object()`.
5. Konstruktor `Object()` selesai.
6. Tubuh konstruktor `ClassA()` dieksekusi $\rightarrow$ mencetak `"konstruktor A dijalankan"`.
7. Tubuh konstruktor `ClassB()` dieksekusi $\rightarrow$ mencetak `"konstruktor B dijalankan"`.
8. Tubuh konstruktor `ClassC()` dieksekusi $\rightarrow$ mencetak `"konstruktor C dijalankan"`.
9. Pembuatan objek `ClassC` selesai sepenuhnya.

---

## Percobaan 5: Konstruktor Berparameter dan Overriding (Komputer, Desktop, Laptop)

### 1. Jelaskan fungsi super(merk, memory, cpu) pada konstruktor Desktop. Atribut apa saja yang diisi oleh baris tersebut, dan atribut apa yang diisi oleh baris berikutnya?
**Jawaban:**
* **Fungsi `super(merk, memory, cpu)`:** Memanggil konstruktor berparameter milik superclass (`Komputer`) untuk menginisialisasi atribut yang diwarisi dari `Komputer`.
* **Atribut yang diisi oleh baris tersebut:** `merk`, `kapasitasMemory`, dan `kecepatanCPU`.
* **Atribut yang diisi oleh baris berikutnya (`this.printer = printer;`):** Atribut khusus milik subclass `Desktop`, yaitu `printer`.

---

### 2. Pada Eksperimen 1, mengapa error muncul di sini, padahal pada Percobaan 4 super() juga tidak ditulis tetapi program tetap berjalan?
**Jawaban:**
* Pada **Percobaan 4**, superclass (`ClassA` & `ClassB`) memiliki konstruktor default tanpa parameter (atau default constructor yang otomatis dibuatkan compiler), sehingga compiler dapat menyisipkan `super()` tanpa argumen secara otomatis.
* Pada **Percobaan 5**, class `Komputer` secara eksplisit mendefinisikan konstruktor dengan parameter `(String, int, int)` dan **tidak memiliki konstruktor tanpa parameter**. Jika `super(...)` dihapus, compiler akan mencoba menyisipkan `super()` tanpa argumen, yang berujung pada error karena konstruktor tanpa argumen tersebut tidak ada di class `Komputer`.

---

### 3. Method showInfo() ditulis di Komputer sekaligus di Desktop. Apa istilah untuk kondisi ini? Apa yang tercetak bila baris super.showInfo(); pada Desktop dihapus?
**Jawaban:**
* **Istilah:** **Method Overriding** (penimpaan method superclass oleh subclass).
* **Bila `super.showInfo();` dihapus:** Output informasi `Merk`, `Kapasitas Memory`, dan `Kecepatan CPU` **tidak akan tercetak**. Yang tercetak dari pemanggilan `desk.showInfo()` hanyalah baris informasi khusus printer:
  ```text
  Printer : Canon
  ```

---

### 4. Pada Eksperimen 2, jelaskan perbedaan hasil kompilasi dengan dan tanpa @Override. Apa manfaat menuliskan @Override?
**Jawaban:**
* **Dengan `@Override`:** Saat nama method salah ketik (misal `showinfo()` dengan huruf kecil), compiler langsung memberikan pesan error: `method does not override or implement a method from a supertype`, sehingga bug langsung terdeteksi saat kompilasi (*compile-time safety*).
* **Tanpa `@Override`:** Kompilasi tetap berhasil lolos tanpa error, namun Java menganggap `showinfo()` sebagai method baru biasa, bukan penimpa dari `showInfo()`. Akibatnya, saat `desk.showInfo()` dipanggil, method yang berjalan adalah versi superclass `Komputer`, dan baris printer tidak tercetak (*silent bug / runtime logical error*).
* **Manfaat `@Override`:** Memberi petunjuk kepada compiler untuk memverifikasi apakah method benar-benar menimpa method yang valid di superclass, mencegah kesalahan pengetikan nama/parameter, dan meningkatkan keterbacaan kode (*code clarity*).

---

### 5. Tantangan: Buat class Workstation sebagai turunan Desktop dengan atribut gpu (String). Class ini harus menimpa showInfo() sehingga menampilkan seluruh informasi Desktop ditambah baris GPU. Ketika new Workstation(...) dibuat, konstruktor class apa saja yang terpanggil, dan dalam urutan apa?
**Jawaban:**
* **Implementasi Kode Class `Workstation`:**
  ```java
  package id.ac.polinema.inheritance.percobaan5;

  public class Workstation extends Desktop {
      protected String gpu;

      public Workstation(String merk, int memory, int cpu, String printer, String gpu) {
          super(merk, memory, cpu, printer);
          this.gpu = gpu;
      }

      @Override
      public void showInfo() {
          super.showInfo();
          System.out.println("GPU                  : " + gpu);
      }
  }
  ```
* **Urutan Konstruktor yang Terpanggil:**
  1. Konstruktor `Komputer(String, int, int)`
  2. Konstruktor `Desktop(String, int, int, String)`
  3. Konstruktor `Workstation(String, int, int, String, String)`

---

## Pertanyaan Tugas Mandiri

### Tugas 1: Pertanyaan Analisis (Halaman 19)
#### (a) Array Pegawai[] dapat menampung objek Dosen. Mengapa hal itu diperbolehkan?
**Jawaban:**
Hal itu diperbolehkan karena adanya relasi **Inheritance (Pewarisan / *is-a relationship*)** dan konsep **Polimorfisme (*Upcasting*)**. Karena `Dosen extends Pegawai`, maka setiap objek `Dosen` secara hakiki adalah juga sebuah `Pegawai` (*Dosen is a Pegawai*). Dengan demikian, variabel referensi atau array bertipe superclass (`Pegawai[]`) dapat menampung objek dari subclass-nya (`Dosen`).

#### (b) Ketika printSemuaGaji() memanggil getGaji() pada objek Dosen, versi method milik class mana yang dijalankan?
**Jawaban:**
Versi method milik class **`Dosen`** yang dijalankan. Hal ini terjadi karena mekanisme **Dynamic Method Dispatch** (pemberlakuan method *runtime polymorphism* pada method yang dioverride). Meskipun tipe array adalah `Pegawai[]`, pada saat runtime Java memeriksa tipe objek aslinya, yaitu `Dosen`, dan mengeksekusi implementasi `getGaji()` milik `Dosen`.

---

### Tugas 2: Uji Tambahan (Halaman 20)
#### Uji tambahan: panggil tv.pindahChannel(150) lalu cetak channel aktif. Tuliskan hasilnya dan jelaskan mengapa channelAktif tidak dapat diubah langsung dari MainTugas2.
**Jawaban:**
* **Hasil Output:** Channel aktif tetap **`20`** (tidak berubah menjadi 150).
* **Penjelasan:**
  - Method `pindahChannel(int channel)` memiliki validasi logika: `if (channel >= 1 && channel <= jumlahChannel)`. Karena nilai `150` melebihi batas `jumlahChannel` (`100`), maka perintah perubahan diabaikan.
  - Variabel `channelAktif` dideklarasikan dengan access modifier **`private`** pada class `Televisi`. Oleh sebab itu, class luar seperti `MainTugas2` tidak memiliki akses langsung untuk mengubah nilai variabel tersebut (`tv.channelAktif = 150;` akan menyebabkan compile error) dan dipaksa mematuhi aturan validasi melalui method setter `pindahChannel()`.

---

### Tugas 4: Jawab Singkat (Halaman 21)

#### 1. Jelaskan dengan bahasa Anda sendiri perbedaan hubungan is-a (inheritance) dan has-a (aggregation/composition), lalu beri satu contoh masing-masing dari jobsheet ini.
**Jawaban:**
* **Hubungan `is-a` (Inheritance):** Hubungan pewarisan di mana sebuah subclass merupakan bentuk spesifik atau turunan dari superclass (*generalisasi ke spesialisasi*).
  - *Contoh pada jobsheet:* `Dosen` **is-a** `Pegawai` (Class `Dosen` mewarisi Class `Pegawai`), atau `Laptop` **is-a** `Komputer`.
* **Hubungan `has-a` (Agregasi / Komposisi):** Hubungan kepemilikan di mana suatu class memiliki atau menggunakan objek dari class lain sebagai salah satu atribut atau anggotanya.
  - *Contoh pada jobsheet:* `DaftarGaji` **has-a** `Pegawai` (Class `DaftarGaji` memiliki kumpulan/array objek `Pegawai[]`).

---

#### 2. Ringkas aturan pewarisan untuk tiga hal berikut dalam 3–5 kalimat: member private, member protected, dan konstruktor.
**Jawaban:**
Member `private` pada superclass tidak diwariskan dan tidak dapat diakses langsung oleh subclass manapun, sehingga hanya dapat diakses melalui perantara getter/setter public. Sebaliknya, member `protected` diwariskan dan dapat diakses langsung oleh seluruh subclass meskipun berada pada package yang berbeda. Sementara itu, konstruktor tidak pernah diwariskan ke subclass, melainkan harus dipanggil secara berantai (*constructor chaining*) menggunakan kata kunci `super(...)` yang wajib diletakkan pada baris pertama di dalam konstruktor subclass.
