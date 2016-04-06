package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditdataPribadi extends AppCompatActivity {

    TextView hasilbank;
    EditText txtkode, txtnama, txthp, txtalamat, txtkodepos, txtemail;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    String get_rek,get_pemilik, get_cabang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdatapribadi);
        Button btnbank = (Button) findViewById(R.id.btnbank);
        Button btnok = (Button) findViewById(R.id.btnok);
        hasilbank = (TextView) findViewById(R.id.hasilbank);
        txtemail = (EditText) findViewById(R.id.editemail);
        txtkode = (EditText) findViewById(R.id.editkode);
        txtnama = (EditText) findViewById(R.id.editnama);
        txthp = (EditText) findViewById(R.id.edithp);
        txtalamat = (EditText) findViewById(R.id.editalamat);
        txtkodepos = (EditText) findViewById(R.id.editkodepos);

        //btnok.setOnClickListener(this);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtemail.getText().toString();
                String kode = txtkode.getText().toString();
                String nama = txtnama.getText().toString();
                String hp = txthp.getText().toString();
                String alamat = txtalamat.getText().toString();
                String kodeppos = txtkodepos.getText().toString();


                if (!validateKode(kode))
                {
                    txtkode.setError("silahkan masukan kode");{

                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian kode",
                            Toast.LENGTH_LONG).show();
                }
                }

                else if (!validateNama(nama))
                {
                    txtnama.setError("silahkan masukan nama anda");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian nama",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else if (!validateEmail(email))
                {
                    txtemail.setError("silahkan masukan email");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian email",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else if (!validateHp(hp))
                {
                    txthp.setError("silahkan masukan nomor hand phone");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian phone",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else if (!validateAlamat(alamat))
                {
                    txtalamat.setError("silahkan masukan almat anda");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian alamat",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else if (!validateKodepos(kodeppos))
                {
                    txtkodepos.setError("silahkan masukan kode pos");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian kode pos",
                                Toast.LENGTH_LONG).show();
                    }

                }else submitForm();


            }
//                if (checkValidation())
//                    submitForm();
//                else
//                    Toast.makeText(RegistrasiMarketer.this, "Kesalahan dalam pengisian",
//                            Toast.LENGTH_LONG).show();

//            Bundle b = getIntent().getExtras();
//
//            get_rek = b.getString("parse_rekening");
//            get_pemilik = b.getString("parse_pemilik");
//            get_cabang = b.getString("parse_cabang");
//
//
//            hasilbank.setText("rekenng : " + get_rek + "pemilik :" + get_pemilik + "cabang" + get_cabang);



        });

        btnbank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pusat.android.makananbekuenak.com.aplikasi_distributor.R.class);
                startActivity(intent);
            }
        });

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if ((requestCode==99)&&(requestCode==RESULT_OK)){
            String pesan = data.getStringExtra("dataterima");
        }
    }

    private void submitForm() {
        // Submit your form here. your form is valid
        Toast.makeText(this, "registrasi berhasil", Toast.LENGTH_LONG).show();
    }

    public boolean validateEmail(String email) {matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean validateKode(String kode) {
        return kode.length() > 0;
    }
    public boolean validateNama(String nama)
    {
        return nama.length() > 0;
    }
    public boolean validateHp(String hp) {
        return hp.length() > 0;
    }
    public boolean validateAlamat(String alamat) {
        return alamat.length() > 0;
    }
    public boolean validateKodepos(String kodepos) {
        return kodepos.length() > 0;
    }


}
