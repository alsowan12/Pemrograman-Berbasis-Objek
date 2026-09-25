package percobaan3jobsheet4;

public class pegawai {
    private String nip;
    private String nama;
public pegawai(String nip, String nama) {
    this.nip = nip;
    this.nama = nama;
}
public void setNip(String nip) {
    this.nip = nip;
}

public String getNip() {
    return nip;
}

public void setNama(String nama) {
    this.nama = nama;
}

public String getNama() {
    return nama;
}
public String info(){
    String info = "";
    info += "NIP       : "+getNip();
    info += "Nama      : "+getNama();
    return info;
}
}

