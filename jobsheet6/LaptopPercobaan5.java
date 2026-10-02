package jobsheet6;

public class LaptopPercobaan5 extends KomputerPercobaan5{
    protected int resolusiLayar;

    public LaptopPercobaan5(String merk, int memory, int cpu, int resolusi){
        super(merk, memory, cpu);
        this.resolusiLayar = resolusi;
    }

    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Resolusi Layar       : " + resolusiLayar + " p");
    }
}     

