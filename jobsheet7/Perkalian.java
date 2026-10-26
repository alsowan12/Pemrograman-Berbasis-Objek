package jobsheet7;

public class Perkalian {
    public int kali(int a, int b){
        return a * b;
    }
    public int kali (int a, int b, int c){
        return a * b * c;
    }
    public double kali(double a, double b){
        return a * b;
    }
    public void tampilkan(int nomor, String label){
        System.out.println(nomor + ". " + label);
    }
    public void tampilkan(String label, int nomor){
        System.out.println(label + "# " + nomor);
    }
}
