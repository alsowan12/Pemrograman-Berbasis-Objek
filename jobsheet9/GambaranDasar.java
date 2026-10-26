package jobsheet9;

public class GambaranDasar {
    interface Vegetarian{ }
    static class Animal { }
    static class Deer extends Animal implements Vegetarian { }
    static class Lion extends Animal { }

    public static void main(String[] args ){
        Deer d = new Deer();
        Lion l = new Lion();
     
        Animal a = d;
        Animal a2 = l;
        Vegetarian v = d;

        System.out.println(" a Menunjuk Objek " + a.getClass().getSimpleName());
        System.out.println(" a2 Menunjuk Objek " + a2.getClass().getSimpleName());
        System.out.println(" v Menunjuk Objek " + v.getClass().getSimpleName());

    }
}
