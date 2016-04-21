package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;

public class KirimOrder extends AppCompatActivity {

    Button btnKirim,btnPrs, btnCancel;
    EditText nomoResi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirim_order);

        btnKirim = (Button) findViewById(R.id.btnSubmit);

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
        dialog.setTitle("Kirim Order");

        nomoResi = (EditText)dialog.findViewById(R.id.nmrResi);
        btnPrs = (Button)dialog.findViewById(R.id.btnProses);
        btnCancel = (Button)dialog.findViewById(R.id.btnKembali);
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
}
