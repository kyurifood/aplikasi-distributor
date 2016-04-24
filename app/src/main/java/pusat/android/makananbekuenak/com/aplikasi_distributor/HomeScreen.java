package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity{

    Button btn_pesanan , btn_pengaturan , btn_laporan , btn_produk , btn_kotakmasuk;
    EditText bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        btn_pesanan = (Button) findViewById(R.id.pesanana);
        btn_pesanan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        btn_laporan = (Button) findViewById(R.id.laporan);
        btn_laporan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Kosong.class);
                startActivity(myIntent);
            }
        });

        btn_pengaturan = (Button) findViewById(R.id.pengaturan);
        btn_pengaturan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Pengaturan.class);
                startActivity(myIntent);
            }
        });

        btn_produk = (Button) findViewById(R.id.produk);
        btn_produk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Kosong.class);
                startActivity(myIntent);
            }
        });

        btn_kotakmasuk = (Button) findViewById(R.id.kotakmasuk);
        btn_kotakmasuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Kosong.class);
                startActivity(myIntent);
            }
        });
       // Intent intent = new Intent(this, LoginActivity.class);
       // startActivity(intent);
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
                pengaturan();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pengaturan (){
        Intent callme = new Intent(getApplicationContext(), Pengaturan.class);
        startActivity(callme);
    }

}
