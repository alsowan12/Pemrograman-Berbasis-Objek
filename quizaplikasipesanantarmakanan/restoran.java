package quizaplikasipesanantarmakanan;

// Arga Chandra Wirawan 
// Kelas TI-2G
// No. Absen 03
import java.util.ArrayList;

public class restoran {
    private String namaResto;
    private String alamat;
    private int jarakTempuh; // dalam kilometer
    private ArrayList<makanan> daftarMenu;

    // Constructor
    public restoran(String namaResto, String alamat, int jarakTempuh) {
        this.namaResto = namaResto;
        this.alamat = alamat;
        this.jarakTempuh = jarakTempuh;
        this.daftarMenu = new ArrayList<>();
    }

    // Tambah menu ke restoran
    public void tambahMenu(makanan m) {
        daftarMenu.add(m);
        System.out.println("Menu '" + m.getNamaMakanan() + "' berhasil ditambahkan ke " + namaResto);
    }

    // Cari makanan berdasarkan nama
    public makanan cariMakanan(String nama) {
        for (makanan m : daftarMenu) {
            if (m.getNamaMakanan().equalsIgnoreCase(nama)) {
                return m;
            }
        }
        return null;
    }

    // Tampilkan semua menu
    public void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("  MENU - " + namaResto.toUpperCase());
        System.out.println("  Alamat: " + alamat);
        System.out.println("==============================");
        if (daftarMenu.isEmpty()) {
            System.out.println("  (Belum ada menu)");
        } else {
            for (int i = 0; i < daftarMenu.size(); i++) {
                System.out.print("  " + (i + 1) + ". ");
                daftarMenu.get(i).tampilkanInfo();
            }
        }
        System.out.println("==============================\n");
    }

    // Getter
    public String getNamaResto() {
        return namaResto;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getJarakTempuh() {
        return jarakTempuh;
    }

    public ArrayList<makanan> getDaftarMenu() {
        return daftarMenu;
    }

    // Setter
    public void setJarakTempuh(int jarakTempuh) {
        this.jarakTempuh = jarakTempuh;
    }
}
