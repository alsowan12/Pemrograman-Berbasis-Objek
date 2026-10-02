package jobsheet6;

public class ClassBPercobaan2 extends ClassAPercobaan2 {
    private int z;

    public void setZ(int z ) {
        this.z = z;
    }
    public void getNilaiZ(){
        System.out.println("Nilai z :" + z);
    }
    public void getJumlah(){
        System.out.println("Jumlah :" + (getX() + getY() + z));
    }
}
