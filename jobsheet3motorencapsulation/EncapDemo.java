package jobsheet3motorencapsulation;

public class EncapDemo {
    private String nama;
    private int umur;

    public String getNama(){
        return nama;
    }

    public void setNama(String namaBaru){
        this.nama = namaBaru;

    }
    public int getUmur(){
        return umur;
    }
    public void setUmur(int newUmur)
    {
        if (newUmur > 30) {
            umur = 30;
        }
        else if (newUmur < 18) {
            umur = 18;
        }
        else{
            umur = newUmur;
        }
    }
}
