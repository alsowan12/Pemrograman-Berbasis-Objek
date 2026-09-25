package percobaan3jobsheet4;

public class keretaapi {
    private String nama;
    private String kelas;
    private pegawai masinis;
    private pegawai assistent;
public keretaapi(String nama, String kelas, pegawai masinis){
    this.nama = nama;
    this.kelas = kelas;
    this.masinis = masinis;
}
public keretaapi (String nama, String kelas, pegawai masinis, pegawai assistent){
    this.nama = nama;
    this.kelas = kelas;
    this.masinis = masinis;
    this.assistent = assistent;
}
public void setmasinis(pegawai masinis){
    this.masinis = masinis;
}
public pegawai getmasinis(){
    return masinis;
}
public void setassitent(pegawai assistent){
    this.assistent = assistent;
}
public String info(){
    String info = "";
    info += "Nama: " + this.nama + "\n";
    info += "Kelas: " + this.kelas + "\n";
    info += "Masinis: " + this.masinis.info() + "\n";
    info += "Asisten: " + this.assistent.info() + "\n";
    if (this.assistent != null){
        info += "Asisten: " + this.assistent.info() + "\n";
    }
    return info;
}
}


