package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pusat.android.makananbekuenak.com.aplikasi_distributor.KirimOrder;
import pusat.android.makananbekuenak.com.aplikasi_distributor.Pengaturan;

public class HomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Button pengaturan = (Button) findViewById(R.id.pengaturan);
        Button kirimorder = (Button) findViewById(R.id.pesanan);

        //--Pengaturan
        pengaturan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pengaturan.class);
                startActivity(intent);
            }
        });

        //Pesanan
        kirimorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent panggil_class = new Intent(getApplicationContext(), KirimOrder.class);
                startActivity(panggil_class);
            }
        });

        //--Produk

        //Laporan

        //Kotak Masuk
    }
}