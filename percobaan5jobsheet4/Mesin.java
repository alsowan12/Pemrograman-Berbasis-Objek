package percobaan5jobsheet4;

public class Mesin {
    private String tipe;

    public Mesin(){
        this.tipe = "4-Silinder";
    }
    public String getTipe(){
        return this.tipe;
    }
    public void tampilkanInfo(){
        System.out.println("Mobil :" + merek);
        System.out.println("Mesin :" + getTipe());
    }
    
} 
