package jobsheet7;

public class Manager extends Karyawan {
    private double tunjangan;
    private String bagian;
    private Staff[] bawahan;

    public Manager (String nip, String nama, String golongan, double tunjangan, String bagian, Staff[] bawahan){
        super(nip, nama, golongan);
        this.tunjangan = tunjangan;
        this.bagian = bagian;
        this.bawahan = bawahan;
    }
    
    @Override
    public double getGaji() {
        return super.getGaji() + tunjangan;
    }

    public void viewStaff(){
        System.out.println("----------------------------------------");
        for (Staff s : bawahan) {
            s.lihatInfo();
            System.out.println("--------------------------------------");
        }
    }
    @Override 
    public void lihatInfo() { 
        System.out.println("Manager        :" + bagian);
        super.lihatInfo();
        System.out.printf("Tunjangan      : %.0f%n", tunjangan);
        viewStaff();
    }
}
