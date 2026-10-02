package jobsheet6;

public class DekstopPercobaan5 extends KomputerPercobaan5 {
    protected String printer;

    public DekstopPercobaan5(String merk, int memory, int cpu, String printer){
        super(merk, memory, cpu);
        this.printer = printer;
    }
    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Printer              : " + printer);
    }
}
