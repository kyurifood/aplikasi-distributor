package pusat.android.makananbekuenak.com.aplikasi_distributor.adapter;

import android.content.Context;
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

import pusat.android.makananbekuenak.com.aplikasi_distributor.MainActivity;
import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.Item_Pesanan;

/**
 * Created by opaw on 3/30/16.
 */
public class ListItemAdapterPesanan extends BaseAdapter {
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

        TextView no_order = (TextView) convertView.findViewById(R.id.no_order);
        TextView tanggal_pesan = (TextView) convertView.findViewById(R.id.tgl_pesan);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView bank = (TextView) convertView.findViewById(R.id.bank);
        TextView nominal = (TextView) convertView.findViewById(R.id.nominal);

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
