package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Pengaturan extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pengaturan);
    }

    //panggil class info data pribadi
    public void btn_info(View view){

        Intent panggil_class = new Intent(getApplicationContext(), TampilanPribadi.class);
        startActivity(panggil_class);
    }
}