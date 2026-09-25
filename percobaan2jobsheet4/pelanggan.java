package percobaan2jobsheet4;

public class pelanggan {
    private String nama;
    private mobil mobil;
    private sopir sopir;
    private int hari;

    public pelanggan(){
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }

    public void setMobil(mobil mobil){
        this.mobil = mobil;
    }
    public mobil getMobil(){
        return mobil;
    }

    public void setSopir(sopir sopir){
        this.sopir = sopir;
    }
    public sopir getSopir(){
        return sopir;
    }
    public void setHari(int hari){
        this.hari = hari;
    }
    public int getHari(){
        return hari;
    }

    public int hitungTotalBiaya(){
        return hari;
        
    }
    public int hitungBiayaTotal(){
        return mobil.hitungBiayaMobil(hari) + sopir.hitungBiayaSopir(hari);
    }
}
