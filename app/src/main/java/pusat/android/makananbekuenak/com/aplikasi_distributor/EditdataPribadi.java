package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pusat.android.makananbekuenak.com.aplikasi_distributor.adapter.ListItemDistributor;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.ItemDistributor;

public class EditdataPribadi extends AppCompatActivity {

    ListView lvItem;
    ListItemDistributor adapter;

    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;

    private Spinner spinnerbank;



    EditText txtkode, txtnama, txthp, txtalamat, txtkodepos, txtemail, txtrek, txtpemilik, txtcabang ;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    List<ItemDistributor> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdatapribadi);


        txtemail = (EditText) findViewById(R.id.editemail);
        txtkode = (EditText) findViewById(R.id.editkode);
        txtnama = (EditText) findViewById(R.id.editnama);
        txthp = (EditText) findViewById(R.id.edithp);
        txtalamat = (EditText) findViewById(R.id.editalamat);
        txtkodepos = (EditText) findViewById(R.id.editkodepos);
        Spinner mSpinner= (Spinner)findViewById(R.id.spinregional);
        Spinner pSpinner= (Spinner)findViewById(R.id.spinprov);
        Spinner kSpinner= (Spinner)findViewById(R.id.spinkec);
        Spinner lSpinner= (Spinner)findViewById(R.id.spinkel);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        pSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        kSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        lSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());

        lvItem = (ListView) findViewById(R.id.lv_item);
        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams) lvItem.getLayoutParams();
        listViewParams.height = 835;
        lvItem.requestLayout();

        lvItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        Button btndaf = (Button)findViewById(R.id.btndaf);
        btndaf.setOnClickListener(new View.OnClickListener() {

            public void onClick(View rootView) {

//                String s = (String)(spinregional.getSelectedItem());
//                set(s);
//                String s = (String)(spinregional.getSelectedItem());
//                selection.setText(s);


                String email = txtemail.getText().toString();
                String kode = txtkode.getText().toString();
                String nama = txtnama.getText().toString();
                String hp = txthp.getText().toString();
                String alamat = txtalamat.getText().toString();
                String kodepos = txtkodepos.getText().toString();

                if (!validateKode(kode)) {
                    txtkode.setError("silahkan masukan kode");
                    {

                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian kode", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validateNama(nama)) {
                    txtnama.setError("silahkan masukan nama anda");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian nama", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validateEmail(email)) {
                    txtemail.setError("silahkan masukan email");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian email", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validateHp(hp)) {
                    txthp.setError("silahkan masukan nomor hand phone");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian phone", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validateAlamat(alamat)) {
                    txtalamat.setError("silahkan masukan alamat anda");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian alamat", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validateKodepos(kodepos)) {
                    txtkodepos.setError("silahkan masukan kode pos");
                    {
                        Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian kode pos", Toast.LENGTH_SHORT).show();
                    }

                } else submitForm();
            }
        });

        Button addNewItem = (Button) findViewById(R.id.btnbank);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
    }

    public void showAddDialog() {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditdataPribadi.this, R.style.DialogStyle);
        }

        promptsView = LayoutInflater.from(EditdataPribadi.this).inflate(R.layout.bank_distributor, null);

        final Spinner mSpinner= (Spinner) promptsView.findViewById(R.id.spinnerbank);
        txtrek = (EditText) promptsView.findViewById(R.id.editText);
        txtpemilik = (EditText) promptsView.findViewById(R.id.editText2);
        txtcabang = (EditText) promptsView.findViewById(R.id.editText3);
        spinnerbank = (Spinner) promptsView.findViewById(R.id.spinnerbank);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                if (!hasError()) {
                    ItemDistributor item = new ItemDistributor();
                    String s = (String)(spinnerbank.getSelectedItem());
                    item.setBank(s);
                    item.setRekening(txtrek.getText().toString());
                    item.setPemilik(txtpemilik.getText().toString());
                    item.setCabang(txtcabang.getText().toString());

                    if (adapter == null) {
                        items.add(item);
                        adapter = new ListItemDistributor(EditdataPribadi.this, items);
                        lvItem.setAdapter(adapter);
                    } else {
                        adapter.addItem(item);
                    }
                    addNewItemDialog.dismiss();
                }
            }
        });

        Button cancel = (Button) promptsView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItemDialog.dismiss();
            }
        });

        addNewItemDialogBuilder.setView(promptsView);
        addNewItemDialogBuilder.setCancelable(false);
        addNewItemDialog = addNewItemDialogBuilder.create();
        addNewItemDialog.show();
    }




    private void submitForm() {
        // Submit your form here. your form is valid
        Toast.makeText(EditdataPribadi.this, "Data Berasil", Toast.LENGTH_SHORT).show();

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean validateKode(String kode) {
        return kode.length() > 0;
    }
    public boolean validateNama(String nama) {
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
    private boolean hasError(){
        boolean isError = false;
        if(TextUtils.isEmpty(txtrek.getText().toString())){
            isError = true;
            txtrek.setError("This field is required");
        }
        if(TextUtils.isEmpty(txtpemilik.getText().toString())){
            isError = true;
            txtpemilik.setError("This field is required");
        }
        if(TextUtils.isEmpty(txtcabang.getText().toString())){
            isError = true;
            txtcabang.setError("This field is required");
        }
        return isError;
    }

    public class OnSpinnerItemClicked implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        }


        public void onNothingSelected(AdapterView parent) {
            // Do nothing.


        }
    }
}