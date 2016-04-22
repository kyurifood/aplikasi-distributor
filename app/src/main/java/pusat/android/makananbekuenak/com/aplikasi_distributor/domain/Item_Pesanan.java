package pusat.android.makananbekuenak.com.aplikasi_distributor.domain;

/**
 * Created by rnl on 3/30/16.
 */
public class Item_Pesanan {
    private String no_order;
    private String tanggal_pesan;
    private String nama;
    private String bank;
    private String nominal;
    private boolean selected;
    private boolean button;
    private boolean button2;
    private boolean dikirim;

    public boolean isDiterima() {
        return diterima;
    }

    public void setDiterima(boolean diterima) {
        this.diterima = diterima;
    }

    private boolean diterima;


    public boolean isDikirim() {

        return dikirim;
    }

    public void setDikirim(boolean dikirim) {
        this.dikirim = dikirim;    }


    public boolean isButton2() {
        return button2;
    }

    public void setButton2(boolean button2) {
        this.button2 = button2;
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getTanggal_pesan() {
        return tanggal_pesan;
    }

    public void setTanggal_pesan(String tanggal_pesan) {
        this.tanggal_pesan = tanggal_pesan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
