package percobaan3jobsheet4;

public class mainpercobaan3 {
    public static void main(String[] args){
        pegawai masinis = new pegawai ("1234", "Faren Santoso");
        pegawai assistent = new pegawai("5678", "Patrick Bintang");
        keretaapi keretaapi= new keretaapi("Gaya Baru", "Bisnis", masinis, assistent);
        System.out.println(keretaapi.info());

    }
} 
