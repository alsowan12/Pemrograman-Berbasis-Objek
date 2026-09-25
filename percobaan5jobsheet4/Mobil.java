package percobaan5jobsheet4;

public class Mobil {
    private String merek;
    private Mesin mesin;

    public Mobil(String merek){
        this.merek = merek;
        this.mesin = new Mesin();
    }
}
