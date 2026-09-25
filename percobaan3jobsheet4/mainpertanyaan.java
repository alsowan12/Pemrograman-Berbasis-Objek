package percobaan3jobsheet4;

public class mainpertanyaan {
    public static void main (String[] args){
        pegawai masinis = new pegawai ("1234", "Faren Santoso");
        keretaapi keretaapi = new keretaapi ("Gaya Baru", "Bisnis", masinis);
        System.out.println(keretaapi.info());
    }
}
