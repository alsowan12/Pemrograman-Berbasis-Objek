package TugasPraktikum1;

public class TasLaptop extends Tas {
    private int laptopSize;
    private String typeProtection;

    public void setLaptopsize(int ukuranLaptop) {
        laptopSize = ukuranLaptop;
    }

    public void setTypeProtection(String typeProtection) {
        this.typeProtection = typeProtection;
    }

    public int getLaptopsize() {
        return laptopSize;
    }

    public String getTypeProtection() {
        return typeProtection;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Laptop Size: " + laptopSize + " inches");
        System.out.println("Type Protection: " + typeProtection);
    }
}
