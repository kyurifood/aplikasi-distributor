package pusat.android.makananbekuenak.com.aplikasi_distributor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.UpdateStokItemDetails;

public class UpdateStokBaseAdapter extends BaseAdapter {
	private static ArrayList<UpdateStokItemDetails> updateStokItemDetailsrrayList;
	
	private Integer[] imgid = {
			R.drawable.produk,
			R.drawable.karapao1,
			R.drawable.karapao2,
			R.drawable.karapao3,
			R.drawable.produk,
			R.drawable.produk
			};

	public LayoutInflater l_Inflater;

	public Context context;

	public UpdateStokBaseAdapter(Context context, ArrayList<UpdateStokItemDetails> results) {
		updateStokItemDetailsrrayList = results;
		l_Inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public int getCount() {
		return updateStokItemDetailsrrayList.size();
	}

	public Object getItem(int position) {
		return updateStokItemDetailsrrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.updatestok, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) convertView.findViewById(R.id.name);
			holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.itemDescription);
			holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.price);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.photo);
			holder.opsi = (Switch) convertView.findViewById(R.id.mySwitch);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txt_itemName.setText(updateStokItemDetailsrrayList.get(position).getName());
		holder.txt_itemDescription.setText(updateStokItemDetailsrrayList.get(position).getItemDescription());
		holder.txt_itemPrice.setText(updateStokItemDetailsrrayList.get(position).getPrice());
		holder.itemImage.setImageResource(imgid[updateStokItemDetailsrrayList.get(position).getImageNumber() - 1]);
		//---
		holder.opsi.setChecked(true);
		holder.opsi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				if (isChecked) {
					//ON
					Toast.makeText(context, updateStokItemDetailsrrayList.get(position).getName() + ", " + updateStokItemDetailsrrayList.get(position).getItemDescription() + ", Tersedia", Toast.LENGTH_LONG).show();
				} else {
					//OFF
					Toast.makeText(context, updateStokItemDetailsrrayList.get(position).getName() + ", " + updateStokItemDetailsrrayList.get(position).getItemDescription() + ", Tidak Tersedia", Toast.LENGTH_LONG).show();
				}


			}


		});//--

		return convertView;
	}

	static class ViewHolder {
		TextView txt_itemName;
		TextView txt_itemDescription;
		TextView txt_itemPrice;
		ImageView itemImage;
		Switch opsi;
	}
}
