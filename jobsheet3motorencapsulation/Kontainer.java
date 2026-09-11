package jobsheet3motorencapsulation;

public class Kontainer {
    // Private fields (encapsulation)
    private String noResi;
    private String namaPemilik;
    private double kapasitasMaksimal;
    private double muatanSaatini;

    // Constructor
    public Kontainer(String noResi, String namaPemilik, double kapasitasMaksimal) {
        this.noResi = noResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.muatanSaatini = 0;
    }

    public String getResi() {
        return noResi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public double getMuatanSaatini() {
        return muatanSaatini;
    }

    public void tambahMuatan(double berat) {
        if (muatanSaatini + berat > kapasitasMaksimal) {
            System.out.println("Peringatan: Melebihi kapasitas! Muatan tidak ditambahkan.");
        } else {
            muatanSaatini += berat;
        }
    }

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
}
