package jobsheet6;

public class MainPercobaan5 {
    public static void main(String[]args ){
        DekstopPercobaan5 desk = new DekstopPercobaan5("Dell", 2048, 3500, "Canon");
        LaptopPercobaan5 lap = new LaptopPercobaan5("Asus",4096,2500,720);

        desk.showInfo();
        System.out.println();
        lap.showInfo();
        System.out.println();
        desk.nyalakanKomputer();
    }
}
