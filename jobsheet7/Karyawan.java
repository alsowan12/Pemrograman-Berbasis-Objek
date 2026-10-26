package jobsheet7;

public class Karyawan {
    protected String nip;
    protected String nama;
    protected String golongan;
    protected double gajiPokok;

    public Karyawan (String nip, String nama, String golongan) {
        this.nip = nip;
        this.nama = nama;
        this.golongan = golongan;
        this.gajiPokok = hitungGajiPokok(golongan);
    }

    private static double hitungGajiPokok(String golongan) {
        return switch (golongan) {
            case "1"-> 5000000;
            case "2"-> 3000000;
            case "3"-> 2000000;
            case "4"-> 1000000;
            case "5"-> 750000;
            default -> throw new IllegalArgumentException("Golongan tidak valid: " + golongan);

        };
    }
    public String getNama() {
        return nama;
    }
    public double getGaji() {
        return gajiPokok;
    }

    public void lihatInfo(){
        System.out.println("NIP          : " + nip);
        System.out.println("Nama         : " + nama);
        System.out.println("Golongan     : " + golongan);
        System.out.println("Gaji Pokok   : %.0f%n" + gajiPokok);
    }
}
