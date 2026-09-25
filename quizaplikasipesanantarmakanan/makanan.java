package quizaplikasipesanantarmakanan;
// Arga Chandra Wirawan 
// Kelas TI-2G
// No. Absen 03
public class makanan {
    private String namaMakanan;
    private int harga;
    private String kategori;

    // Constructor
    public makanan(String namaMakanan, int harga, String kategori) {
        this.namaMakanan = namaMakanan;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Constructor overload (tanpa kategori)
    public makanan(String namaMakanan, int harga) {
        this.namaMakanan = namaMakanan;
        this.harga = harga;
        this.kategori = "Umum";
    }

    // Getter
    public String getNamaMakanan() {
        return namaMakanan;
    }

    public int getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    // Setter
    public void setHarga(int harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid!");
        }
    }

    public void tampilkanInfo() {
        System.out.println("  [" + kategori + "] " + namaMakanan + " - Rp " + harga);
    }
}
