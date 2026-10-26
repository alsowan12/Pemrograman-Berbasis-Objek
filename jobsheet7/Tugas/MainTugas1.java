package jobsheet7.Tugas;
public class MainTugas1 {
    public static void main(String[] args) {
        Segitiga t = new Segitiga();
        System.out.println("Jumlah dua sudut lain : " + t.sisaSudut(60));
        System.out.println("Sudut ketiga : " + t.sisaSudut(60, 50));
        System.out.println("Keliling 3, 4, 5 : " + t.keliling(3, 4, 5));
        System.out.println("Keliling siku 3, 4 : " + t.keliling(3, 4));
        System.out.println("Keliling siku 5, 12 : " + t.keliling(5, 12));
    }
}

