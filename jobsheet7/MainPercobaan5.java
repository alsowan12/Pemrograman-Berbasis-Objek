package jobsheet7;

public class MainPercobaan5 {
    public static void main(String[] args ){
        Staff usman = new Staff ("0003", "Usman", "2", 10, 10000);
        Staff anugrah = new Staff ("0005", "Anugrah", "3", 5, 5000);

        Manager tedjo = new Manager("101", "Tedjo", "1", 5000000, "Adminitrasi", new Staff[] {usman, anugrah});
        tedjo.lihatInfo();

        System.out.println();
        System.out.println("Simulasi Lembur Usman 20 jam @ 15000 = " + (long) usman.getGaji(20, 15000));
    }
}
