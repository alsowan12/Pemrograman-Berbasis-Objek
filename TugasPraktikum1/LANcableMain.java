package TugasPraktikum1;

public class LANcableMain {
    public static void main(String[] args) {
        LANCable kabel1 = new LANCable();

        kabel1.setLine(2);
        kabel1.setMerk("TP-Link");
        kabel1.setKecepatan("100 Mbps");
        kabel1.setKoneksi(true);
        System.out.println("Jumlah Line: " + kabel1.getLine());
        System.out.println("Merk: " + kabel1.getMerk());
        System.out.println("Kecepatan: " + kabel1.getKecepatan());
        System.out.println("Koneksi: " + kabel1.getKoneksi());

    }

}
