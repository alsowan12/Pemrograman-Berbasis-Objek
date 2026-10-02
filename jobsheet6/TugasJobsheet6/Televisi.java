package jobsheet6.TugasJobsheet6;

public class Televisi {
    private String merk;
    private int jumlahChannel;
    private int channelAktif;

    public Televisi(String merk, int jumlahChannel) {
        this.merk = merk;
        this.jumlahChannel = jumlahChannel;
        this.channelAktif = 1; // Channel aktif awal adalah 1
    }

    public void pindahChannel(int channel) {
        if (channel >= 1 && channel <= jumlahChannel) {
            this.channelAktif = channel;
        }
    }

    public int getChannelAktif() {
        return channelAktif;
    }
}