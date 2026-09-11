2. Pada Program diatas, pada class EncaTest kita mengetes age dengan nilai 35, namun pada saat 3. ditampilkan ke layar nilainya 30, jelaskan dan mengapa?
jawaban : karena pada class EncapDemo method setUmur melakukan validasi data jika nilai age lebih besar dari 30 maka nilai age akan diubah menjadi 30 
3. Ubah program tersebut agar atribut age dapat diberi nilai maksimal 30 dan minimal 18?
Jawaban : Untuk membatasi nilai umur minimal 18 dan maksimal 30, kita perlu mengubah logika validasi pada method `setUmur()` di class `EncapDemo`. Kita tambahkan kondisi `else if` untuk memeriksa apakah nilai lebih kecil dari 18, jika iya maka nilai umur akan diset menjadi 18. Berikut kode yang dimodifikasi:

```java
public void setUmur(int newUmur) {
    if (newUmur > 30) {
        umur = 30;
    } else if (newUmur < 18) {
        umur = 18;
    } else {
        umur = newUmur;
    }
}
```

Dengan perubahan ini:
- Jika nilai yang dimasukkan **lebih dari 30**, maka umur akan diset menjadi **30**
- Jika nilai yang dimasukkan **kurang dari 18**, maka umur akan diset menjadi **18**
- Jika nilai yang dimasukkan **antara 18-30**, maka umur akan diisi dengan nilai tersebut

4. Hasil dari class kontainer (dengan aturan keselamatan 50%)

Nama Pemilik Kontainer : PT. Maju Bersama
Kapasitas Maksimal :: 5000.0 Kg

Memasukkan muatan baru seberat 6000 kg....
Peringatan: Melebihi kapasitas! Muatan tidak ditambahkan.
Berat muatan saat ini : 0.0 Kg

Memasukan muatan seberat 4000 kg....
Berat muatan saat ini : 4000.0 Kg

Mengeluarkan muatan seberat 500 kg....
Berat muatan saat ini : 3500.0 Kg

Mencoba mengeluarkan muatan seberat 2000 kg (melebihi 50% batas aman)....
Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!
Berat muatan saat ini : 3500.0 Kg

Mengeluarkan muatan seberat 1500 kg (dalam batas aman)....
Berat muatan saat ini : 2000.0 Kg

5. Source code yang dimodifikasi
**Source Code `TestLogistik.java`:**
```java
 // Skenario keselamatan: mencoba menurunkan 2000 kg (>50% dari 3500 kg)
        System.out.println("\nMencoba mengeluarkan muatan seberat 2000 kg (melebihi 50% batas aman)....");
        kontainerAlfa.turunkanMuatan(2000);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getMuatanSaatini() + " Kg");

        // Pembongkaran bertahap yang aman
        System.out.println("\nMengeluarkan muatan seberat 1500 kg (dalam batas aman)....");
        kontainerAlfa.turunkanMuatan(1500);
        System.out.println("Berat muatan saat ini : " + kontainerAlfa.getMuatanSaatini() + " Kg");
    }
    Class Kontainer:

    public void turunkanMuatan(double berat) {
        double batasMaksimal = muatanSaatini * 0.5;
        if (berat > batasMaksimal) {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
        } else if (berat > muatanSaatini) {
            System.out.println("Peringatan: Muatan yang dikeluarkan melebihi muatan saat ini!");
        } else {
            muatanSaatini -= berat;
        }
    }
---
hasil dari source code yang dimodifikasi:
Nama Pemilik Kontainer : PT. Maju Bersama
Kapasitas Maksimal :: 5000.0 Kg

Memasukkan muatan baru seberat 6000 kg....
Peringatan: Melebihi kapasitas! Muatan tidak ditambahkan.
Berat muatan saat ini : 0.0 Kg

Memasukan muatan seberat 4000 kg....
Berat muatan saat ini : 4000.0 Kg

Mengeluarkan muatan seberat 500 kg....
Berat muatan saat ini : 3500.0 Kg

Mencoba mengeluarkan muatan seberat 2000 kg (melebihi 50% batas aman)....
Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!    
Berat muatan saat ini : 3500.0 Kg

Mengeluarkan muatan seberat 1500 kg (dalam batas aman)....
Berat muatan saat ini : 2000.0 Kg
,,,
---

6. source code:
package jobsheet3motorencapsulation;

import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ── Setup kontainer ──────────────────────────────────────────
        System.out.println("=== SISTEM MANAJEMEN KONTAINER LOGISTIK ===");
        System.out.print("Masukkan No. Resi kontainer : ");
        String noResi = scanner.nextLine();

        System.out.print("Masukkan nama pemilik       : ");
        String namaPemilik = scanner.nextLine();

        System.out.print("Masukkan kapasitas maksimal (kg) : ");
        double kapasitasMaksimal = scanner.nextDouble();

        Kontainer kontainer = new Kontainer(noResi, namaPemilik, kapasitasMaksimal);

        System.out.println("\n--- Info Kontainer ---");
        System.out.println("No. Resi          : " + kontainer.getResi());
        System.out.println("Nama Pemilik      : " + kontainer.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainer.getKapasitasMaksimal() + " Kg");

        // ── Menu interaktif ──────────────────────────────────────────
        int pilihan = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("  MENU OPERASI KONTAINER");
            System.out.println("========================================");
            System.out.println("  1. Tambah muatan (muat barang)");
            System.out.println("  2. Turunkan muatan (bongkar barang)");
            System.out.println("  3. Lihat status muatan saat ini");
            System.out.println("  0. Keluar");
            System.out.println("----------------------------------------");
            System.out.print("Pilih menu [0-3] : ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan berat muatan yang akan ditambahkan (kg) : ");
                    double beratTambah = scanner.nextDouble();
                    System.out.println("\nMemasukkan muatan seberat " + beratTambah + " kg....");
                    kontainer.tambahMuatan(beratTambah);
                    System.out.println("Berat muatan saat ini : " + kontainer.getMuatanSaatini() + " Kg");
                    break;

                case 2:
                    System.out.print("Masukkan berat muatan yang akan diturunkan (kg) : ");
                    double beratTurun = scanner.nextDouble();
                    System.out.println("\nMenurunkan muatan seberat " + beratTurun + " kg....");
                    kontainer.turunkanMuatan(beratTurun);
                    System.out.println("Berat muatan saat ini : " + kontainer.getMuatanSaatini() + " Kg");
                    break;

                case 3:
                    System.out.println("\n--- Status Muatan ---");
                    System.out.println("Muatan saat ini   : " + kontainer.getMuatanSaatini() + " Kg");
                    System.out.println("Kapasitas tersisa : "
                            + (kontainer.getKapasitasMaksimal() - kontainer.getMuatanSaatini()) + " Kg");
                    System.out.println("Batas turun aman  : " + (kontainer.getMuatanSaatini() * 0.5) + " Kg");
                    break;

                case 0:
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Masukkan angka 0-3.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}

,,,

---

7. hasil soorce code 
Peringatan: Harga tidak valid! Harga diset ke default Rp 35.000.
Film: Avengers : Endgame
Harga Tiket: 35000.0
Status Lunas? false

Memproses pembayaran...
Pembayaran berhasil! Tiket "Avengers : Endgame" kini berstatus LUNAS.
Status Lunas Terbaru? true


    