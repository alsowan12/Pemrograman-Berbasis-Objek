package percobaan2jobsheet4;

public class sopir {
    private String nama;
    private int biaya;

    public sopir(){
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void setBiaya(int biaya){
        this.biaya = biaya;
    }
    public int getBiaya(){
        return biaya;
    }
    public int hitungBiayaSopir(int hari){
        return hari*biaya;
    }
}
