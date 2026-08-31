Percobaan 3.1
Pada percobaan pertama pada jobsheet 1 ini membuat package BikeDemo dengan class Bike dan juga membuat class main source code seperti dibawah 
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

Source code BikeDemoMain:
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

Hasil dari percobaan 3.1:
Brand :Trek
Speed: 5
Gear:2
Brand :Giant
Speed: 5
Gear:3
Brand :Specialized
Speed: 5
Gear:4

Percobaan 3.2
 pada percobaan kali ini saya membuat class baru yang bernama RoadBike yang merupakan subclass dari class Bike. source code RoadBike sebagai berikut:
public class RoadBike extends Bike{
    private int tireWidth;
    
}
kemudian pada class BikeDemoMain saya menambahkan source code RoadBike:
public class RoadBike extends Bike {
    private int tireWidth;

    public void setTireWidth(int width) {
        tireWidth = width;
    }

    @Override
    public void printinfo() {
        super.printinfo();
        System.out.println("Tire Width : " + tireWidth + "mm");
        System.out.println("Bike Type : Road Bike");
    }

}

Hasil percobaan 3.2:
Brand :Trek
Speed: 5
Gear:2
Brand :Giant
Speed: 5
Gear:3
Brand :Specialized
Speed: 5
Gear:4
Tire Width : 25mm
Bike Type : Road Bike

Pertanyaan!
1. Jelaskan perbedaan antara object dengan class!
Jawaban: Class merupakan cetak biru atau template sedangkan object merupakan wujud nyata dari class tersebut
2. Jelaskan alasan gear dan brand dapat menjadi atribut dari object Bike!
Jawaban: Gear dan brand adalah atribut karena merupakan karakteristik yang dimiliki oleh object Bike
3. Sebutkan salah satu kelebihan utama dari pemrograman berorientasi objek dibandingkan
dengan pemrograman prosedural!
Jawaban: Salah satu kelebihan utama dari pemrograman berorientasi objek adalah kemampuannya untuk mengelola kompleksitas program melalui enkapsulasi dan modularitas
4. Apakah diperbolehkan melakukan pendefinisian dua buah atribut dalam satu baris kode seperti
“public String nama, alamat;”?
Jawaban: Ya, diperbolehkan mendefinisikan dua buah atribut dalam satu baris kode
5. Pada class RoadBike, jelaskan alasan atribut brand, speed, dan gear tidak lagi ditulis di dalam
class tersebut!
Jawaban: Atribut brand, speed, dan gear tidak lagi ditulis di dalam class RoadBike karena sudah mewarisi dari class Bike