package percobaan4jobsheet4;

public class gerbong {
    private String kode;
    private kursi[] arrayKursi;

    public gerbong(String kode, int jumlah) {
        this.kode = kode;
        this.arrayKursi = new kursi[jumlah];
        this.intKursi();
    }

    private void intKursi() {
        for (int i = 0; i < arrayKursi.length; i++) {
            arrayKursi[i] = new kursi(kode + "-" + i);
        }
    }

    public String getKode() {
        return kode;
    }

    // Memasukkan penumpang ke kursi berdasarkan nomor (dimulai dari 1)
    public void setPenumpang(penumpang penumpang, int nomor) {
        this.arrayKursi[nomor - 1].setPenumpang(penumpang);
    }

    public String info() {
        String info = "";
        info += "Kode : " + kode + "\n";
        for (kursi kursi : arrayKursi) {
            info += kursi.info();
        }
        return info;
    }
}