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