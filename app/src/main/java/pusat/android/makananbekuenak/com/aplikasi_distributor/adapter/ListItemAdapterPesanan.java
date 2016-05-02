package pusat.android.makananbekuenak.com.aplikasi_distributor.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_distributor.Lihatdetail;
import pusat.android.makananbekuenak.com.aplikasi_distributor.MainActivity;
import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.Item_Pesanan;

/**
 * Created by opaw on 3/30/16.
 */
public class ListItemAdapterPesanan extends BaseAdapter {

    String var_nama, var_tanggal, var_kode, var_bank, var_nominal, var_regional, var_distributor, var_marketer,
            var_costomer, var_nohp, var_alamatpenerima, var_produk, var_ongkir, var_pajak;
    public Context context;
    private List<Item_Pesanan> items;
    private int updatePos;

    public ListItemAdapterPesanan(Context context, List<Item_Pesanan> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item_Pesanan getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout_pesanan, parent, false);

        final Item_Pesanan item = items.get(position);

        final TextView no_order = (TextView) convertView.findViewById(R.id.no_order);
        final TextView tanggal_pesan = (TextView) convertView.findViewById(R.id.tgl_pesan);
        final TextView nama = (TextView) convertView.findViewById(R.id.nama);
        final TextView bank = (TextView) convertView.findViewById(R.id.bank);
        final TextView nominal = (TextView) convertView.findViewById(R.id.nominal);


        Button btnAction2 = (Button) convertView.findViewById(R.id.btn_detail);

        final ImageButton pop = (ImageButton) convertView.findViewById(R.id.btn_pop);
        final CheckBox lunas = (CheckBox) convertView.findViewById(R.id.cb_lunas);
        final CheckBox diterima = (CheckBox) convertView.findViewById(R.id.cb_diterima);
        diterima.setChecked(item.isDiterima());
        final CheckBox dikirim = (CheckBox) convertView.findViewById(R.id.cb_dikirim);
        dikirim.setChecked(item.isDikirim());

        no_order.setText(item.getNo_order());
        tanggal_pesan.setText(item.getTanggal_pesan());
        nama.setText(item.getNama());
        bank.setText(item.getBank());
        nominal.setText(item.getNominal());

//        btnAction1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lunas.setChecked(true);
//                if (lunas.isChecked()){
//                    pop.setEnabled(true);
//                    Toast.makeText(context, item.getNo_order() + ", Lunas",  Toast.LENGTH_SHORT).show();
//                }else {
//                    pop.setEnabled(false);
//                }
//            }
//        });

        //opsi menu
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final PopupMenu popup = new PopupMenu(context, pop);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                MenuItem mKirim = popup.getMenu().findItem(R.id.satu);
                MenuItem mItem = popup.getMenu().findItem(R.id.dua);
                if (dikirim.isChecked()){
                    mItem.setEnabled(true);
                    mKirim.setEnabled(false);

                }else {
                    mItem.setEnabled(false);
                }

                if (diterima.isChecked()){
                    mItem.setEnabled(false);
                }

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.satu:
                                    ((MainActivity) context).NotifikasiResi(item);
                                    updatePos = position;
                                    break;
                                case R.id.dua:
                                    ((MainActivity) context).UpdatePenerimaan(item);
                                    updatePos = position;
                                    break;
                                default:
                                    Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            return true;
                        }
                    });

                popup.show();
            }
        });
        //batas opsi menu

        btnAction2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                var_nama = nama.getText().toString();
                var_bank = bank.getText().toString();
                var_tanggal = tanggal_pesan.getText().toString();
                var_kode = no_order.getText().toString();
                var_nominal = nominal.getText().toString();
                var_regional = String.valueOf(item.getRegional());
                var_distributor = String.valueOf(item.getDistributor());
                var_marketer = String.valueOf(item.getMarketer());
                var_costomer = String.valueOf(item.getCustomer());
                var_nohp = String.valueOf(item.getNo_hp_penerima());
                var_alamatpenerima = String.valueOf(item.getAlamat_penerima());
                var_produk = String.valueOf(item.getProduk());
                var_ongkir = String.valueOf(item.getOngkir());
                var_pajak = String.valueOf(item.getPajak());


                Intent i = null;
                i = new Intent(context, Lihatdetail.class);
                Bundle b = new Bundle();

                b.putString("panggil_nama", var_nama);
                b.putString("panggil_bank", var_bank);
                b.putString("panggil_tanggal", var_tanggal);
                b.putString("panggil_kode", var_kode);
                b.putString("panggil_nominal", var_nominal);
                b.putString("panggil_regional", var_regional);
                b.putString("panggil_distributor", var_distributor);
                b.putString("panggil_marketer", var_marketer);
                b.putString("panggil_customer", var_costomer);
                b.putString("panggil_nohp", var_nohp);
                b.putString("panggil_alamat", var_alamatpenerima);
                b.putString("panggil_produk", var_produk);
                b.putString("panggil_ongkir", var_ongkir);
                b.putString("panggil_pajak", var_pajak);
                i.putExtras(b);
                context.startActivity(i);
            }
        });


        return convertView;
    }


    public void unselectAllItems(){
        for (int i = 0; i < items.size(); i++){
            Item_Pesanan item = items.get(i);
            item.setSelected(false);
        }
    }

    public void updateItem(Item_Pesanan item_pesanan){
        items.set(updatePos, item_pesanan);
        notifyDataSetChanged();
    }

    public void refreshList(){
        notifyDataSetChanged();
    }

    public void kirimOrder(){
        Item_Pesanan item = items.get(updatePos);
        item.setDikirim(true);
        items.set(updatePos, item);
        notifyDataSetChanged();
    }

    public void UpdataStatus(){
        Item_Pesanan item = items.get(updatePos);
        item.setDiterima(true);
        items.set(updatePos, item);
        notifyDataSetChanged();
    }
}
