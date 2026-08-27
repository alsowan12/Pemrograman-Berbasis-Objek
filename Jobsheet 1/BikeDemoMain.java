public class BikeDemoMain {
    public static void main(String[] args) {
        Bike mountainke1 = new Bike();
        Bike mountainke2 = new Bike();
        RoadBike roadbike1 = new RoadBike();

        mountainke1.setBrand("Trek");
        mountainke1.speedAcceleration(10);
        mountainke1.gearChages(+2);
        mountainke1.printinfo();

        mountainke2.setBrand("Giant");
        mountainke2.speedAcceleration(20);
        mountainke2.gearChages(3);
        mountainke2.printinfo();

        roadbike1.setBrand("Specialized");
        roadbike1.speedAcceleration(15);
        roadbike1.gearChages(4);
        roadbike1.setTireWidth(25);
        roadbike1.printinfo();
    }

}
