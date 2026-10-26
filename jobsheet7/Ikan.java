package jobsheet7;

public class Ikan {
    public void swim(){
        System.out.println(" Ikan Bisa Berenang ");
    }
    public Ikan beranak(){
        return new Ikan();
    }
}
