package percobaan2jobsheet4;

public class mainpercobaan2{
    public static void main(String[] args) {
        mobil m = new mobil();
        m.setMerk ("Avanza");
        m.setBiaya(350000);

        sopir s = new sopir();
        s.setNama("John Doe");
        s.setBiaya(200000);

        pelanggan p = new pelanggan();
        p.setNama("John Doe");
        p.setMobil(m);
        p.setSopir(s);
        p.setHari(2);
        System.out.println("Biaya Total = " + p.hitungBiayaTotal());
    }
}