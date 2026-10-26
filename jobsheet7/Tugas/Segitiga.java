package jobsheet7.Tugas;
public class Segitiga {
    private int sudut;

    private void validasiSudut(int... sudutDiketahui) {
        int jumlah = 0;
        for (int s : sudutDiketahui) {
            if (s <= 0 || s >= 180) {
                throw new IllegalArgumentException("Sudut tidak valid: " + s);
            }
            jumlah += s;
        }
        if (jumlah <= 0 || jumlah >= 180) {
            throw new IllegalArgumentException("Jumlah sudut tidak valid: " + jumlah);
        }
    }

    // OVERLOADING: satu parameter
    public int sisaSudut(int sudutA) {
        validasiSudut(sudutA);
        sudut = 180 - sudutA;
        return sudut;
    }

    // OVERLOADING: dua parameter (jumlah parameter berbeda)
    public int sisaSudut(int sudutA, int sudutB) {
        validasiSudut(sudutA, sudutB);
        sudut = 180 - (sudutA + sudutB);
        return sudut;
    }

    // OVERLOADING: tiga parameter, kembalian int
    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    // OVERLOADING: dua parameter, kembalian double
    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt(sisiA * sisiA + sisiB * sisiB);
        return sisiA + sisiB + c;
    }

    public int getSudut() {
        return sudut;
    }
}

