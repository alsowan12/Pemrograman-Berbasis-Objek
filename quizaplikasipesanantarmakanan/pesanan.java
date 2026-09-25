package quizaplikasipesanantarmakanan;
// Arga Chandra Wirawan
// Kelas TI-2G
// No. Absen 03
import java.util.ArrayList;
public class pesanan {
    private static int counterKode = 1000; // auto-increment kode pesanan

    private int kodePesanan;
    private pelanggan pelangganPemesan;
    private restoran restoranTujuan;
    private ArrayList<makanan> daftarItem;
    private String status;
    private String simpanInfo;

    // Constructor
    public pesanan(pelanggan pelangganPemesan, restoran restoranTujuan) {
        this.kodePesanan = ++counterKode;
        this.pelangganPemesan = pelangganPemesan;
        this.restoranTujuan = restoranTujuan;
        this.daftarItem = new ArrayList<>();
        this.status = "MENUNGGU";
        this.simpanInfo = "";
    }

    // Tambah item makanan ke pesanan
    public void tambahItem(makanan m) {
        // Cek apakah makanan tersedia di restoran
        makanan cek = restoranTujuan.cariMakanan(m.getNamaMakanan());
        if (cek != null) {
            daftarItem.add(m);
            System.out.println("  + " + m.getNamaMakanan() + " (Rp " + m.getHarga() + ") ditambahkan ke pesanan.");
        } else {
            System.out.println("  [!] " + m.getNamaMakanan() + " tidak tersedia di " + restoranTujuan.getNamaResto());
        }
    }

    // Hitung total harga makanan
    public int hitungTotalHarga() {
        int total = 0;
        for (makanan m : daftarItem) {
            total += m.getHarga();
        }
        return total;
    }

    // Hitung total pembayaran (harga + ongkir)
    public int hitungTotalPembayaran(kurir k) {
        int ongkir = k.hitungOngkir(restoranTujuan.getJarakTempuh());
        return hitungTotalHarga() + ongkir;
    }

    // Update status pesanan
    public void updateStatus(String statusBaru) {
        this.status = statusBaru;
        System.out.println("  [STATUS] Pesanan #" + kodePesanan + " -> " + statusBaru);
    }

    // Simpan catatan tambahan
    public void simpanCatatan(String catatan) {
        this.simpanInfo = catatan;
    }

    // Tampilkan ringkasan pesanan
    public void tampilkanPesanan(kurir k) {
        System.out.println("\n========================================");
        System.out.println("       STRUK PESANAN #" + kodePesanan);
        System.out.println("========================================");
        System.out.println(" Pelanggan : " + pelangganPemesan.getNamaPelanggan());
        System.out.println(" Alamat    : " + pelangganPemesan.getAlamatPengiriman());
        System.out.println(" Restoran  : " + restoranTujuan.getNamaResto());
        System.out.println(" Status    : " + status);
        System.out.println("----------------------------------------");
        System.out.println(" ITEM PESANAN:");
        for (int i = 0; i < daftarItem.size(); i++) {
            makanan m = daftarItem.get(i);
            System.out.printf("   %d. %-20s Rp %,d%n", (i + 1), m.getNamaMakanan(), m.getHarga());
        }
        System.out.println("----------------------------------------");
        System.out.printf(" Subtotal Makanan       : Rp %,d%n", hitungTotalHarga());

        int ongkir = k.hitungOngkir(restoranTujuan.getJarakTempuh());
        System.out.printf(" Ongkos Kirim (%d km)   : Rp %,d%n", restoranTujuan.getJarakTempuh(), ongkir);
        System.out.printf(" TOTAL PEMBAYARAN       : Rp %,d%n", hitungTotalPembayaran(k));
        System.out.println("----------------------------------------");
        System.out.println(" Kurir     : " + k.getNamaKurir() + " (" + k.getNomorKendaraan() + ")");
        if (!simpanInfo.isEmpty()) {
            System.out.println(" Catatan   : " + simpanInfo);
        }
        System.out.println("========================================\n");
    }

    // Getter
    public int getKodePesanan() {
        return kodePesanan;
    }

    public int getTotalHarga() {
        return hitungTotalHarga();
    }

    public String getStatus() {
        return status;
    }

    public pelanggan getPelangganPemesan() {
        return pelangganPemesan;
    }
}
