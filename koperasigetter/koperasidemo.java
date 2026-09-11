package koperasigetter;

public class koperasidemo {
    public static void main (String[] args ){
        Anggotta anggotta1 = new Anggotta("Faren Afanda", "Nganjuk"); 
        System.out.println("Simpanan" + anggotta1.getNama() + " : Rp. " + anggotta1.getSimpanan());
        anggotta1.setNama("Faren Afanda");
        anggotta1.setAlamat("Nganjuk");
        anggotta1.setor(10000);
        System.out.println("Simpanan" + anggotta1.getNama()+ " : Rp. " + anggotta1.getSimpanan());
        anggotta1.pinjam(1000);
        System.out.println("Simpanan" + anggotta1.getNama()+ " : Rp. " + anggotta1.getSimpanan());  
        
    }
    
}
