package jobsheet6;

public class KomputerPercobaan5 {
    protected String merk;
    protected int kapasitasMemory;
    protected int kecepatanCPU;

    public KomputerPercobaan5(String merk, int memory, int cpu) {
        this.merk = merk;
        this.kapasitasMemory = memory;
        this.kecepatanCPU = cpu;
    }
    public void showInfo(){
        System.out.println("Merk                 : " + merk);
        System.out.println("Kapasitas Memory     : " + kapasitasMemory + " GB");
        System.out.println("Kecepatan CPU        : " + kecepatanCPU + " MHz");
    }
    public void nyalakanKomputer(){
        System.out.println("Komputer merk "+merk+" dinyalakan");
    }
}
