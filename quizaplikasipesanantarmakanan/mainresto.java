package quizaplikasipesanantarmakanan;
// Arga Chandra Wirawan 
// Kelas TI-2G
// No. Absen 03
import java.util.Scanner;

public class mainresto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   SELAMAT DATANG DI APLIKASI FOOD ORDER  ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        restoran warungBakar = new restoran("Warung Bakar Mas Bro", "Jl. Merdeka No. 10, Jakarta", 3);
        restoran cafeKopi    = new restoran("Cafe Kopi Nusantara",   "Jl. Sudirman No. 45, Jakarta", 5);

        warungBakar.tambahMenu(new makanan("Sate Ayam",    20000, "Makanan"));
        warungBakar.tambahMenu(new makanan("Nasi Goreng",  15000, "Makanan"));
        warungBakar.tambahMenu(new makanan("Ayam Bakar",   25000, "Makanan"));
        warungBakar.tambahMenu(new makanan("Es Teh Manis",  5000, "Minuman"));
        warungBakar.tambahMenu(new makanan("Jus Alpukat",  12000, "Minuman"));

        cafeKopi.tambahMenu(new makanan("Kopi Susu",    18000, "Minuman"));
        cafeKopi.tambahMenu(new makanan("Matcha Latte", 22000, "Minuman"));
        cafeKopi.tambahMenu(new makanan("Roti Bakar",   12000, "Makanan"));
        cafeKopi.tambahMenu(new makanan("Pancake",      20000, "Makanan"));

        
        kurir kurirAndi = new kurir("Andi", "B 1234 XYZ", 3000); // Rp 3.000/km
        kurir kurirRudi = new kurir("Rudi", "B 5678 ABC", 2500); // Rp 2.500/km

        System.out.println(">>> [1] INPUT DATA PELANGGAN");
        System.out.println("--------------------------------------------");
        System.out.print("Masukkan nama Anda        : ");
        String namaPelanggan = sc.nextLine();

        System.out.print("Masukkan nomor HP Anda    : ");
        String nomorHP = sc.nextLine();

        System.out.print("Masukkan alamat pengiriman: ");
        String alamat = sc.nextLine();

        pelanggan pelangganBaru = new pelanggan(namaPelanggan, nomorHP, alamat);

        System.out.println("\nData pelanggan tersimpan:");
        pelangganBaru.tampilkanInfo();

        System.out.println("\n>>> [2] PILIH RESTORAN");
        System.out.println("--------------------------------------------");
        System.out.println("  1. " + warungBakar.getNamaResto()
                + "  (Jarak: " + warungBakar.getJarakTempuh() + " km)");
        System.out.println("  2. " + cafeKopi.getNamaResto()
                + "  (Jarak: " + cafeKopi.getJarakTempuh() + " km)");
        System.out.print("Pilih restoran [1/2]: ");

        int pilihanResto = 0;
        while (pilihanResto != 1 && pilihanResto != 2) {
            try {
                pilihanResto = Integer.parseInt(sc.nextLine().trim());
                if (pilihanResto != 1 && pilihanResto != 2)
                    System.out.print("Pilihan tidak valid! Masukkan 1 atau 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka 1 atau 2: ");
            }
        }

        restoran restoranDipilih = (pilihanResto == 1) ? warungBakar : cafeKopi;
        System.out.println("Restoran dipilih: " + restoranDipilih.getNamaResto());
        restoranDipilih.tampilkanMenu();

        System.out.println(">>> [3] PILIH MAKANAN");
        System.out.println("--------------------------------------------");
        System.out.println("Ketik nama makanan yang ingin dipesan.");
        System.out.println("Ketik 'SELESAI' jika sudah selesai memesan.\n");

        pesanan pesananBaru = new pesanan(pelangganBaru, restoranDipilih);

        while (true) {
            System.out.print("Nama makanan: ");
            String namaMakanan = sc.nextLine().trim();

            if (namaMakanan.equalsIgnoreCase("SELESAI")) break;

            makanan cek = restoranDipilih.cariMakanan(namaMakanan);
            if (cek != null) {
                pesananBaru.tambahItem(cek);
            } else {
                System.out.println("  [!] '" + namaMakanan
                        + "' tidak ditemukan di menu. Coba lagi.");
            }
        }

        System.out.println("\n>>> [4] PILIH KURIR");
        System.out.println("--------------------------------------------");
        System.out.println("  1. Kurir: Andi | No. Kendaraan: B 1234 XYZ"
                + " | Tarif: Rp 3.000/km");
        System.out.println("  2. Kurir: Rudi | No. Kendaraan: B 5678 ABC"
                + " | Tarif: Rp 2.500/km");
        System.out.print("Pilih kurir [1=Andi / 2=Rudi]: ");

        int pilihanKurir = 0;
        while (pilihanKurir != 1 && pilihanKurir != 2) {
            try {
                pilihanKurir = Integer.parseInt(sc.nextLine().trim());
                if (pilihanKurir != 1 && pilihanKurir != 2)
                    System.out.print("Pilihan tidak valid! Masukkan 1 atau 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka 1 atau 2: ");
            }
        }

        kurir kurirDipilih = (pilihanKurir == 1) ? kurirAndi : kurirRudi;
        System.out.println("Kurir dipilih: " + kurirDipilih.getNamaKurir());

        System.out.print("\nCatatan tambahan (kosongkan jika tidak ada): ");
        String catatan = sc.nextLine();
        if (!catatan.isEmpty()) {
            pesananBaru.simpanCatatan(catatan);
        }

        System.out.println("\n>>> [5] MEMPROSES PESANAN...");
        System.out.println("--------------------------------------------");

        int jarak  = restoranDipilih.getJarakTempuh();   // km
        int tarif  = kurirDipilih.getTarif();             // Rp/km
        int ongkir = tarif * jarak;                       // tarif × jarak

        System.out.println("  Tarif kurir : Rp " + String.format("%,d", tarif) + "/km");
        System.out.println("  Jarak       : " + jarak + " km");
        System.out.println("  Ongkos Kirim: Rp " + String.format("%,d", tarif)
                + " × " + jarak + " km = Rp " + String.format("%,d", ongkir));

        pesananBaru.updateStatus("DIPROSES");
        kurirDipilih.ambilPesanan(pesananBaru);
        pesananBaru.updateStatus("DIANTAR");

        pesananBaru.tampilkanPesanan(kurirDipilih);

        pesananBaru.updateStatus("SELESAI");
        kurirDipilih.selesaiAntar();

        sc.close();
    }
}
