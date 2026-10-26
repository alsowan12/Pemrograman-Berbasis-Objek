package jobsheet9.Tugas;

public class MainTugas3 {
    public static void main(String[] args) {
        // Pernyataan 1: OK
        Zombie z = new WalkingZombie(100, 1);
        System.out.println("1. Zombie z = new WalkingZombie(100, 1); -> OK");

        // Pernyataan 2: OK
        Destroyable d = z;
        System.out.println("2. Destroyable d = z; -> OK");

        // Pernyataan 3: Error Kompilasi (uncomment untuk melihat compiler error)
        // Zombie z2 = d; // error: incompatible types: Destroyable cannot be converted to Zombie

        // Pernyataan 4: OK
        Zombie z3 = (Zombie) d;
        System.out.println("4. Zombie z3 = (Zombie) d; -> OK");

        // Pernyataan 5: Error Kompilasi (uncomment untuk melihat compiler error)
        // Zombie z4 = new Zombie(100, 1); // error: Zombie is abstract; cannot be instantiated

        // Pernyataan 6: Error Kompilasi (uncomment untuk melihat compiler error)
        // Destroyable d2 = new Plant(); // error: incompatible types: Plant cannot be converted to Destroyable

        // Pernyataan 7: OK
        Zombie z5 = new JumpingZombie(100, 2);
        System.out.println("7. Zombie z5 = new JumpingZombie(100, 2); -> OK");

        // Pernyataan 8: Error saat dijalankan (ClassCastException)
        try {
            WalkingZombie w = (WalkingZombie) z5;
            System.out.println("8. WalkingZombie w = (WalkingZombie) z5; -> OK");
        } catch (ClassCastException e) {
            System.out.println("8. WalkingZombie w = (WalkingZombie) z5; -> Runtime Error: " + e);
        }
    }
}
