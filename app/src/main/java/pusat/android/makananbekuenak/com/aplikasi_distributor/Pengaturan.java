package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Pengaturan extends AppCompatActivity{

    Button b_info, b_password, b_notifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pengaturan);

        b_info = (Button) findViewById(R.id.info_pribadi);
        b_password = (Button) findViewById(R.id.ganti_password);
        b_notifikasi = (Button) findViewById(R.id.notifkasi);


        b_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callme = new Intent(getApplicationContext(), TampilanPribadi.class);
                startActivity(callme);
            }

        });

        b_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b_notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}