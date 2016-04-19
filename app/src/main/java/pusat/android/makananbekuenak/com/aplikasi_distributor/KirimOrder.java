package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class KirimOrder extends AppCompatActivity implements OnItemSelectedListener{

    Button btnKirim,btnPrs, btnCancel;
    EditText nmr, nama, market, nml, nomoResi;
    Spinner sp_pengirim, sp_demo;

    private String[] list = {"spinner 1", "spinner 2", "spinner 3", "spinner 4"};

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

        sp_demo = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_demo.setAdapter(adapter);
        sp_demo.setOnItemSelectedListener(this);

    }

    public void NotifikasiResi() {
        //
        final Dialog dialog = new Dialog(KirimOrder.this);
        dialog.setContentView(R.layout.kirim_order_noresi);
        dialog.setCancelable(true);
        dialog.setTitle("Kirim Order");

        nomoResi = (EditText)dialog.findViewById(R.id.nmrResi);
        btnPrs = (Button)dialog.findViewById(R.id.btnProses);
        btnCancel = (Button)dialog.findViewById(R.id.btnKembali);
        sp_pengirim = (Spinner) findViewById(R.id.l_pengiriman);
        dialog.show();


        btnPrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kode = nomoResi.getText().toString();

                if (!validasiResi(kode)) {
                    nomoResi.setError("Nomor Resi Tidak Valid");
                    {
                        Toast.makeText(KirimOrder.this, "Kesalahan Pengisian Nomor Resi", Toast.LENGTH_SHORT).show();
                    }
                } else cekResi();
            }

            private void cekResi() {
                Toast.makeText(KirimOrder.this, "Berhasil Memasukan Nomor Resi", Toast.LENGTH_SHORT).show();
                dialog.cancel();
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

    public boolean validasiResi(String kode) {
        return kode.length() > 10;
    }
    public void onItemSelected(AdapterView arg0, View arg1, int posisi,
                               long arg3) {
        Toast.makeText(KirimOrder.this, list[posisi].toString(), Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView arg0) {
        Toast.makeText(KirimOrder.this, "Tidak ada item yang terpilih", Toast.LENGTH_SHORT).show();
    }
}
