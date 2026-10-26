package jobsheet7;

public class MainPercobaan4 {
    public static void main (String [] args ){
        Ikan a = new Ikan();
        Piranha c = new Piranha();

        a.swim();
        c.swim();

        Piranha anak = c.beranak();
        System.out.println(" Tipe objek anak: " + anak.getClass().getSimpleName());
    }
}
