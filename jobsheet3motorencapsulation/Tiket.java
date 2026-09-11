package jobsheet3motorencapsulation;

public class Tiket {

    private String judulFilm;
    private double hargaDasar;
    private boolean statusPembayaran;

    public Tiket(String judulFilm, double hargaDasar) {
        this.judulFilm = judulFilm;

        if (hargaDasar < 0) {
            System.out.println("Peringatan: Harga tidak valid! Harga diset ke default Rp 35.000.");
            this.hargaDasar = 35000;
        } else {
            this.hargaDasar = hargaDasar;
        }
        this.statusPembayaran = false;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public double getHargaTiket() {
        return hargaDasar;
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }
    public void lakukanPembayaran() {
        if (statusPembayaran) {
            System.out.println("Tiket \"" + judulFilm + "\" sudah lunas sebelumnya.");
        } else {
            statusPembayaran = true;
            System.out.println("Pembayaran berhasil! Tiket \"" + judulFilm + "\" kini berstatus LUNAS.");
        }
    }
}
