package quizaplikasipesanantarmakanan;
// Arga Chandra Wirawan 
// Kelas TI-2G
// No. Absen 03
public class pelanggan {
    private String namaPelanggan;
    private String nomorHP;
    private String alamatPengiriman;

    // Constructor
    public pelanggan(String namaPelanggan, String nomorHP, String alamatPengiriman) {
        this.namaPelanggan = namaPelanggan;
        this.nomorHP = nomorHP;
        this.alamatPengiriman = alamatPengiriman;
    }

    // Getter
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public String getAlamatPengiriman() {
        return alamatPengiriman;
    }

    // Setter
    public void setAlamatPengiriman(String alamatPengiriman) {
        this.alamatPengiriman = alamatPengiriman;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public void tampilkanInfo() {
        System.out.println("  Nama    : " + namaPelanggan);
        System.out.println("  No. HP  : " + nomorHP);
        System.out.println("  Alamat  : " + alamatPengiriman);
    }
}
