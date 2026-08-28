package TugasPraktikum1;

public class TasMain {
    public static void main(String[] args) {
        Tas tas1 = new Tas();
        Tas tas2 = new Tas();
        TasCoach tas3 = new TasCoach();
        TasLaptop tas4 = new TasLaptop();

        tas1.setBrand("Torch");
        tas1.setMaxCapacity(25);
        tas1.setMaterial("Polyester");
        tas1.printInfo();

        tas2.setBrand("Elizabeth");
        tas2.setMaxCapacity(10);
        tas2.setMaterial("Kulit");
        tas2.printInfo();

        tas3.setBrand("Coach");
        tas3.setMaxCapacity(10);
        tas3.setMaterial("Kulit");
        tas3.setPrice(1500000);
        tas3.setColor("Hitam");
        tas3.printInfo();

        tas4.setBrand("Laptop");
        tas4.setMaxCapacity(20);
        tas4.setMaterial("Nylon");
        tas4.setLaptopsize(15);
        tas4.setTypeProtection("Anti Air");
        tas4.printInfo();

    }
}
