package jobsheet9.Tugas;

public class MainTugas2 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();

        Destroyable[] listDestroyable = { wz, jz, b };

        for (int i = 0; i < 4; i++) {
            for (Destroyable d : listDestroyable) {
                p.doDestroy(d);
            }
        }

        for (Destroyable d : listDestroyable) {
            if (d instanceof Zombie) {
                Zombie z = (Zombie) d;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (d instanceof Barrier) {
                Barrier bar = (Barrier) d;
                System.out.println(bar.getBarrierInfo());
            }
        }
    }
}
