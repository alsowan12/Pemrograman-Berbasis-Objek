# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK
## JOBSHEET 6: INHERITANCE (PEWARISAN)

---

**Mata Kuliah:** Pemrograman Berbasis Objek  
**Topik:** Pewarisan (*Inheritance*), Hak Akses, Keyword `super` & `this`, Urutan Konstruktor, dan *Method Overriding*  

---

## DAFTAR ISI
1. [Tujuan Praktikum](#i-tujuan-praktikum)
2. [Dasar Teori](#ii-dasar-teori)
3. [Hasil dan Analisis Percobaan](#iii-hasil-dan-analisis-percobaan)
   - [Percobaan 1: Pengenalan Pewarisan](#1-percobaan-1-pengenalan-pewarisan)
   - [Percobaan 2: Hak Akses (Access Modifiers) & Getter-Setter](#2-percobaan-2-hak-akses-access-modifiers--getter-setter)
   - [Percobaan 3: Penggunaan Keyword `super` dan `this`](#3-percobaan-3-penggunaan-keyword-super-dan-this)
   - [Percobaan 4: Urutan Eksekusi Konstruktor (*Constructor Chaining*)](#4-percobaan-4-urutan-eksekusi-konstruktor-constructor-chaining)
   - [Percobaan 5: Pewarisan Hirarki & Konstruktor Berparameter](#5-percobaan-5-pewarisan-hirarki--konstruktor-berparameter)
4. [Hasil dan Analisis Tugas](#iv-hasil-dan-analisis-tugas)
   - [Tugas 1: Sistem Penggajian Pegawai dan Dosen](#1-tugas-1-sistem-penggajian-pegawai-dan-dosen)
   - [Tugas 2: Sistem Perangkat Elektronik Televisi dan Televisi Modern](#2-tugas-2-sistem-perangkat-elektronik-televisi-dan-televisi-modern)
   - [Tugas 3: Game Pertarungan Karakter RPG](#3-tugas-3-game-pertarungan-karakter-rpg)
5. [Kesimpulan](#v-kesimpulan)

---

## I. TUJUAN PRAKTIKUM
1. Memahami konsep dasar **Inheritance (Pewarisan)** dalam Pemrograman Berbasis Objek (*Object-Oriented Programming*).
2. Mampu mendeklarasikan class turunan (*subclass/child class*) dari class induk (*superclass/parent class*) menggunakan keyword `extends`.
3. Memahami penggunaan hak akses (*access modifier*) seperti `public`, `protected`, dan `private` pada hierarki pewarisan.
4. Mampu menggunakan keyword `super` untuk memanggil konstruktor, atribut, dan method milik superclass.
5. Memahami urutan pemanggilan konstruktor dalam rantai pewarisan (*constructor chaining*).
6. Mampu menerapkan **Method Overriding** untuk menyesuaikan atau memperluas fungsionalitas method di subclass.

---

## II. DASAR TEORI

### 1. Konsep Pewarisan (*Inheritance*)
Pewarisan adalah salah satu pilar utama OOP yang memungkinkan suatu class (*subclass*) mewarisi atribut dan method dari class lain (*superclass*). Tujuan utama dari pewarisan adalah:
- **Code Reusability**: Menghindari duplikasi kode dengan memanfaatkan properti dan perilaku yang sudah didefinisikan pada superclass.
- **Extensibility**: Mempermudah pengembangan class baru dengan menambahkan atribut dan method spesifik tanpa merusak kode lama.

Deklarasi pewarisan di Java menggunakan kata kunci `extends`:
```java
public class SubClass extends SuperClass {
    // Definisi tambahan atribut dan method
}
```

### 2. Hak Akses (*Access Modifiers*)
| Modifier | Class yang Sama | Package yang Sama | Subclass (Beda Package) | Luar Package |
| :--- | :---: | :---: | :---: | :---: |
| `public` | Ya | Ya | Ya | Ya |
| `protected` | Ya | Ya | Ya | Tidak |
| *default* (tanpa modifier) | Ya | Ya | Tidak | Tidak |
| `private` | Ya | Tidak | Tidak | Tidak |

### 3. Keyword `super` dan `this`
- **`super`**: Digunakan oleh subclass untuk merujuk langsung ke anggota milik superclass (misal: `super.atribut`, `super.method()`, atau memanggil konstruktor induk `super(args)`).
- **`this`**: Merujuk pada instance class itu sendiri (misal: membedakan antara parameter dan atribut instance).

### 4. Method Overriding
Method Overriding adalah mekanisme di mana subclass menulis ulang implementasi method yang telah didefinisikan oleh superclass dengan nama method, tipe return, dan parameter yang identik.

---

## III. HASIL DAN ANALISIS PERCOBAAN

### 1. Percobaan 1: Pengenalan Pewarisan

#### Kode Program
* **`ClassA.java`**:
```java
package jobsheet6;

public class ClassA {
    public int x;
    public int y;

    public void getNilai() {
        System.out.println("nilai x :" + x);
        System.out.println("nilai y :" + y);
    }
}
```

* **`ClassB.java`**:
```java
package jobsheet6;

public class ClassB extends ClassA{
    public int z;

    public void getNilaiz() {
        System.out.println("nilai z :" + z);
    }

    public void getJumlah() {
        System.out.println("jumlah :" + (x + y + z));
    }
}
```

* **`Mainpercobaan.java`**:
```java
package jobsheet6;

public class Mainpercobaan {
    public static void main(String[] args) {
        ClassB hitung = new ClassB();
        hitung.x = 20;
        hitung.y = 30;
        hitung.z = 5;
        hitung.getNilai();
        hitung.getNilaiz();
        hitung.getJumlah();
    }
}
```

#### Output Program
```text
nilai x :20
nilai y :30
nilai z :5
jumlah :55
```

#### Analisis
Objek `hitung` yang merupakan instansiasi dari `ClassB` dapat langsung mengakses variabel `x` dan `y` serta method `getNilai()` milik `ClassA` karena hubungan `extends` dan access modifier bertipe `public`. Subclass memperluas kapabilitas dengan memiliki variabel `z` dan method penjumlahan `getJumlah()`.

---

### 2. Percobaan 2: Hak Akses (Access Modifiers) & Getter-Setter

#### Kode Program
* **`ClassAPercobaan2.java`**:
```java
package jobsheet6;

public class ClassAPercobaan2 {
    protected int x;
    protected int y;

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public void getNilai(){
        System.out.println("Nilai x :" + x );
        System.out.println("Nilai y :" + y );
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
```

* **`ClassBPercobaan2.java`**:
```java
package jobsheet6;

public class ClassBPercobaan2 extends ClassAPercobaan2 {
    private int z;

    public void setZ(int z ) {
        this.z = z;
    }
    public void getNilaiZ(){
        System.out.println("Nilai z :" + z);
    }
    public void getJumlah(){
        System.out.println("Jumlah :" + (getX() + getY() + z));
    }
}
```

* **`Mainpercobaan2.java`**:
```java
package jobsheet6;

public class Mainpercobaan2 {
    public static void main (String [] args){
        ClassBPercobaan2 hitung = new ClassBPercobaan2();
        hitung.setX(20);
        hitung.setY(30);
        hitung.setZ(5);
        hitung.getNilai();
        hitung.getNilaiZ();
        hitung.getJumlah();
    }
}
```

#### Output Program
```text
Nilai x :20
Nilai y :30
Nilai z :5
Jumlah :55
```

#### Analisis
Pada percobaan ini diterapkan prinsip enkapsulasi. Variabel `x` dan `y` pada superclass berstatus `protected`, sedangkan `z` pada subclass berstatus `private`. Nilai atribut diakses dan dimanipulasi secara aman melalui metode *getter* dan *setter*. Pada method `getJumlah()`, nilai `x` dan `y` diperoleh melalui pemanggilan method `getX()` dan `getY()`.

---

### 3. Percobaan 3: Penggunaan Keyword `super` dan `this`

#### Kode Program
* **`Bangun.java`**:
```java
package jobsheet6;

public class Bangun {
    protected double phi;
    protected double r;
}
```

* **`Tabung.java`**:
```java
package jobsheet6;

public class Tabung extends Bangun {
    protected int t;
    protected int r = 5;

    public void setSuperPhi(double phi){
        this.phi = phi;
    }
    public void setSuperR(int r){
        super.r = r;
    }
    public void setT(int t){
        this.t = t;
    }
    public void volume(){
        System.out.println("Volume Tabung Adalah :" + (this.phi * super.r * super.r * this.t));
    }
    public void cekR(){
        System.out.println("r      = " + r);
        System.out.println("this.r = " + this.r);
        System.out.println("super.r = " + super.r);
    }
}
```

* **`MainPercobaan3.java`**:
```java
package jobsheet6;

public class MainPercobaan3 {
    public static void main(String[] args) {
        Tabung tabung = new Tabung();
        tabung.setSuperPhi(3.14);
        tabung.setSuperR(10);
        tabung.setT(3);
        tabung.volume();
        tabung.cekR();
    }
}
```

#### Output Program
```text
Volume Tabung Adalah :942.0
r      = 5
this.r = 5
super.r = 10.0
```

#### Analisis
Terjadi peristiwa *variable hiding* / *shadowing* di mana atribut `r` dideklarasikan ulang di subclass `Tabung` dengan nilai default `5`, menutupi atribut `r` pada `Bangun`. Untuk merujuk ke atribut milik superclass digunakan `super.r` (bernilai `10.0`), sedangkan `this.r` atau `r` merujuk ke variabel lokal subclass `Tabung` (bernilai `5`). Perhitungan volume tabung: $3.14 \times 10 \times 10 \times 3 = 942.0$.

---

### 4. Percobaan 4: Urutan Eksekusi Konstruktor (*Constructor Chaining*)

#### Kode Program
* **`ClassAPercobaan4.java`**:
```java
package jobsheet6;

public class ClassAPercobaan4 {
    int x, y, z;
    ClassAPercobaan4() {
        System.out.println("Konstruktor Class A Dijalankan");
    }
}
```

* **`ClassBPercobaan4.java`**:
```java
package jobsheet6;

public class ClassBPercobaan4 extends ClassAPercobaan4 {
    ClassBPercobaan4() {
        System.out.println("Konstruktor Class B Dijalankan");
    }
}
```

* **`ClassCPercobaan4.java`**:
```java
package jobsheet6;

public class ClassCPercobaan4 extends ClassBPercobaan4 {
    ClassCPercobaan4 () {
        System.out.println("Konstruktor Class C Dijalankan");
        super();
    }
}
```

* **`MainPercobaan4.java`**:
```java
package jobsheet6;

public class MainPercobaan4 {
    public static void main(String[] args) {
        ClassCPercobaan4 test = new ClassCPercobaan4();
    }
}
```

#### Output Program
```text
Konstruktor Class C Dijalankan
Konstruktor Class A Dijalankan
Konstruktor Class B Dijalankan
```

#### Analisis
Percobaan ini mendemonstrasikan proses inisialisasi objek bertingkat (*multilevel inheritance*). Ketika objek `ClassCPercobaan4` diinstansiasi, konstruktor superclass `ClassAPercobaan4` dan `ClassBPercobaan4` dipanggil secara otomatis untuk memastikan bagian dasar objek induk terinisialisasi sebelum subclass melengkapi inisialisasinya.

---

### 5. Percobaan 5: Pewarisan Hirarki & Konstruktor Berparameter

#### Kode Program
* **`KomputerPercobaan5.java`**:
```java
package jobsheet6;

public class KomputerPercobaan5 {
    protected String merk;
    protected int kapasitasMemory;
    protected int kecepatanCPU;

    public KomputerPercobaan5(String merk, int memory, int cpu) {
        this.merk = merk;
        this.kapasitasMemory = memory;
        this.kecepatanCPU = cpu;
    }
    public void showInfo(){
        System.out.println("Merk                 : " + merk);
        System.out.println("Kapasitas Memory     : " + kapasitasMemory + " GB");
        System.out.println("Kecepatan CPU        : " + kecepatanCPU + " MHz");
    }
    public void nyalakanKomputer(){
        System.out.println("Komputer merk "+merk+" dinyalakan");
    }
}
```

* **`LaptopPercobaan5.java`**:
```java
package jobsheet6;

public class LaptopPercobaan5 extends KomputerPercobaan5 {
    protected int resolusiLayar;

    public LaptopPercobaan5(String merk, int memory, int cpu, int resolusi){
        super(merk, memory, cpu);
        this.resolusiLayar = resolusi;
    }

    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Resolusi Layar       : " + resolusiLayar + " p");
    }
}
```

* **`DekstopPercobaan5.java`**:
```java
package jobsheet6;

public class DekstopPercobaan5 extends KomputerPercobaan5 {
    protected String printer;

    public DekstopPercobaan5(String merk, int memory, int cpu, String printer){
        super(merk, memory, cpu);
        this.printer = printer;
    }
    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Printer              : " + printer);
    }
}
```

* **`MainPercobaan5.java`**:
```java
package jobsheet6;

public class MainPercobaan5 {
    public static void main(String[] args){
        DekstopPercobaan5 desk = new DekstopPercobaan5("Dell", 2048, 3500, "Canon");
        LaptopPercobaan5 lap = new LaptopPercobaan5("Asus", 4096, 2500, 720);

        desk.showInfo();
        System.out.println();
        lap.showInfo();
        System.out.println();
        desk.nyalakanKomputer();
    }
}
```

#### Output Program
```text
Merk                 : Dell
Kapasitas Memory     : 2048 GB
Kecepatan CPU        : 3500 MHz
Printer              : Canon

Merk                 : Asus
Kapasitas Memory     : 4096 GB
Kecepatan CPU        : 2500 MHz
Resolusi Layar       : 720 p

Komputer merk Dell dinyalakan
```

#### Analisis
`LaptopPercobaan5` dan `DekstopPercobaan5` mewarisi atribut umum dari `KomputerPercobaan5`. Konstruktor subclass memanfaatkan `super(merk, memory, cpu)` untuk meneruskan parameter ke konstruktor superclass. Pada method `showInfo()`, dilakukan *method overriding* dengan memanggil `super.showInfo()` terlebih dahulu untuk mencetak data umum komputer, kemudian menambahkan pencetakan data khusus milik subclass.

---

## IV. HASIL DAN ANALISIS TUGAS

### 1. Tugas 1: Sistem Penggajian Pegawai dan Dosen

#### Deskripsi Soal
Membuat sistem penggajian dengan:
- Class `Pegawai` (atribut `nip`, `nama`, `alamat`, method `getNama()`, dan `getGaji()` senilai Rp 1.500.000).
- Class `Dosen` (turunan `Pegawai`, atribut `jumlahSKS`, `TARIF_SKS` senilai Rp 100.000, serta override `getGaji()`).
- Class `DaftarGaji` untuk menampung array pegawai dan mencetak seluruh data gaji.

#### Kode Program
* **`Pegawai.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Pegawai {
    protected String nip;
    protected String nama;
    protected String alamat;

    public Pegawai(String nip, String nama, String alamat){
        this.nip = nip;
        this.nama = nama;
        this.alamat = alamat;
    }
    public String getNama(){
        return nama;
    }
    public int getGaji(){
        return 1500000;
    }
}
```

* **`Dosen.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Dosen extends Pegawai {
    protected int jumlahSKS;
    protected static final int TARIF_SKS = 100000;

    public Dosen(String nip, String nama, String alamat){
        super(nip, nama, alamat);
    }
    public void setSKS(int jumlahSKS){
        this.jumlahSKS = jumlahSKS;
    }
    @Override 
    public int getGaji(){
        return super.getGaji() + (jumlahSKS * TARIF_SKS);
    }
}
```

* **`DaftarGaji.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class DaftarGaji {
    private Pegawai[] listPegawai;
    private int jumlah;

    public DaftarGaji(int kapasitas){
        listPegawai = new Pegawai[kapasitas];
        jumlah = 0;
    }
    public void addPegawai(Pegawai p){
        if (jumlah < listPegawai.length){
            listPegawai[jumlah] = p;
            jumlah++;
        }
    }
    public void printSemuaGaji(){
        for (int i = 0; i < jumlah; i++){
            System.out.println(listPegawai[i].getNama() + ":" + listPegawai[i].getGaji());
        }
    }
}
```

* **`MainTugas1.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class MainTugas1 {
    public static void main (String[] args){
        DaftarGaji daftarGaji = new DaftarGaji(2);

        Pegawai p1 = new Pegawai("P001", "Budi", "Malang");
        Dosen d1 = new Dosen("D001", "Siti", "Banyuwangi");
        d1.setSKS(12);

        daftarGaji.addPegawai(p1);
        daftarGaji.addPegawai(d1);

        daftarGaji.printSemuaGaji();
    }
}
```

#### Output Program
```text
Budi:1500000
Siti:2700000
```

#### Analisis
- Objek `Pegawai` (Budi) menghasilkan gaji standar Rp 1.500.000.
- Objek `Dosen` (Siti) memiliki 12 SKS, sehingga gajinya dihitung:
  $$\text{Gaji Siti} = 1.500.000 + (12 \times 100.000) = 2.700.000$$
- Class `DaftarGaji` menggunakan array bertipe `Pegawai[]`, sehingga mampu menampung objek `Dosen` secara polimorfis (*upcasting*).

---

### 2. Tugas 2: Sistem Perangkat Elektronik Televisi dan Televisi Modern

#### Deskripsi Soal
- Class `Televisi` memiliki fungsi dasar pemindahan channel dan validasi batas channel.
- Class `TelevisiModern` mewarisi `Televisi`, menambahkan fungsi pemilihan input/mode tampilan (`gantiModusTampilan`) serta pemutar media DVD (`masukkanDVD` dan `mainkanDVD`).

#### Kode Program
* **`Televisi.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Televisi {
    private String merk;
    private int jumlahChannel;
    private int channelAktif;

    public Televisi(String merk, int jumlahChannel) {
        this.merk = merk;
        this.jumlahChannel = jumlahChannel;
        this.channelAktif = 1; // Channel aktif awal adalah 1
    }

    public void pindahChannel(int channel) {
        if (channel >= 1 && channel <= jumlahChannel) {
            this.channelAktif = channel;
        }
    }

    public int getChannelAktif() {
        return channelAktif;
    }
}
```

* **`TelevisiModern.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class TelevisiModern extends Televisi{
    private String modeTampilan;
    private String dvd;

    public TelevisiModern(String merk, int jumlahChannel) {
        super(merk, jumlahChannel);
        this.dvd = "Kosong";
    }

    public void gantiModusTampilan(String mode) {
        this.modeTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD() {
        System.out.println("Sedang memainkan DVD" + dvd);
    }
}
```

* **`MainTelevisi.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class MainTelevisi {
    public static void main(String[] args) { 
        TelevisiModern tv = new TelevisiModern("Samsung", 100); 

        System.out.println("Channel aktif: " + tv.getChannelAktif()); 
        tv.pindahChannel(20); 
        System.out.println("Channel aktif sekarang: " + tv.getChannelAktif()); 
        tv.gantiModusTampilan("HDMI"); 
        tv.mainkanDVD(); 
        tv.masukkanDVD("The Matrix"); 
        tv.mainkanDVD(); 
    }
}
```

#### Output Program
```text
Channel aktif: 1
Channel aktif sekarang: 20
Sedang memainkan DVDKosong
Sedang memainkan DVDThe Matrix
```

#### Analisis
`TelevisiModern` memanfaatkan fungsionalitas channel dari `Televisi` induk tanpa perlu mendefinisikan ulang variabel `merk`, `jumlahChannel`, atau method `pindahChannel()`. Fitur modern ditambahkan secara modular pada subclass.

---

### 3. Tugas 3: Game Pertarungan Karakter RPG

#### Deskripsi Soal
Membuat sistem karakter game RPG berbasis inheritance:
- **`Character`** (Base Class): Atribut `nama`, `level`, `health`, method `attack()` dan `showStatus()`.
- **`Human`** (Subclass): Atribut `strength`, method `specialAttack()`.
- **`Angel`** (Subclass): Atribut `potion`, method `cure()` (mengisi darah target hingga 100).
- **`Wizard`** (Subclass): Atribut `spell`, method `magic()` (damage 50 ke target).

#### Kode Program
* **`Character.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Character {
    protected String nama;
    protected int level;
    protected int health;

    public Character(String nama, int level, int health){
        this.nama = nama;
        this.level = level;
        this.health = health;
    }
    public void attack(Character target){
        target.health -= 10;
    }
    public void showStatus(){
        System.out.println(nama + "Level" + level + "1 HP" + health);
    }
}
```

* **`Human.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Human extends Character{
    private int strength;

    public Human(String nama, int level, int health, int strength) {
        super(nama, level, health);
        this.strength = strength;
    }
    public void specialAttack(Character target){
        target.health -= (10 + strength);
    }
}
```

* **`Angel.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Angel extends Character{
    private int potion;

    public Angel(String nama, int level, int health, int potion){
        super(nama, level, health);
        this.potion = potion;
    }
    public void cure(Character target){
        if (potion > 0){
            target.health = 100;
            potion--;
        }
    }
}
```

* **`Wizard.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class Wizard extends Character{
    private int spell;
    
    public Wizard(String nama, int level, int health, int spell){
        super(nama, level, health);
        this.spell = spell;
    }
    public void magic(Character target){
        if (spell > 0){
            target.health -= 50;
            spell--;
        }
    }
}
```

* **`MainTugas3.java`**:
```java
package jobsheet6.TugasJobsheet6;

public class MainTugas3 { 
    public static void main(String[] args) { 
        Angel esther = new Angel("Esther", 10, 100, 5); 
        Human jackal = new Human("Jackal", 13, 100, 7); 
        Wizard quistis = new Wizard("Quistis", 20, 100, 3); 

        System.out.println("Begin game..."); 
        esther.showStatus(); 
        jackal.showStatus(); 
        quistis.showStatus(); 

        System.out.println("Jackal special attack to quistis, " + "quistis cast magic to jackal,"); 
        System.out.println("esther cure jackal, quistis attack esther..."); 
        jackal.specialAttack(quistis); 
        quistis.magic(jackal); 
        esther.cure(jackal); 
        quistis.attack(esther); 

        esther.showStatus(); 
        jackal.showStatus(); 
        quistis.showStatus(); 
    } 
}
```

#### Output Program
```text
Begin game...
EstherLevel101 HP100
JackalLevel131 HP100
QuistisLevel201 HP100
Jackal special attack to quistis, quistis cast magic to jackal,
esther cure jackal, quistis attack esther...
EstherLevel101 HP90
JackalLevel131 HP100
QuistisLevel201 HP83
```

#### Analisis
1. Awal permainan seluruh karakter memiliki HP 100.
2. `jackal.specialAttack(quistis)`: Damage = $10 + 7 = 17$, HP Quistis menjadi $100 - 17 = 83$.
3. `quistis.magic(jackal)`: Damage = $50$, HP Jackal berkurang menjadi $50$.
4. `esther.cure(jackal)`: HP Jackal dipulihkan kembali menjadi $100$.
5. `quistis.attack(esther)`: Damage dasar = $10$, HP Esther berkurang menjadi $100 - 10 = 90$.

---

## V. KESIMPULAN

Berdasarkan praktikum dan penyelesaian tugas pada Jobsheet 6, dapat disimpulkan bahwa:
1. **Inheritance (Pewarisan)** merupakan pilar utama dalam OOP yang memungkinkan pembuatan class baru berdasarkan class yang sudah ada tanpa menulis ulang kode dasar (*code reusability* dan *extensibility*).
2. Keyword **`super`** memegang peranan krusial untuk:
   - Memanggil konstruktor berparameter milik superclass (`super(...)`).
   - Mengatasi *variable shadowing* dengan merujuk langsung ke atribut superclass (`super.namaVariabel`).
   - Memanggil implementasi asli method superclass saat dilakukan *method overriding* (`super.namaMethod()`).
3. Pemilihan **Access Modifier** (seperti `protected`) sangat penting dalam menjaga keseimbangan antara keamanan data (*encapsulation*) dan fleksibilitas akses oleh class turunan.
4. Mekanisme **Method Overriding** dan **Polimorfisme** mempermudah pengelolaan banyak tipe objek turunan dalam satu tipe referensi superclass yang seragam (seperti pada pengelolaan array `Pegawai[]` di `DaftarGaji`).
