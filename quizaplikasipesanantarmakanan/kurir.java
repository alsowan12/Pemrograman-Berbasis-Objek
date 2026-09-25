package quizaplikasipesanantarmakanan;
// Arga Cahndra Wirawan
// Kelas TI-2G
// No. Absen 03
public class kurir {
    private String namaKurir;
    private String nomorKendaraan;
    private int tarif;          // tarif per km (Rupiah)
    private boolean tersedia;   // status ketersediaan kurir

    // Constructor
    public kurir(String namaKurir, String nomorKendaraan, int tarif) {
        this.namaKurir = namaKurir;
        this.nomorKendaraan = nomorKendaraan;
        this.tarif = tarif;
        this.tersedia = true;
    }

    // Hitung ongkos kirim berdasarkan jarak
    public int hitungOngkir(int jarakKm) {
        return tarif * jarakKm;
    }

    // Kurir mengambil pesanan
    public void ambilPesanan(pesanan p) {
        if (tersedia) {
            this.tersedia = false;
            System.out.println("  Kurir " + namaKurir + " (" + nomorKendaraan + ") mengambil Pesanan #" + p.getKodePesanan());
        } else {
            System.out.println("  Kurir " + namaKurir + " sedang tidak tersedia!");
        }
    }

    // Kurir selesai mengantar
    public void selesaiAntar() {
        this.tersedia = true;
        System.out.println("  Kurir " + namaKurir + " telah selesai mengantarkan pesanan.");
    }

    // Getter
    public String getNamaKurir() {
        return namaKurir;
    }

    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    public int getTarif() {
        return tarif;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    // Setter
    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public void tampilkanInfo() {
        System.out.println("  Kurir         : " + namaKurir);
        System.out.println("  No. Kendaraan : " + nomorKendaraan);
        System.out.println("  Tarif/km      : Rp " + tarif);
        System.out.println("  Status        : " + (tersedia ? "Tersedia" : "Sedang Bertugas"));
    }
}
