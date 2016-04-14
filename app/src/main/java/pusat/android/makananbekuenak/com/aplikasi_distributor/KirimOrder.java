package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KirimOrder extends AppCompatActivity {

    Button btnKirim,btnPrs, btnCancel;
    EditText nmr, nama, market, nml, nomoResi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirim_order);

        btnKirim = (Button) findViewById(R.id.btnSubmit);

        nmr = (EditText) findViewById(R.id.nmOrder);
        nama = (EditText) findViewById(R.id.nmPenerima);
        market = (EditText) findViewById(R.id.nmMarket);
        nml = (EditText) findViewById(R.id.nominal);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifikasiResi();
            }
        });
    }

    public void NotifikasiResi() {
        //
        final Dialog dialog = new Dialog(KirimOrder.this);
        dialog.setContentView(R.layout.kirim_order_noresi);
        dialog.setCancelable(true);
        dialog.setTitle("Masukan Nomor Resi");

        nomoResi = (EditText)dialog.findViewById(R.id.nmrResi);

        btnPrs = (Button)dialog.findViewById(R.id.btnProses);
        btnCancel = (Button)dialog.findViewById(R.id.btnKembali);
        dialog.show();

        btnPrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tombol Proses Order
                Toast.makeText(KirimOrder.this, "Berhasil Memasukan Nomor Resi", Toast.LENGTH_LONG).show();
                dialog.cancel();

                // Pindah Screen
                Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tombol Batal
                Toast.makeText(KirimOrder.this, "Anda Gagal Memasukan Nomor Resi", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
    }
}
