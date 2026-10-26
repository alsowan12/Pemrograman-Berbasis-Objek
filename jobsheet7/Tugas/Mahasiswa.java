package jobsheet7.Tugas;
public class Mahasiswa extends Manusia {
    @Override
    public void makan() {
        System.out.println("Mahasiswa makan di kantin kampus");
    }

    public void tidur() {
        System.out.println("Mahasiswa tidur di perpustakaan");
    }
}