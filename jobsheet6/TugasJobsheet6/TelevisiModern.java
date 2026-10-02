package jobsheet6.TugasJobsheet6;

public class TelevisiModern extends Televisi{
    private String modeTampilan;
    private String dvd;

    public TelevisiModern(String merk, int jumlahChannel) {
        super(merk, jumlahChannel);
        this.dvd = "Kosong";
    }

    public void gantiModusTampilan(String mode) {
        this.modeTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD() {
        System.out.println("Sedang memainkan DVD" + dvd);
    }
}
