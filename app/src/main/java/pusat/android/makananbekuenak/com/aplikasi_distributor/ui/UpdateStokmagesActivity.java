package pusat.android.makananbekuenak.com.aplikasi_distributor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.adapter.UpdateStokBaseAdapter;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.UpdateStokItemDetails;

public class UpdateStokmagesActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestokmain);

		getSupportActionBar().setDisplayShowHomeEnabled(true);

		getSupportActionBar().setLogo(R.drawable.black_ic_shopping_bag);
		getSupportActionBar().setDisplayUseLogoEnabled(true);

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
    	item_details.setItemDescription("KARAPAO 4A");
    	item_details.setPrice("Rp 310.00");
    	item_details.setImageNumber(4);
    	results.add(item_details);
    	
    	item_details = new UpdateStokItemDetails();
    	item_details.setName("002");
    	item_details.setItemDescription("KARAPAO 4B");
    	item_details.setPrice("Rp 350.00");
    	item_details.setImageNumber(2);
    	results.add(item_details);

		item_details = new UpdateStokItemDetails();
		item_details.setName("003");
		item_details.setItemDescription("KARAPAO 6A");
		item_details.setPrice("Rp 350.00");
		item_details.setImageNumber(3);
		results.add(item_details);

		item_details = new UpdateStokItemDetails();
		item_details.setName("004");
		item_details.setItemDescription("KARAPAO 6B");
		item_details.setPrice("Rp 350.00");
		item_details.setImageNumber(1);
		results.add(item_details);

    	return results;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_registrasi, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_proses) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}