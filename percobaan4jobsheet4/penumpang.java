package percobaan4jobsheet4;

public class penumpang {
    private String ktp;
    private String nama;
public penumpang(String ktp, String nama){
    this.ktp = ktp;
    this.nama = nama;
}
    public String getKtp(){
        return ktp;
    }
    public String getNama(){
        return nama;
    }
    public String info(){
        String info ="";
        info += "Ktp:" + ktp + "\n";
        info += "Nama:" + nama + "\n";
        return info;
    }
}
