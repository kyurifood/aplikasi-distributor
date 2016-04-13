package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UpdateStokBaseAdapter extends BaseAdapter {
	private static ArrayList<UpdateStokItemDetails> updateStokItemDetailsrrayList;
	
	private Integer[] imgid = {
			R.drawable.produk,
			R.drawable.produk,
			R.drawable.produk,
			R.drawable.produk,
			R.drawable.produk,
			R.drawable.produk
			};
	
	private LayoutInflater l_Inflater;

	public UpdateStokBaseAdapter(Context context, ArrayList<UpdateStokItemDetails> results) {
		updateStokItemDetailsrrayList = results;
		l_Inflater = LayoutInflater.from(context);
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

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.updatestok, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) convertView.findViewById(R.id.name);
			holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.itemDescription);
			holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.price);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.photo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txt_itemName.setText(updateStokItemDetailsrrayList.get(position).getName());
		holder.txt_itemDescription.setText(updateStokItemDetailsrrayList.get(position).getItemDescription());
		holder.txt_itemPrice.setText(updateStokItemDetailsrrayList.get(position).getPrice());
		holder.itemImage.setImageResource(imgid[updateStokItemDetailsrrayList.get(position).getImageNumber() - 1]);

		return convertView;
	}

	static class ViewHolder {
		TextView txt_itemName;
		TextView txt_itemDescription;
		TextView txt_itemPrice;
		ImageView itemImage;
	}
}
