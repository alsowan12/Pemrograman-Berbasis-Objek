# Laporan Praktikum Pemrograman Berbasis Objek
## Pertemuan 9: Polimorfisme

- **Mata Kuliah:** Praktikum Pemrograman Berbasis Objek (RTI253008)
- **Pertemuan:** 9 (Minggu 9)
- **Topik:** Polimorfisme (Superclass & Interface Reference, Virtual Method Invocation, Heterogeneous Collection, Polymorphic Argument, Instanceof & Object Casting)
- **Bahasa Pemrograman:** Java (JDK 21+)
- **Lokasi Proyek:** [`jobsheet9`](file:///d:/BikeDemo/jobsheet9) & [`jobsheet9/Tugas`](file:///d:/BikeDemo/jobsheet9/Tugas)

---

## Daftar Isi
1. [Capaian Praktikum](#a-capaian-praktikum)
2. [Ringkasan Teori Polimorfisme](#b-ringkasan-teori-polimorfisme)
3. [Percobaan 1: Bentuk Dasar Polimorfisme](#c-percobaan-1-bentuk-dasar-polimorfisme)
   - [Langkah Kerja & Source Code](#1-langkah-kerja--source-code-percobaan-1)
   - [Output Eksekusi & Eksperimen](#2-output-eksekusi--eksperimen-percobaan-1)
   - [Jawaban Pertanyaan Percobaan 1](#3-jawaban-pertanyaan-percobaan-1)
4. [Percobaan 2: Virtual Method Invocation](#d-percobaan-2-virtual-method-invocation)
   - [Langkah Kerja & Source Code](#1-langkah-kerja--source-code-percobaan-2)
   - [Output Eksekusi & Eksperimen](#2-output-eksekusi--eksperimen-percobaan-2)
   - [Jawaban Pertanyaan Percobaan 2](#3-jawaban-pertanyaan-percobaan-2)
5. [Percobaan 3: Heterogeneous Collection](#e-percobaan-3-heterogeneous-collection)
   - [Langkah Kerja & Source Code](#1-langkah-kerja--source-code-percobaan-3)
   - [Output Eksekusi & Eksperimen](#2-output-eksekusi--eksperimen-percobaan-3)
   - [Jawaban Pertanyaan Percobaan 3](#3-jawaban-pertanyaan-percobaan-3)
6. [Percobaan 4: Polymorphic Argument, instanceof, dan Casting Objek](#f-percobaan-4-polymorphic-argument-instanceof-dan-casting-objek)
   - [Langkah Kerja & Source Code](#1-langkah-kerja--source-code-percobaan-4)
   - [Output Eksekusi & Eksperimen](#2-output-eksekusi--eksperimen-percobaan-4)
   - [Jawaban Pertanyaan Percobaan 4](#3-jawaban-pertanyaan-percobaan-4)
7. [Tugas Mandiri](#g-tugas-mandiri)
   - [Tugas 1: Permainan Zombie, Barrier, dan Plant](#tugas-1-permainan-zombie-barrier-dan-plant)
   - [Tugas 2: Heterogeneous Collection, instanceof, dan Casting](#tugas-2-heterogeneous-collection-instanceof-dan-casting)
   - [Tugas 3: Tabel Prediksi Hasil Kompilasi & Pembuktian](#tugas-3-prediksi-hasil-kompilasi--pembuktian)

---

## A. Capaian Praktikum
Setelah menyelesaikan jobsheet ini, mahasiswa mampu:
1. Menjelaskan konsep dan bentuk dasar polimorfisme, yaitu referensi bertipe superclass atau interface yang menunjuk objek subclass atau implementor.
2. Menjelaskan *virtual method invocation* dan membedakan tipe referensi (saat kompilasi) dari tipe objek (saat dijalankan).
3. Menerapkan polimorfisme pada *heterogeneous collection*, yaitu array atau koleksi yang berisi berbagai jenis objek turunan yang berbeda.
4. Menerapkan polimorfisme pada parameter method (*polymorphic argument*).
5. Menggunakan operator `instanceof` dan *object casting* (*upcasting* dan *downcasting*) secara aman dan tepat guna.

---

## B. Ringkasan Teori Polimorfisme

### 1. Konsep Dasar Polimorfisme
Secara etimologi, *polymorphism* berasal dari bahasa Yunani yang berarti "banyak bentuk". Dalam Pemrograman Berorientasi Objek (OOP), polimorfisme merujuk pada kemampuan satu variabel referensi untuk menunjuk objek dari berbagai tipe yang berbeda, asalkan objek tersebut memiliki hubungan pewarisan (*inheritance*) atau mengimplementasikan *interface* yang sama (*is-a relationship*).

### 2. Tipe Referensi vs Tipe Objek
- **Tipe Referensi (Compile-time Type):** Tipe data yang dideklarasikan saat variabel dibuat (misal `Employee e;`). Tipe ini digunakan oleh compiler Java untuk menentukan method dan atribut apa saja yang **boleh dipanggil**.
- **Tipe Objek (Runtime Type):** Tipe kelas sebenarnya dari objek yang diinstansiasi di memori heap menggunakan operator `new` (misal `new PermanentEmployee(...)`). Tipe ini menentukan **versi method mana yang akan dijalankan** saat runtime.

### 3. Virtual Method Invocation (VMI) & Dynamic Method Dispatch
Ketika method yang telah di-*override* dipanggil melalui variabel referensi superclass/interface, Java Virtual Machine (JVM) secara dinamis memilih versi method yang paling spesifik milik objek aktual di heap pada saat program berjalan. Mekanisme ini disebut **Virtual Method Invocation** atau **Dynamic Method Dispatch**.

### 4. Heterogeneous Collection
Array atau koleksi (seperti `ArrayList`) pada Java normalnya homogen (hanya menerima satu tipe data). Namun dengan polimorfisme, array bertipe superclass atau interface dapat menampung berbagai objek dari subclass atau implementor yang berbeda dalam satu wadah.

### 5. Object Casting & Operator `instanceof`
- **Upcasting (Subclass ke Superclass / Interface):** Terjadi secara otomatis dan implisit (misal: `Employee e = pEmp;`). Aman karena subclass pasti memenuhi kontrak superclass.
- **Downcasting (Superclass / Interface ke Subclass):** Harus ditulis secara eksplisit dengan tanda kurung (misal: `PermanentEmployee pe = (PermanentEmployee) e;`). Berisiko menimbulkan `java.lang.ClassCastException` jika objek sebenarnya bukan instansi dari subclass tujuan.
- **Operator `instanceof`:** Digunakan untuk menguji apakah suatu objek merupakan instansi dari suatu class tertentu sebelum downcasting dilakukan, sehingga mencegah kegagalan runtime (*type-safety check*).

---

## C. Percobaan 1: Bentuk Dasar Polimorfisme

### 1. Langkah Kerja & Source Code Percobaan 1

#### a. Konsep Pewarisan & Interface Animal – Vegetarian
- **File:** [`GambaranDasar.java`](file:///d:/BikeDemo/jobsheet9/GambaranDasar.java)
```java
package jobsheet9;

public class GambaranDasar {
    interface Vegetarian { }
    static class Animal { }
    static class Deer extends Animal implements Vegetarian { }
    static class Lion extends Animal { }

    public static void main(String[] args) {
        Deer d = new Deer();
        Lion l = new Lion();
     
        Animal a = d;       // valid: Deer adalah Animal
        Animal a2 = l;      // valid: Lion adalah Animal
        Vegetarian v = d;   // valid: Deer implements Vegetarian
        // Vegetarian v2 = l; // tidak valid: Lion tidak implements Vegetarian

        System.out.println("a menunjuk objek " + a.getClass().getSimpleName());
        System.out.println("a2 menunjuk objek " + a2.getClass().getSimpleName());
        System.out.println("v menunjuk objek " + v.getClass().getSimpleName());
    }
}
```

#### b. Studi Kasus Pegawai & Tagihan
- **File:** [`Employee.java`](file:///d:/BikeDemo/jobsheet9/Employee.java)
```java
package jobsheet9;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeInfo() {
        return "Name = " + name;
    }
}
```

- **File:** [`Payable.java`](file:///d:/BikeDemo/jobsheet9/Payable.java)
```java
package jobsheet9;

public interface Payable {
    int getPaymentAmount();
}
```

- **File:** [`PermanentEmployee.java`](file:///d:/BikeDemo/jobsheet9/PermanentEmployee.java)
```java
package jobsheet9;

public class PermanentEmployee extends Employee implements Payable {
    private int salary;

    public PermanentEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override 
    public int getPaymentAmount() {
        return (int) (salary + 0.05 * salary); // gaji + bonus 5%
    }

    @Override 
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as permanent employee with salary " + salary + "\n";
        return info;
    }
}
```

- **File:** [`InternshipEmployee.java`](file:///d:/BikeDemo/jobsheet9/InternshipEmployee.java)
```java
package jobsheet9;

public class InternshipEmployee extends Employee {
    private int lenght;

    public InternshipEmployee(String name, int length) {
        super(name);
        this.lenght = length;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int length) {
        this.lenght = length;
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " + lenght + " month/s\n";
        return info;
    }
}
```

- **File:** [`ElectricityBill.java`](file:///d:/BikeDemo/jobsheet9/ElectricityBill.java)
```java
package jobsheet9;

public class ElectricityBill implements Payable {
    private int kwh;
    private String category;

    public ElectricityBill(int kwh, String category) {
        this.kwh = kwh;
        this.category = category;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override 
    public int getPaymentAmount() {
        return kwh * getBaseprice();
    }

    public int getBaseprice() {
        return switch (category) {
            case "R-1" -> 100;
            case "R-2" -> 200;
            default -> 0;
        };
    }

    public String getBillInfo() {
        return "kWH = " + kwh + "\n" +
               "Category = " + category + " (" + getBaseprice() + " per kWH)\n";
    }
}
```

- **File:** [`MainPercobaan1.java`](file:///d:/BikeDemo/jobsheet9/MainPercobaan1.java)
```java
package jobsheet9;

public class MainPercobaan1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        Employee e;
        Payable p;

        e = pEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        e = iEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        p = pEmp;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
        p = eBill;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
    }
}
```

---

### 2. Output Eksekusi & Eksperimen Percobaan 1

#### Output `GambaranDasar.java`:
```text
a menunjuk objek Deer
a2 menunjuk objek Lion
v menunjuk objek Deer
```

#### Output `MainPercobaan1.java`:
```text
e menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
p menunjuk objek PermanentEmployee
p menunjuk objek ElectricityBill
```

#### Tabel Pengamatan Eksperimen Percobaan 1:
| Perubahan Kode | Pesan Error Kompilasi | Analisis Penyebab |
|---|---|---|
| Mengaktifkan `Vegetarian v2 = l;` pada `GambaranDasar` | `error: incompatible types: Lion cannot be converted to Vegetarian` | Class `Lion` hanya mewarisi `Animal` dan tidak mengimplementasikan interface `Vegetarian`. |
| Menambahkan `p = iEmp;` pada `MainPercobaan1` | `error: incompatible types: InternshipEmployee cannot be converted to Payable` | Class `InternshipEmployee` tidak mengimplementasikan interface `Payable`. |
| Menambahkan `e = eBill;` pada `MainPercobaan1` | `error: incompatible types: ElectricityBill cannot be converted to Employee` | Class `ElectricityBill` bukan merupakan turunan dari superclass `Employee`. |

---

### 3. Jawaban Pertanyaan Percobaan 1

1. **Class apa saja yang merupakan turunan dari class `Employee`?**
   - **Jawaban:** Class [`PermanentEmployee`](file:///d:/BikeDemo/jobsheet9/PermanentEmployee.java) dan [`InternshipEmployee`](file:///d:/BikeDemo/jobsheet9/InternshipEmployee.java). Keduanya mendeklarasikan klausa pewarisan `extends Employee`.

2. **Class apa saja yang meng-implements interface `Payable`?**
   - **Jawaban:** Class [`PermanentEmployee`](file:///d:/BikeDemo/jobsheet9/PermanentEmployee.java) dan [`ElectricityBill`](file:///d:/BikeDemo/jobsheet9/ElectricityBill.java). Keduanya mendeklarasikan `implements Payable` dan wajib mengimplementasikan method `getPaymentAmount()`.

3. **Pada `MainPercobaan1`, mengapa `e` dapat diisi dengan objek `pEmp` (PermanentEmployee) dan `iEmp` (InternshipEmployee)?**
   - **Jawaban:** Karena `PermanentEmployee` dan `InternshipEmployee` merupakan subclass dari `Employee` (memiliki relasi *is-a*). Berdasarkan aturan polimorfisme (*upcasting*), variabel referensi bertipe superclass (`Employee`) dapat secara otomatis dan sah menunjuk objek dari subclass turunannya.

4. **Pada `MainPercobaan1`, mengapa `p` dapat diisi dengan objek `pEmp` (PermanentEmployee) dan `eBill` (ElectricityBill)?**
   - **Jawaban:** Karena kedua kelas tersebut sama-sama mengimplementasikan interface `Payable`. Di Java, variabel referensi interface dapat menunjuk ke objek dari kelas mana pun yang memenuhi kontrak implementasi interface tersebut.

5. **Apa penyebab error pada `p = iEmp;` dan `e = eBill;`? Bandingkan dengan error pada `Vegetarian v2 = l;`.**
   - **Jawaban:**
     - `p = iEmp;` error karena `InternshipEmployee` tidak mengimplementasikan interface `Payable`.
     - `e = eBill;` error karena `ElectricityBill` bukan subclass dari `Employee`.
     - Kedua error tersebut identik dengan `Vegetarian v2 = l;` di mana `Lion` tidak mengimplementasikan `Vegetarian`. Compiler menolak assignment jika tidak ditemukan hubungan garis keturunan hierarki (*inheritance*) atau implementasi interface (*interface realization*) antara tipe objek dengan tipe variabel referensi tujuan.

6. **Pada `GambaranDasar`, variabel `a` bertipe `Animal`, tetapi `getClass()` menampilkan `Deer`. Apa beda tipe referensi dan tipe objek?**
   - **Jawaban:**
     - **Tipe Referensi:** Tipe data yang dideklarasikan saat penulisan variabel (dalam hal ini `Animal`). Tipe referensi diperiksa saat waktu kompilasi (*compile-time*) untuk membatasi atribut/method apa saja yang berhak dipanggil.
     - **Tipe Objek:** Tipe nyata dari objek yang diinstansiasi di memori heap oleh JVM saat runtime (dalam hal ini `new Deer()`). Method `getClass().getSimpleName()` mengembalikan kelas runtime sebenarnya dari objek tersebut.

7. **Ambil kesimpulan tentang konsep dan bentuk dasar polimorfisme.**
   - **Jawaban:** Bentuk dasar polimorfisme adalah kemampuan suatu variabel referensi bertipe superclass atau interface untuk menampung dan merepresentasikan berbagai objek dari subclass atau kelas implementornya. Hal ini memungkinkan penulisan kode yang lebih dinamis, terstandarisasi, dan modular.

---

## D. Percobaan 2: Virtual Method Invocation

### 1. Langkah Kerja & Source Code Percobaan 2
- **File:** [`MainPercobaan2.java`](file:///d:/BikeDemo/jobsheet9/MainPercobaan2.java)
```java
package jobsheet9;

public class MainPercobaan2 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        Employee e;
        e = pEmp;
        System.out.println(e.getEmployeeInfo());
        System.out.println("------------------");
        System.out.println(pEmp.getEmployeeInfo());

        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        e = iEmp;
        System.out.println("------------------");
        System.out.println(e.getEmployeeInfo()); // pernyataan sama, objek berbeda
    }
}
```

---

### 2. Output Eksekusi & Eksperimen Percobaan 2

#### Output `MainPercobaan2.java`:
```text
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Sunarto
Registered as internship employee for 5 month/s
```

#### Tabel Pengamatan Eksperimen Percobaan 2:
| Perubahan Kode | Pesan Error Kompilasi | Analisis Penyebab |
|---|---|---|
| Memanggil `System.out.println(e.getSalary());` saat `e` bertipe `Employee` | `error: cannot find symbol ... method getSalary() ... location: variable e of type Employee` | Compiler Java hanya memeriksa method milik tipe referensi (`Employee`). Class `Employee` tidak memiliki method `getSalary()`, meskipun objek aktual yang ditunjuk saat itu adalah `PermanentEmployee`. |

---

### 3. Jawaban Pertanyaan Percobaan 2

1. **Pada langkah 1, mengapa `e.getEmployeeInfo()` dan `pEmp.getEmployeeInfo()` menghasilkan hasil yang sama?**
   - **Jawaban:** Karena kedua variabel (`e` dan `pEmp`) merujuk ke objek yang sama di memori heap, yaitu instansi `PermanentEmployee("Dedik", 500)`. Melalui mekanisme *Virtual Method Invocation*, JVM memanggil versi override `getEmployeeInfo()` milik kelas objek sebenarnya (`PermanentEmployee`).

2. **Mengapa pemanggilan `e.getEmployeeInfo()` disebut pemanggilan method virtual, sedangkan `pEmp.getEmployeeInfo()` tidak?**
   - **Jawaban:** Disebut pemanggilan method virtual karena tipe referensi pemanggilnya (`Employee`) berbeda dari tipe kelas objek aktualnya (`PermanentEmployee`). Terjadi pengalihan resolusi method dari tipe referensi ke implementasi kelas objek sebenarnya saat program berjalan (*dynamic method dispatch*). Sedangkan pada `pEmp.getEmployeeInfo()`, tipe referensi dan tipe objek sudah identik (`PermanentEmployee`), sehingga tidak ada sifat "virtual" / polimorfik.

3. **Jelaskan maksud virtual method invocation. Mengapa disebut virtual?**
   - **Jawaban:** *Virtual Method Invocation* adalah mekanisme penentuan versi method override yang dijalankan pada saat program berjalan (runtime), berdasarkan tipe objek aktual di memori, bukan berdasarkan tipe variabel referensinya. Disebut "virtual" karena pada waktu kompilasi, pemanggilan tampak seperti memanggil method superclass (seolah-olah virtual), namun JVM secara otomatis mengeksekusi method konkret milik subclass yang sebenarnya.

4. **Pada langkah 3, mengapa pernyataan `e.getEmployeeInfo()` yang sama menghasilkan keluaran berbeda?**
   - **Jawaban:** Karena variabel referensi `e` telah diubah untuk menunjuk ke objek baru, yaitu `InternshipEmployee("Sunarto", 5)`. Karena class `InternshipEmployee` meng-override method `getEmployeeInfo()` dengan format informasinya sendiri, maka pemanggilan baris kode yang sama menghasilkan teks yang sesuai dengan objek yang sedang ditunjuknya.

5. **Pada langkah 4, mengapa `e.getSalary()` ditolak compiler padahal objek yang ditunjuk e adalah PermanentEmployee?**
   - **Jawaban:** Karena pemeriksaan hak akses dan validitas method oleh compiler Java selalu merujuk pada **tipe referensi**, yaitu `Employee`. Superclass `Employee` tidak memiliki deklarasi method `getSalary()`. Agar dapat memanggilnya, harus dilakukan proses *downcasting* eksplisit ke `PermanentEmployee`: `((PermanentEmployee) e).getSalary()`.

---

## E. Percobaan 3: Heterogeneous Collection

### 1. Langkah Kerja & Source Code Percobaan 3
- **File:** [`MainPercobaan3.java`](file:///d:/BikeDemo/jobsheet9/MainPercobaan3.java)
```java
package jobsheet9;

public class MainPercobaan3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");

        Employee[] e = {pEmp, iEmp};
        Payable[] p = {pEmp, eBill};
        // Employee[] e2 = {pEmp, iEmp, eBill}; // tidak valid

        for (Employee emp : e) {
            System.out.println(emp.getEmployeeInfo());
        }

        int total = 0;
        for (Payable tagihan : p) {
            total += tagihan.getPaymentAmount();
        }
        System.out.println("Total tagihan bulan ini = " + total);
    }
}
```

---

### 2. Output Eksekusi & Eksperimen Percobaan 3

#### Output `MainPercobaan3.java`:
```text
Name = Dedik
Registered as permanent employee with salary 500

Name = Sunarto
Registered as internship employee for 5 month/s

Total tagihan bulan ini = 1025
```
*Catatan Perhitungan:* 
- Gaji Dedik (500 + bonus 5% = 525)
- Tagihan Listrik (5 kWH × 100 [tarif R-1] = 500)
- Total = 525 + 500 = **1025** (Sesuai Checkpoint Jobsheet).

#### Tabel Pengamatan Eksperimen Percobaan 3:
| Perubahan Kode | Pesan Error Kompilasi | Analisis Penyebab |
|---|---|---|
| Mengaktifkan `Employee[] e2 = {pEmp, iEmp, eBill};` | `error: incompatible types: ElectricityBill cannot be converted to Employee` | Array bertipe `Employee[]` hanya menerima objek bertipe `Employee` atau subclass-nya. Objek `ElectricityBill` bukan turunan dari `Employee`. |

---

### 3. Jawaban Pertanyaan Percobaan 3

1. **Mengapa array `e` dapat berisi objek `pEmp` (PermanentEmployee) dan `iEmp` (InternshipEmployee) yang bertipe berbeda?**
   - **Jawaban:** Karena array `e` dideklarasikan bertipe `Employee[]`. Baik `PermanentEmployee` maupun `InternshipEmployee` mewarisi (*extends*) `Employee`. Polimorfisme memungkinkan array bertipe superclass menampung berbagai objek dari seluruh subclass turunannya (*heterogeneous collection*).

2. **Mengapa array `p` dapat berisi objek `pEmp` (PermanentEmployee) dan `eBill` (ElectricityBill) yang bertipe berbeda?**
   - **Jawaban:** Karena array `p` dideklarasikan bertipe interface `Payable[]`. Baik class `PermanentEmployee` maupun `ElectricityBill` sama-sama mengimplementasikan interface `Payable`, sehingga keduanya kompatibel dengan tipe elemen array tersebut.

3. **Mengapa terjadi error pada `Employee[] e2 = {pEmp, iEmp, eBill};`?**
   - **Jawaban:** Karena `ElectricityBill` tidak memiliki hubungan pewarisan dengan class `Employee`. Array bertipe elemen `Employee` menolak elemen yang bukan bertipe `Employee`.

4. **Pada perulangan `for (Employee emp : e)`, mengapa setiap elemen menghasilkan teks yang berbeda padahal pemanggilannya sama? Hubungkan dengan Percobaan 2.**
   - **Jawaban:** Ini adalah penerapan langsung dari *Virtual Method Invocation*. Pada setiap iterasi, variabel referensi `emp` menunjuk ke objek subclass yang berbeda (`PermanentEmployee` lalu `InternshipEmployee`). JVM secara dinamis mengeksekusi versi `getEmployeeInfo()` yang dioverride oleh masing-masing subclass, sehingga menghasilkan keluaran teks yang berbeda.

---

## F. Percobaan 4: Polymorphic Argument, instanceof, dan Casting Objek

### 1. Langkah Kerja & Source Code Percobaan 4

- **File:** [`Owner.java`](file:///d:/BikeDemo/jobsheet9/Owner.java)
```java
package jobsheet9;

public class Owner {
    public void pay(Payable p) {
        System.out.println("Total payment = " + p.getPaymentAmount());
        if (p instanceof ElectricityBill) {
            ElectricityBill eb = (ElectricityBill) p;
            System.out.println(eb.getBillInfo());
        } else if (p instanceof PermanentEmployee) {
            PermanentEmployee pe = (PermanentEmployee) p;
            System.out.println(pe.getEmployeeInfo());
        }
    }

    public void showMyEmployee(Employee e) {
        System.out.println(e.getEmployeeInfo());
        if (e instanceof PermanentEmployee) {
            System.out.println("You have to pay her/him monthly!!!");
        } else {
            System.out.println("No need to pay him/her :)");
        }
    }
}
```

- **File:** [`MainPercobaan4.java`](file:///d:/BikeDemo/jobsheet9/MainPercobaan4.java)
```java
package jobsheet9;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Owner ow = new Owner();

        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        ow.pay(eBill); // bayar tagihan listrik
        System.out.println("---------------------------------------");

        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        ow.pay(pEmp); // bayar pegawai tetap
        System.out.println("---------------------------------------");

        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ow.showMyEmployee(pEmp); // info pegawai tetap
        System.out.println("------------------------------");
        ow.showMyEmployee(iEmp); // info pegawai magang
    }
}
```

- **File:** [`Eksperimen4.java`](file:///d:/BikeDemo/jobsheet9/Eksperimen4.java) *(Eksperimen Downcasting Salah)*
```java
package jobsheet9;

public class Eksperimen4 {
    public static void main(String[] args) {
        Employee e = new InternshipEmployee("Sunarto", 5);
        System.out.println("Sebelum casting");
        PermanentEmployee pe = (PermanentEmployee) e; // Gagal saat runtime
        System.out.println("Sesudah casting: " + pe.getSalary());
    }
}
```

---

### 2. Output Eksekusi & Eksperimen Percobaan 4

#### Output `MainPercobaan4.java`:
```text
Total payment = 500
kWH = 5
Category = R-1 (100 per kWH)

---------------------------------------
Total payment = 525
Name = Dedik
Registered as permanent employee with salary 500

---------------------------------------
Name = Dedik
Registered as permanent employee with salary 500

You have to pay her/him monthly!!!
------------------------------
Name = Sunarto
Registered as internship employee for 5 month/s

No need to pay him/her :)
```

#### Tabel Pengamatan Eksperimen Percobaan 4:
| Perubahan Kode / File | Hasil Eksekusi | Analisis Penyebab |
|---|---|---|
| Menambahkan `ow.pay(iEmp);` di akhir `MainPercobaan4` | `error: incompatible types: InternshipEmployee cannot be converted to Payable` | Method `pay(Payable p)` menuntut parameter bertipe implementor `Payable`, sedangkan `InternshipEmployee` tidak mengimplementasikan `Payable`. |
| Menjalankan [`Eksperimen4.java`](file:///d:/BikeDemo/jobsheet9/Eksperimen4.java) | `Sebelum casting`<br>`Exception in thread "main" java.lang.ClassCastException: class jobsheet9.InternshipEmployee cannot be cast to class jobsheet9.PermanentEmployee` | Lolos kompilasi karena `e` bertipe `Employee`, namun saat runtime objek aktualnya adalah `InternshipEmployee`. Upaya downcasting ke `PermanentEmployee` memicu `ClassCastException`. Teks "Sesudah casting" tidak pernah dieksekusi. |

---

### 3. Jawaban Pertanyaan Percobaan 4

1. **Pada `MainPercobaan4`, mengapa `ow.pay(eBill)` dan `ow.pay(pEmp)` dapat dilakukan, padahal parameter `pay()` bertipe `Payable`? Perhatikan bahwa `eBill` adalah `ElectricityBill` dan `pEmp` adalah `PermanentEmployee`.**
   - **Jawaban:** Karena kedua objek tersebut mengimplementasikan interface `Payable`. Melalui polimorfisme parameter (*polymorphic argument*), sebuah method yang menerima parameter interface dapat menerima instansi dari kelas mana pun yang mengimplementasikan interface tersebut.

2. **Apa tujuan membuat parameter bertipe `Payable` pada method `pay()` di class `Owner`?**
   - **Jawaban:** Untuk mencapai fleksibilitas dan *loose coupling*. Method `pay()` cukup berfokus pada kontrak pembayaran (`getPaymentAmount()`). Dengan satu method ini, `Owner` dapat memproses berbagai macam objek tagihan tanpa harus membuat method pembayaran terpisah seperti `payElectricityBill()` atau `payPermanentEmployee()`.

3. **Mengapa `ow.pay(iEmp)` menyebabkan error?**
   - **Jawaban:** Karena class `InternshipEmployee` hanya turunan dari `Employee` dan tidak mengimplementasikan interface `Payable`. Parameter method `pay()` menuntut tipe `Payable`.

4. **Pada `Owner`, untuk apa sintaks `p instanceof ElectricityBill` diperlukan?**
   - **Jawaban:** Sintaks operator `instanceof` diperlukan untuk memeriksa tipe objek riil di runtime sebelum melakukan *downcasting*. Hal ini memastikan bahwa objek `p` benar-benar bertipe `ElectricityBill`, sehingga proses downcasting aman dan tidak menimbulkan `ClassCastException`.

5. **Pada `Owner`, untuk apa casting `(ElectricityBill) p` diperlukan? Mengapa objek `p` bertipe `Payable` harus di-cast ke `eb` bertipe `ElectricityBill`? Petunjuk: method apa yang dikenal oleh tipe Payable?**
   - **Jawaban:** Tipe referensi `Payable` hanya mengenal method yang dideklarasikan di dalam interface-nya, yaitu `getPaymentAmount()`. Method `getBillInfo()` hanya ada pada class `ElectricityBill`. Agar compiler mengizinkan pemanggilan method khusus tersebut, objek referensi `p` harus di-downcast ke tipe `ElectricityBill`.

6. **Pada `Eksperimen4`, mengapa kode lolos kompilasi tetapi gagal saat dijalankan? Bagaimana `instanceof` mencegah kegagalan tersebut?**
   - **Jawaban:**
     - **Lolos Kompilasi:** Karena compiler hanya melihat hierarki tipe: `e` bertipe `Employee`, dan `PermanentEmployee` adalah turunan `Employee`. Secara teoritis, casting tersebut dimungkinkan (*legal cast syntax*).
     - **Gagal Runtime:** Saat program dieksekusi, JVM melihat bahwa objek di heap sesungguhnya adalah `InternshipEmployee`. Kelas ini tidak dapat dikonversi ke kelas saudara selevelnya (*sibling*) `PermanentEmployee`, sehingga dilempar `ClassCastException`.
     - **Pencegahan oleh `instanceof`:** Dengan menggunakan `if (e instanceof PermanentEmployee)`, blok casting hanya akan dimasuki jika objek aslinya memang benar `PermanentEmployee`, sehingga error runtime dapat dihindari sepenuhnya.

---

## G. Tugas Mandiri

### Tugas 1: Permainan Zombie, Barrier, dan Plant

#### Deskripsi Permainan & Aturan Perhitungan:
1. **Aturan Pembulatan & Tipe Data:** Semua persentase dihitung dari nilai saat ini dengan pembagian bilangan bulat (dibulatkan ke bawah).
2. **Penyembuhan `heal()`:** Menambah health sebesar persentase dari health saat ini, maksimal tidak boleh melebihi 100 (`Math.min(health, 100)`). Level di luar 1-3 tidak mengubah health.
   - **WalkingZombie:**
     - Level 1: `health += health * 10 / 100;`
     - Level 2: `health += health * 30 / 100;`
     - Level 3: `health += health * 40 / 100;`
   - **JumpingZombie:**
     - Level 1: `health += health * 30 / 100;`
     - Level 2: `health += health * 40 / 100;`
     - Level 3: `health += health * 50 / 100;`
3. **Penghancuran `destroyed()`:**
   - **WalkingZombie:** Health dikurangi 20% $\rightarrow$ `health -= health * 20 / 100;`
   - **JumpingZombie:** Health dikurangi 10% $\rightarrow$ `health -= health * 10 / 100;`
   - **Barrier:** Strength menjadi 90% $\rightarrow$ `strength = strength * 9 / 10;`
4. **Plant:** Memiliki method `doDestroy(Destroyable d)` yang memanggil `d.destroyed()`.

---

#### Implementasi Source Code Tugas 1:

- **Interface:** [`Destroyable.java`](file:///d:/BikeDemo/jobsheet9/Tugas/Destroyable.java)
```java
package jobsheet9.Tugas;

public interface Destroyable {
    void destroyed();
}
```

- **Abstract Superclass:** [`Zombie.java`](file:///d:/BikeDemo/jobsheet9/Tugas/Zombie.java)
```java
package jobsheet9.Tugas;

public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    @Override
    public abstract void destroyed();

    public String getZombieInfo() {
        return "Health = " + health + "\n"
             + "Level = " + level + "\n";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
```

- **Subclass:** [`WalkingZombie.java`](file:///d:/BikeDemo/jobsheet9/Tugas/WalkingZombie.java)
```java
package jobsheet9.Tugas;

public class WalkingZombie extends Zombie {

    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health += health * 10 / 100;
            case 2 -> health += health * 30 / 100;
            case 3 -> health += health * 40 / 100;
        }
        health = Math.min(health, 100);
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data = \n" + super.getZombieInfo();
    }
}
```

- **Subclass:** [`JumpingZombie.java`](file:///d:/BikeDemo/jobsheet9/Tugas/JumpingZombie.java)
```java
package jobsheet9.Tugas;

public class JumpingZombie extends Zombie {

    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1 -> health += health * 30 / 100;
            case 2 -> health += health * 40 / 100;
            case 3 -> health += health * 50 / 100;
        }
        health = Math.min(health, 100);
    }

    @Override
    public void destroyed() {
        health -= health * 10 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data = \n" + super.getZombieInfo();
    }
}
```

- **Class:** [`Barrier.java`](file:///d:/BikeDemo/jobsheet9/Tugas/Barrier.java)
```java
package jobsheet9.Tugas;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void destroyed() {
        strength = strength * 9 / 10;
    }

    public String getBarrierInfo() {
        return "Barrier Strength = " + strength + "\n";
    }
}
```

- **Class:** [`Plant.java`](file:///d:/BikeDemo/jobsheet9/Tugas/Plant.java)
```java
package jobsheet9.Tugas;

public class Plant {
    public void doDestroy(Destroyable d) {
        d.destroyed();
    }
}
```

- **Main Program:** [`MainTugas1.java`](file:///d:/BikeDemo/jobsheet9/Tugas/MainTugas1.java)
```java
package jobsheet9.Tugas;

public class MainTugas1 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
        System.out.println("----------------------");

        for (int i = 0; i < 4; i++) { // hancurkan 4 kali
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }

        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
    }
}
```

---

#### Output Eksekusi `MainTugas1.java`:
```text
Walking Zombie Data = 
Health = 100
Level = 1

Jumping Zombie Data = 
Health = 100
Level = 2

Barrier Strength = 100

----------------------
Walking Zombie Data = 
Health = 42
Level = 1

Jumping Zombie Data = 
Health = 66
Level = 2

Barrier Strength = 64
```

> **Verifikasi Checkpoint Tugas 1:**
> - **Sebelum:** Health = 100 untuk kedua zombie, Barrier Strength = 100.
> - **Setelah 4x destroyed():**
>   - WalkingZombie: $100 \rightarrow 80 \rightarrow 64 \rightarrow 52 \rightarrow \mathbf{42}$
>   - JumpingZombie: $100 \rightarrow 90 \rightarrow 81 \rightarrow 73 \rightarrow \mathbf{66}$
>   - Barrier: $100 \rightarrow 90 \rightarrow 81 \rightarrow 72 \rightarrow \mathbf{64}$
>   *(Status: **100% Cocok Sesuai Checkpoint Jobsheet**)*

---

#### Jawaban Pertanyaan Analisis Tugas 1:
- **(a) Mengapa `Plant.doDestroy()` dapat menerima `WalkingZombie`, `JumpingZombie`, dan `Barrier` padahal ketiganya tidak berada dalam satu hierarki class?**
  - **Jawaban:** Karena method `doDestroy` dideklarasikan menerima parameter interface `Destroyable` (`public void doDestroy(Destroyable d)`). Baik hierarki `Zombie` (`WalkingZombie` dan `JumpingZombie` turunan dari abstract class `Zombie implements Destroyable`) maupun class `Barrier` (`implements Destroyable`) sama-sama mengimplementasikan interface `Destroyable`. Interface di Java memungkinkan polimorfisme lintas hierarki kelas (*cross-hierarchy polymorphism*).

- **(b) Pada `d.destroyed()` di dalam `Plant`, apa tipe referensi dan tipe objek, dan versi `destroyed()` mana yang dijalankan untuk tiap pemanggilan di `MainTugas1`?**
  - **Jawaban:**
    - **Tipe Referensi:** Selalu bertipe `Destroyable`.
    - **Tipe Objek & Versi yang Dijalankan:**
      1. Pemanggilan `p.doDestroy(wz)`: Tipe objek adalah `WalkingZombie`. Versi `destroyed()` yang dijalankan adalah milik `WalkingZombie` (pengurangan health 20%).
      2. Pemanggilan `p.doDestroy(jz)`: Tipe objek adalah `JumpingZombie`. Versi `destroyed()` yang dijalankan adalah milik `JumpingZombie` (pengurangan health 10%).
      3. Pemanggilan `p.doDestroy(b)`: Tipe objek adalah `Barrier`. Versi `destroyed()` yang dijalankan adalah milik `Barrier` (kekuatan berkurang menjadi 90%).

- **(c) Apa yang terjadi bila Anda menulis `new Zombie(100, 1)`? Tuliskan pesan errornya.**
  - **Jawaban:** Terjadi error kompilasi karena class `Zombie` merupakan `abstract class`. Class abstract bersifat tidak lengkap dan tidak dapat diinstansiasi secara langsung dengan operator `new`.
  - **Pesan error compiler:**
    ```text
    error: Zombie is abstract; cannot be instantiated
        Zombie z = new Zombie(100, 1);
                   ^
    ```

---

### Tugas 2: Heterogeneous Collection, instanceof, dan Casting

#### Langkah Kerja Tugas 2:
1. Menyimpan satu `WalkingZombie(100, 1)`, satu `JumpingZombie(100, 2)`, dan satu `Barrier(100)` dalam sebuah array bertipe `Destroyable[]`.
2. Menghancurkan seluruh elemen array sebanyak 4 kali menggunakan `Plant`.
3. Menelusuri array menggunakan perulangan:
   - Jika elemen berupa `Zombie`, di-downcast ke `Zombie`, dipanggil method `heal()`, lalu dicetak informasinya melalui `getZombieInfo()`.
   - Jika elemen berupa `Barrier`, di-downcast ke `Barrier`, lalu dicetak informasinya melalui `getBarrierInfo()`.

#### Source Code [`MainTugas2.java`](file:///d:/BikeDemo/jobsheet9/Tugas/MainTugas2.java):
```java
package jobsheet9.Tugas;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] listDestroyable = { wz, jz, b };

        // Hancurkan semua elemen array sebanyak 4 kali
        for (int i = 0; i < 4; i++) {
            for (Destroyable d : listDestroyable) {
                p.doDestroy(d);
            }
        }

        // Telusuri array, lakukan casting dan aksi spesifik
        for (Destroyable d : listDestroyable) {
            if (d instanceof Zombie) {
                Zombie z = (Zombie) d;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (d instanceof Barrier) {
                Barrier bar = (Barrier) d;
                System.out.println(bar.getBarrierInfo());
            }
        }
    }
}
```

---

#### Output Eksekusi `MainTugas2.java`:
```text
Walking Zombie Data = 
Health = 46
Level = 1

Jumping Zombie Data = 
Health = 92
Level = 2

Barrier Strength = 64
```

> **Verifikasi Checkpoint Tugas 2:**
> - WalkingZombie: Health 42 setelah 4 hit $\rightarrow$ heal level 1 (+10%): $42 + (42 \times 10 / 100) = 42 + 4 = \mathbf{46}$.
> - JumpingZombie: Health 66 setelah 4 hit $\rightarrow$ heal level 2 (+40%): $66 + (66 \times 40 / 100) = 66 + 26 = \mathbf{92}$.
> - Barrier: Strength menjadi $\mathbf{64}$.
> *(Status: **100% Cocok Sesuai Checkpoint Jobsheet**)*

---

#### Jawaban Pertanyaan Analisis Tugas 2:
- **(a) Mengapa array harus bertipe `Destroyable`, bukan `Zombie`?**
  - **Jawaban:** Karena array tersebut harus menampung objek `WalkingZombie`, `JumpingZombie`, dan objek `Barrier`. Class `Barrier` bukan merupakan turunan dari class `Zombie`. Satu-satunya tipe umum yang menaungi ketiganya adalah interface `Destroyable`. Jika array dideklarasikan bertipe `Zombie[]`, maka compiler akan menolak objek `Barrier` dengan error `incompatible types: Barrier cannot be converted to Zombie`.

- **(b) Mengapa casting ke `Zombie` diperlukan sebelum memanggil `heal()`?**
  - **Jawaban:** Karena elemen array memiliki tipe referensi `Destroyable`. Interface `Destroyable` hanya mendeklarasikan method `destroyed()`. Method `heal()` merupakan method yang dideklarasikan pada class `Zombie`. Agar compiler mengizinkan pemanggilan `heal()`, referensi harus di-downcast ke tipe `Zombie` (`((Zombie) d).heal()`).

- **(c) Apa yang terjadi bila pemeriksaan `instanceof` dihilangkan dan elemen `Barrier` di-cast ke Zombie?**
  - **Jawaban:** Program akan lolos saat proses kompilasi, namun saat dijalankan (runtime) pada iterasi elemen `Barrier`, JVM akan melempar exception:
    `java.lang.ClassCastException: class jobsheet9.Tugas.Barrier cannot be cast to class jobsheet9.Tugas.Zombie` dan program akan berhenti seketika (*crash*).

---

### Tugas 3: Prediksi Hasil Kompilasi & Pembuktian

#### 1. Tabel Analisis dan Prediksi 8 Pernyataan

| No | Pernyataan Kode | Prediksi | Alasan Teknis |
|---|---|---|---|
| 1 | `Zombie z = new WalkingZombie(100, 1);` | **OK** | *Upcasting* yang sah. `WalkingZombie` adalah subclass konkret dari `Zombie`. Referensi superclass berhak menunjuk objek subclass. |
| 2 | `Destroyable d = z;` | **OK** | *Upcasting* ke interface sah. Class `Zombie` mengimplementasikan interface `Destroyable`. |
| 3 | `Zombie z2 = d;` | **Error Kompilasi** | *Incompatible types*. Tipe referensi `d` adalah interface `Destroyable` (supertipenya). Penugasan supertipe ke subtipe tidak dapat dilakukan secara implisit dan membutuhkan *explicit downcasting*. Pesan error: `incompatible types: Destroyable cannot be converted to Zombie`. |
| 4 | `Zombie z3 = (Zombie) d;` | **OK** | *Explicit downcasting* yang sah. Tipe referensi di-cast ke `Zombie`, dan objek runtime nyata yang ditunjuk `d` memang instansi dari `WalkingZombie` (yang merupakan turunan dari `Zombie`). |
| 5 | `Zombie z4 = new Zombie(100, 1);` | **Error Kompilasi** | Class `Zombie` dideklarasikan sebagai `abstract class`. Menurut aturan OOP Java, kelas abstract tidak dapat diinstansiasi secara langsung menggunakan operator `new`. Pesan error: `Zombie is abstract; cannot be instantiated`. |
| 6 | `Destroyable d2 = new Plant();` | **Error Kompilasi** | *Incompatible types*. Class `Plant` tidak mengimplementasikan interface `Destroyable` (tidak ada relasi pewarisan maupun implementasi). Pesan error: `incompatible types: Plant cannot be converted to Destroyable`. |
| 7 | `Zombie z5 = new JumpingZombie(100, 2);` | **OK** | *Upcasting* yang sah. `JumpingZombie` adalah subclass konkret dari `Zombie`. |
| 8 | `WalkingZombie w = (WalkingZombie) z5;` | **Error saat Dijalankan (Runtime Error)** | Lolos kompilasi karena keduanya berada dalam hierarki class yang sama (`Zombie`), namun saat runtime objek riil di memori heap adalah `JumpingZombie`. Objek `JumpingZombie` tidak dapat dikonversi ke kelas saudaranya (*sibling*) `WalkingZombie`, sehingga JVM melempar `java.lang.ClassCastException`. |

---

#### 2. Kode Pembuktian [`MainTugas3.java`](file:///d:/BikeDemo/jobsheet9/Tugas/MainTugas3.java):
```java
package jobsheet9.Tugas;

public class MainTugas3 {
    public static void main(String[] args) {
        // Pernyataan 1: OK
        Zombie z = new WalkingZombie(100, 1);
        System.out.println("1. Zombie z = new WalkingZombie(100, 1); -> OK");

        // Pernyataan 2: OK
        Destroyable d = z;
        System.out.println("2. Destroyable d = z; -> OK");

        // Pernyataan 3: Error Kompilasi
        // Zombie z2 = d; // error: incompatible types: Destroyable cannot be converted to Zombie

        // Pernyataan 4: OK
        Zombie z3 = (Zombie) d;
        System.out.println("4. Zombie z3 = (Zombie) d; -> OK");

        // Pernyataan 5: Error Kompilasi
        // Zombie z4 = new Zombie(100, 1); // error: Zombie is abstract; cannot be instantiated

        // Pernyataan 6: Error Kompilasi
        // Destroyable d2 = new Plant(); // error: incompatible types: Plant cannot be converted to Destroyable

        // Pernyataan 7: OK
        Zombie z5 = new JumpingZombie(100, 2);
        System.out.println("7. Zombie z5 = new JumpingZombie(100, 2); -> OK");

        // Pernyataan 8: Error saat dijalankan (ClassCastException)
        try {
            WalkingZombie w = (WalkingZombie) z5;
            System.out.println("8. WalkingZombie w = (WalkingZombie) z5; -> OK");
        } catch (ClassCastException e) {
            System.out.println("8. WalkingZombie w = (WalkingZombie) z5; -> Runtime Error: " + e);
        }
    }
}
```

#### Output Eksekusi Pembuktian `MainTugas3.java`:
```text
1. Zombie z = new WalkingZombie(100, 1); -> OK
2. Destroyable d = z; -> OK
4. Zombie z3 = (Zombie) d; -> OK
7. Zombie z5 = new JumpingZombie(100, 2); -> OK
8. WalkingZombie w = (WalkingZombie) z5; -> Runtime Error: java.lang.ClassCastException: class jobsheet9.Tugas.JumpingZombie cannot be cast to class jobsheet9.Tugas.WalkingZombie
```

---

## H. Kesimpulan Akhir
Berdasarkan seluruh percobaan dan pengerjaan tugas mandiri pada Jobsheet 9 ini, dapat disimpulkan bahwa:
1. **Polimorfisme** memungkinkan penulisan program Java yang sangat fleksibel dan modular, di mana variabel bertipe superclass atau interface dapat memperlakukan berbagai objek turunannya secara seragam.
2. **Virtual Method Invocation (VMI)** memastikan bahwa perilaku (*behavior*) objek yang dijalankan saat runtime selalu merefleksikan implementasi spesifik dari subclass objek sebenarnya (*dynamic dispatch*), meskipun dipanggil melalui variabel bertipe superclass atau interface.
3. **Heterogeneous Collection** dan **Polymorphic Argument** mempermudah pengelompokan serta pemrosesan batch dari objek-objek yang beragam tanpa memerlukan duplikasi kode atau method penanganan terpisah.
4. Penggunaan operator **`instanceof`** sebelum melakukan **downcasting** sangat penting untuk menjamin keamanan tipe (*type safety*) dan mencegah terjadinya kesalahan runtime berupa **`ClassCastException`**.
