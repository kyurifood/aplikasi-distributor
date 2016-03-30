package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void btn_pengaturan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_distributor.Pengaturan.class);
        startActivity(panggil_class);
    }

    public void btn_pesanan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_distributor.KirimOrder.class);
        startActivity(panggil_class);
    }

    public void btn_laporan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_distributor.Laporan.class);
        startActivity(panggil_class);
    }

}
