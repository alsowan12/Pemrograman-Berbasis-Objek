package jobsheet3motorencapsulation;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();

        encap.setNama("Rizal Pasha");
        encap.setUmur(35);

        System.out.println("Nama:" + encap.getNama());
        System.out.println("Umur:" + encap.getUmur());
    }
}
