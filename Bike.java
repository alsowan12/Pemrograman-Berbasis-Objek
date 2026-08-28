public class Bike {
    private String brand;
    private int speed;
    private int gear = 1;
    // gear 1; masuk 5km/h, gear 2; masuk 10km/h, ... gear 6; max 60km/h
    private final int[] GEAR_SPEED_LIMITS = { 5, 10, 25, 30, 40, 50, 60 };

    public void setBrand(String brandName) {
        brand = brandName;
    }

    public void gearChages(int gearValue) {
        if (gearValue < 1 || gearValue > 6) {
            System.out.println("invalid gear value. Gear must be between 1 and 6");
        } else {
            gear = gearValue;
        }
    }

    public int speedAcceleration(int increment) {
        speed += increment;
        if (speed > GEAR_SPEED_LIMITS[gear - 1]) {
            speed = GEAR_SPEED_LIMITS[gear - 1];
        }
        return speed;
    }

    public int speedDecalariton(int decrement) {
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        return speed;

    }

    public void printinfo() {
        System.out.println("Brand :" + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Gear:" + gear);
    }
}