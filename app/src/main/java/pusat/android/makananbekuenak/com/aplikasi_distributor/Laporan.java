package pusat.android.makananbekuenak.com.aplikasi_distributor;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Laporan extends AppCompatActivity {

    Button b_produk, b_distributor, b_marketer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);

        b_distributor = (Button) findViewById(R.id.btn_distributor);
        b_marketer = (Button) findViewById(R.id.btn_marketer);
        b_produk = (Button) findViewById(R.id.btn_produk);

        b_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b_marketer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b_distributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}