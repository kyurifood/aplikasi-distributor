package pusat.android.makananbekuenak.com.aplikasi_distributor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TampilanPribadi extends AppCompatActivity {

    Button edit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_data_pribadi_form);

        edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panggil();
            }
        });

    }

    public void panggil (){
        Intent callme = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_distributor.EditdataPribadi.class);
        startActivity(callme);
    }
}
