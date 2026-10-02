package jobsheet6.TugasJobsheet6;

public class MainTugas1 {
    public static void main (String [] args){
        DaftarGaji daftarGaji = new DaftarGaji(2);

        Pegawai p1 = new Pegawai("P001", "Budi", "Malang");
        Dosen d1 = new Dosen ("D001", "Siti", "Banyuwangi");
        d1.setSKS(12);
        daftarGaji.addPegawai(p1);
        daftarGaji.addPegawai(d1);

        daftarGaji.printSemuaGaji();
    }
}
