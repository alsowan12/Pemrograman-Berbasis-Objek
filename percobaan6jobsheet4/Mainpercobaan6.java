package percobaan6jobsheet4;

public class Mainpercobaan6 {
    public static void main(String[] args){
        Laptop laptop = new Laptop ("Thinkpad");
        Printer printer = new Printer ("Epson L3115");
        laptop.cetakDokumen(printer, "Laporan.pdf");
    }
}
