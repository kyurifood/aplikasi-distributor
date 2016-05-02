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
    private String regional;
    private String distributor;
    private String marketer;
    private String customer;
    private String no_hp_penerima;
    private String alamat_penerima;
    private String produk;
    private String ongkir;
    private String pajak;private boolean dikirim;
    private boolean diterima;
    private boolean lunas;

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getMarketer() {
        return marketer;
    }

    public void setMarketer(String marketer) {
        this.marketer = marketer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getNo_hp_penerima() {
        return no_hp_penerima;
    }

    public void setNo_hp_penerima(String no_hp_penerima) {
        this.no_hp_penerima = no_hp_penerima;
    }

    public String getAlamat_penerima() {
        return alamat_penerima;
    }

    public void setAlamat_penerima(String alamat_penerima) {
        this.alamat_penerima = alamat_penerima;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getOngkir() {
        return ongkir;
    }

    public void setOngkir(String ongkir) {
        this.ongkir = ongkir;
    }

    public String getPajak() {
        return pajak;
    }

    public void setPajak(String pajak) {
        this.pajak = pajak;}


    public boolean isLunas() {
        return lunas;
    }

    public void setLunas(boolean lunas) {
        this.lunas = lunas;
    }

    public boolean isDiterima() {
        return diterima;
    }

    public void setDiterima(boolean diterima) {
        this.diterima = diterima;
    }


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
