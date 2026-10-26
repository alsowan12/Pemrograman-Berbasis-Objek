package jobsheet7.Tugas;

public class Dosen extends Manusia {
    @Override
    public void makan() {
        super.makan();
        System.out.println("Dosen makan di kantin fakultas");
    }

    public void lembur() {
        System.out.println("Dosen lembur menilai ujian");
    }
}