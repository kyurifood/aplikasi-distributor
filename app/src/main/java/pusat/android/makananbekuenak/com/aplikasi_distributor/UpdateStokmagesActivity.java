package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class UpdateStokmagesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestokmain);


        ArrayList<UpdateStokItemDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new UpdateStokBaseAdapter(UpdateStokmagesActivity.this, image_details));

        lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Object o = lv1.getItemAtPosition(position);
				UpdateStokItemDetails obj_UpdateStok_itemDetails = (UpdateStokItemDetails) o;
				Toast.makeText(UpdateStokmagesActivity.this, "You have chosen : " + " " + obj_UpdateStok_itemDetails.getName(), Toast.LENGTH_LONG).show();
			}
		});
    }

    private ArrayList<UpdateStokItemDetails> GetSearchResults(){
    	ArrayList<UpdateStokItemDetails> results = new ArrayList<UpdateStokItemDetails>();

    	UpdateStokItemDetails item_details = new UpdateStokItemDetails();
    	item_details.setName("001");
    	item_details.setItemDescription("Karapau Durian");
    	item_details.setPrice("Rp 310.00");
    	item_details.setImageNumber(1);
    	results.add(item_details);
    	
    	item_details = new UpdateStokItemDetails();
    	item_details.setName("002");
    	item_details.setItemDescription("Karapau Linux");
    	item_details.setPrice("Rp 350.00");
    	item_details.setImageNumber(2);
    	results.add(item_details);

		item_details = new UpdateStokItemDetails();
		item_details.setName("003");
		item_details.setItemDescription("satria biongo");
		item_details.setPrice("Rp 3250.00");
		item_details.setImageNumber(3);
		results.add(item_details);


    	return results;
    }
}