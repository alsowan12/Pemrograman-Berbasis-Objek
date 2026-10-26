package jobsheet7.Tugas;
public class MainTugas2 {
    public static void main(String[] args) {
        Manusia manusia = new Manusia();
        Dosen dosen = new Dosen();
        Mahasiswa mhs = new Mahasiswa();

        System.out.println("== Manusia ==");
        manusia.bernafas();
        manusia.makan();

        System.out.println("== Dosen ==");
        dosen.bernafas();
        dosen.makan();
        dosen.lembur();

        System.out.println("== Mahasiswa ==");
        mhs.bernafas();
        mhs.makan();
        mhs.tidur();
    }
}