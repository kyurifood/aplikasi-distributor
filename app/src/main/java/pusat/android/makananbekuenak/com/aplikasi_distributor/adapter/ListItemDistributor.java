package pusat.android.makananbekuenak.com.aplikasi_distributor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.RegistrasiDistributor;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.ItemDistributor;

/**
 * Created by rinaldy on 07/04/16.
 */
public class ListItemDistributor extends BaseAdapter {
    private Context context;
    private List<ItemDistributor> items;


    public ListItemDistributor(Context context, List<ItemDistributor> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items == null)
            return -1;
        else
            return items.size();
    }

    @Override
    public ItemDistributor getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent ) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);

        final ItemDistributor item = items.get(position);

        TextView bank = (TextView)convertView.findViewById(R.id.list_item_bank);
        TextView rekening = (TextView)convertView.findViewById(R.id.list_item_rekening);
        TextView pemilik = (TextView)convertView.findViewById(R.id.list_item_nama);
        TextView cabang = (TextView)convertView.findViewById(R.id.list_item_cabang);

        bank.setText(item.getBank());
        rekening.setText(item.getRekening());
        pemilik.setText(item.getPemilik());
        cabang.setText(item.getCabang());

        final Button delete = (Button)convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                deleteItem(position);
            }
        });

        Button edit = (Button) convertView.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegistrasiDistributor) context).showEditDialog(position, item);
            }
        });

        return convertView;
    }

    public void addItem(ItemDistributor item){
        items.add(item);
        notifyDataSetChanged();
    }
    public void editItem(int position, ItemDistributor item){
        items.set(position, item);
        notifyDataSetChanged();
    }

    public void deleteItem(int position){
        items.remove(position);
        notifyDataSetChanged();
    }

}

