package TugasPraktikum1;

public class LANCable {
    private int line;
    private String merk;
    private String kecepatan;
    private boolean koneksi = true;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(String kecepatan) {
        this.kecepatan = kecepatan;
    }

    public boolean getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(boolean koneksi) {
        this.koneksi = koneksi;
    }
}
