# Laporan Jobsheet 3 — Encapsulation pada Java

**Mata Kuliah:** Pemrograman Berbasis Objek  
**Topik:** Encapsulation (Enkapsulasi)  
**Folder:** `jobsheet3motorencapsulation`  
**Tanggal:** 11 September 2026  

---

## 1. Tujuan

- Memahami konsep **Encapsulation** dalam pemrograman berbasis objek (OOP).
- Mampu menerapkan **access modifier** `private` dan `public` pada atribut dan method.
- Mampu membuat class dengan atribut tersembunyi yang hanya dapat diakses melalui method publik.

---

## 2. Dasar Teori

**Encapsulation** (enkapsulasi) adalah salah satu dari empat pilar OOP. Enkapsulasi adalah mekanisme untuk menyembunyikan data (atribut) dari akses luar secara langsung, dan hanya mengizinkan akses melalui method yang sudah ditentukan.

### Prinsip Enkapsulasi:
| Konsep | Keterangan |
|---|---|
| `private` | Atribut hanya bisa diakses dari dalam class itu sendiri |
| `public` | Method dapat diakses dari luar class |
| Method perilaku | Mengontrol bagaimana data diubah, mencegah nilai ilegal |

---

## 3. Struktur Program

### 3.1 Class `Motor` — [`Motor.java`](./Motor.java)

Class ini merepresentasikan sebuah motor dengan dua atribut `private`:

| Atribut | Tipe | Nilai Awal | Keterangan |
|---|---|---|---|
| `kecepatan` | `int` | `0` | Kecepatan motor saat ini |
| `kontakOn` | `boolean` | `false` | Status mesin (menyala/mati) |

**Method-method pada `Motor.java`:**

| Method | Return | Keterangan |
|---|---|---|
| `nyalakanMesin()` | `void` | Menyalakan mesin (`kontakOn = true`) |
| `matikanMesin()` | `void` | Mematikan mesin dan mereset kecepatan ke 0 |
| `tambahKecepatan()` | `void` | Menambah kecepatan 5 km/h jika mesin menyala |
| `kurangiKecepatan()` | `void` | Mengurangi kecepatan 5 km/h jika mesin menyala |
| `printStatus()` | `void` | Menampilkan status kontak dan kecepatan saat ini |

**Source Code `Motor.java`:**
```java
package jobsheet3motorencapsulation;

public class Motor {
    private int kecepatan = 0;
    private boolean kontakOn = false;

    public void nyalakanMesin() {
        kontakOn = true;
    }

    public void matikanMesin() {
        kontakOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (kontakOn == true) {
            kecepatan += 5;
        } else {
            System.out.println("Kecepatan Tidak Bisa Bertambah Karena Mesin Off");
        }
    }

    public void kurangiKecepatan() {
        if (kontakOn == true) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan Tidak Bisa Berkurang Karena Mesin Off");
        }
    }

    public void printStatus() {
        if (kontakOn == true) {
            System.out.println("Kontak On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan" + kecepatan + "\n");
    }
}
```

---

### 3.2 Class `MotorDemo` — [`MotorDemo.java`](./MotorDemo.java)

Class ini berisi method `main` untuk mendemonstrasikan penggunaan class `Motor`.

**Source Code `MotorDemo.java`:**
```java
package jobsheet3motorencapsulation;

public class MotorDemo {
    public static void main(String[] args) {
        Motor motor = new Motor();
        motor.printStatus();
        motor.tambahKecepatan();  // Gagal, mesin off

        motor.nyalakanMesin();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.matikanMesin();
        motor.printStatus();
    }
}
```

---

## 4. Alur Eksekusi Program

```
[mulai]
    │
    ▼
motor = new Motor()          → kecepatan=0, kontakOn=false
    │
    ▼
printStatus()                → "Kontak Off", Kecepatan: 0
    │
    ▼
tambahKecepatan()            → Gagal (mesin off), cetak pesan
    │
    ▼
nyalakanMesin()              → kontakOn = true
    │
    ▼
printStatus()                → "Kontak On", Kecepatan: 0
    │
    ▼
tambahKecepatan() x3         → kecepatan = 5, 10, 15
    │
    ▼
matikanMesin()               → kontakOn=false, kecepatan=0
    │
    ▼
printStatus()                → "Kontak Off", Kecepatan: 0
    │
   [selesai]
```

---

## 5. Output Program

```
Kontak Off
Kecepatan0

Kecepatan Tidak Bisa Bertambah Karena Mesin Off
Kontak On
Kecepatan0

Kontak On
Kecepatan5

Kontak On
Kecepatan10

Kontak On
Kecepatan15

Kontak Off
Kecepatan0
```

---

## 6. Analisis & Pembahasan

1. **Enkapsulasi berhasil diterapkan** — Atribut `kecepatan` dan `kontakOn` dideklarasikan `private` sehingga tidak bisa diakses langsung dari luar class.

2. **Kontrol akses data** — Method `tambahKecepatan()` dan `kurangiKecepatan()` memiliki validasi internal: kecepatan hanya bisa berubah jika mesin dalam kondisi menyala (`kontakOn == true`). Ini mencegah perubahan data yang tidak valid.

3. **Keamanan data** — Jika atribut `kecepatan` bersifat `public`, siapapun bisa mengubah nilainya secara sembarangan (misal: `motor.kecepatan = 9999`). Dengan enkapsulasi, hal ini dicegah.

---

## 7. Kesimpulan

- Enkapsulasi melindungi atribut dari akses luar yang tidak terkontrol.
- Penggunaan `private` pada atribut dan `public` pada method adalah praktik standar OOP.
- Method bertindak sebagai "penjaga gerbang" yang memastikan data hanya berubah sesuai logika yang benar.
