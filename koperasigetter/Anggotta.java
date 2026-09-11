package koperasigetter;

public class Anggotta {
    private String nama;
    private String alamat;
    private float simpanan;
Anggotta(String nama, String alamat){
    this.nama = nama;
    this.alamat = alamat;
    this.simpanan = simpanan;
}

public void setNama(String nama){
    this.nama = nama;
}
public void setAlamat(String nama){
    this.alamat = alamat;
}
public String getNama(){
    return nama;
}
public String getAlamat(){
    return alamat;
}
public float getSimpanan(){
    return simpanan;
}
public void setor(float uang){
    simpanan += uang;
}
public void pinjam(float uang){
    simpanan -= uang;
}

    
}
