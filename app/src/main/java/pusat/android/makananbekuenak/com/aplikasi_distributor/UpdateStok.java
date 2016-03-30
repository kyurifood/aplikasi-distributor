package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class UpdateStok extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatestok);
    }

    public void submitProcess(View view)
    {
        Toast.makeText(this, "Simpan Process!", Toast.LENGTH_SHORT).show();
    }

    public void CancelProcess(View view)
    {
        Toast.makeText(this, "KELUAR Process!", Toast.LENGTH_SHORT).show();
    }
}