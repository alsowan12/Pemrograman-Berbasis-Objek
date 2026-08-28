package TugasPraktikum1;

public class Tas {
    private String brand;
    private int maxCapacity;
    private String material;

    public void setBrand(String brandName) {
        brand = brandName;
    }

    public void setMaxCapacity(int capacity) {
        maxCapacity = capacity;
    }

    public void setMaterial(String materialName) {
        material = materialName;
    }

    public void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Max Capacity: " + maxCapacity + " kg");
        System.out.println("Material: " + material);
    }

}