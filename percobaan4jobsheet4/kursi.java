package percobaan4jobsheet4;

public class kursi {
    private String nomor;
    private penumpang penumpang;

    public kursi(String nomor) {
        this.nomor = nomor;
    }

    public void setPenumpang(penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public penumpang getPenumpang() {
        return penumpang;
    }

    public String info() {
        String info = "";
        info += "Nomor : " + nomor + "\n";
        if (this.penumpang != null) {
            info += "Penumpang : " + penumpang.info() + "\n";
        }
        return info;
    }
}
