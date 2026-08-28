package TugasPraktikum1;

public class TasCoach extends Tas {
    private int price;
    private String color;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
    }
}