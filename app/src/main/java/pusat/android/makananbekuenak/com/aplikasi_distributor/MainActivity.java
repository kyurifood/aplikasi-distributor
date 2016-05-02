package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_distributor.adapter.ListItemAdapterPesanan;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.Item_Pesanan;

public class MainActivity extends AppCompatActivity {

    int mYear,mMonth, mDay;
    static final int DATE_DIALOG_ID = 1;
    private String[] arrMonth = {"Januari","Februari","Maret","April","Mei","Juni","Juli","Augustus","September","Oktober","November","Desember"};
    public ProgressDialog pDialog;
    DatePickerDialog datePicker;
    ListView lvItem;
    ListItemAdapterPesanan adapter;
    Button btnPrs,btnCancel, btnKirim, btnBatal;
    EditText nomoResi, penerima, tgl_penerima;
    Spinner modeKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.black_ic_trolley);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        List<Item_Pesanan> items = new ArrayList<>();
        Item_Pesanan item1 = new Item_Pesanan();
        item1.setNo_order("001");
        item1.setTanggal_pesan("15-04-2016");
        item1.setNama("Reksin Lewo");
        item1.setBank("Mandiri");
        item1.setRegional("Bogor");
        item1.setMarketer("reka");
        item1.setDistributor("eton");
        item1.setCustomer("gilang");
        item1.setNo_hp_penerima("0975447223");
        item1.setAlamat_penerima("jongol");
        item1.setProduk("karapau");
        item1.setOngkir("12.000");
        item1.setPajak("10.000");
        item1.setNominal("20000");
        item1.setDikirim(false);

        Item_Pesanan item2 = new Item_Pesanan();
        item2.setNo_order("002");
        item2.setTanggal_pesan("15-05-2016");
        item2.setNama("Alfandi");
        item2.setBank("Mandiri");
        item2.setRegional("jakarta");
        item2.setDistributor("ismet");
        item2.setMarketer("aldy");
        item2.setCustomer("satria");
        item2.setNo_hp_penerima("975447223");
        item2.setAlamat_penerima("gorontalo");
        item2.setProduk("karapau-A4");
        item2.setOngkir("13.000");
        item2.setPajak("12.000");
        item2.setNominal("26000");
        item2.setDikirim(false);

        Item_Pesanan item3 = new Item_Pesanan();
        item3.setNo_order("003");
        item3.setTanggal_pesan("15-05-2016");
        item3.setNama("Angki Nusi");
        item3.setBank("Mandiri");
        item3.setRegional("gorontalo");
        item3.setDistributor("rahama");
        item3.setMarketer("afni");
        item3.setCustomer("yetri");
        item3.setNo_hp_penerima("2265347223");
        item3.setAlamat_penerima("makasar");
        item3.setProduk("kyurifoot");
        item3.setOngkir("10.000");
        item3.setPajak("9.000");
        item3.setNominal("32000");
        item3.setDikirim(false);

        items.add(item1);
        items.add(item2);
        items.add(item3);


        lvItem = (ListView) findViewById(R.id.lv_item);
        adapter = new ListItemAdapterPesanan(MainActivity.this, items);

        lvItem.setAdapter(adapter);

//        lvItem.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//            @Override
//            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//                Item_Pesanan item = (Item_Pesanan) lvItem.getAdapter().getItem(position);
//                item.setSelected(checked);
//            }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                MenuInflater inflater = getMenuInflater();
//                inflater.inflate(R.menu.menu_list_item, menu);
//                mode.setTitle("Select Items");
//                return true;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_submit:
//                        StringBuilder sb = new StringBuilder();
//                        for(int i = 0; i < lvItem.getAdapter().getCount(); i++){
//                            Item_Pesanan x = (Item_Pesanan) lvItem.getAdapter().getItem(i);
//                            if(x.isSelected()){
//                                sb.append(x.getNo_order());
//                                sb.append(", ");
//                            }
//                        }
//                        String text = sb.toString();
//                        text = text.substring(0, text.length() - 2);
//                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//                        mode.finish();
//                        break;
//                    default:
//                        Toast.makeText(MainActivity.this, "Clicked " + item.getTitle(),
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//                adapter.unselectAllItems();
//            }
//        });
    }

    public void NotifikasiResi(final Item_Pesanan item) {
        //---
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setContentView(R.layout.kirim_order_noresi);
        dialog.setCancelable(true);
        dialog.setTitle("Kirim Order");
        dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.ic_mode_edit_black_24dp);

        modeKirim = (Spinner) dialog.findViewById(R.id.l_pengiriman);
        nomoResi = (EditText)dialog.findViewById(R.id.nmrResi);
        btnPrs = (Button)dialog.findViewById(R.id.btn_Proses);
        btnCancel = (Button)dialog.findViewById(R.id.btnKembali);
        dialog.show();

        modeKirim.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "Pilihan Pegiriman : " + modeKirim.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnPrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kode = nomoResi.getText().toString();

                if (!validasiResi(kode)) {
                    nomoResi.setError("Nomor Resi Tidak Valid");
                    {
                        Toast.makeText(MainActivity.this, "Kesalahan Pengisian Nomor Resi", Toast.LENGTH_SHORT).show();
                    }

                } else cekResi();
            }

            private void cekResi() {
                adapter.kirimOrder();
                Toast.makeText(
                        MainActivity.this, "Berhasil : No.Resi " + nomoResi.getText() + " Pengiriman : " + String.valueOf(modeKirim.getSelectedItem()), Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tombol Batal
                Toast.makeText(MainActivity.this, "Anda Gagal Memasukan Nomor Resi", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
    }

    public void UpdatePenerimaan(final Item_Pesanan item){

        //---
        final Dialog tampil = new Dialog(MainActivity.this);
        tampil.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        tampil.setContentView(R.layout.update_status_penerimaan);
        tampil.setCancelable(true);
        tampil.setTitle("Update Status Penerimaan");
        tampil.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.ic_border_color_black_18dp);

        penerima = (EditText) tampil.findViewById(R.id.nmPenerima);
        tgl_penerima = (EditText) tampil.findViewById(R.id.tgl_penerimaan);
        btnBatal = (Button)tampil.findViewById(R.id.btnBtl);
        btnKirim = (Button)tampil.findViewById(R.id.btnKirim);

        //penerima.setText(item.getNama());
        //tgl_penerima.setText(item.getTanggal_pesan());

        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        tampil.show();

        tgl_penerima.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tgl = tgl_penerima.getText().toString();
                String nama = penerima.getText().toString();

                if (!validasiNama(nama)) {
                    penerima.setError("Wajib Diisi..!!!");
                    {
                        Toast.makeText(MainActivity.this, "Kesalahan Penginputan Data", Toast.LENGTH_SHORT).show();
                    }
                } else if (!validasiTgl(tgl)) {
                    tgl_penerima.setError("Wajib Diisi");
                    {
                        Toast.makeText(MainActivity.this, "Kesalahan Penginputan Tanggal", Toast.LENGTH_SHORT).show();
                    }

                } else cekData();
            }

            private void cekData() {
                adapter.UpdataStatus();
                //((ListItemAdapterPesanan) lvItem.getAdapter()).refreshList();
                //item.setNama(penerima.getText().toString());
                //item.setTanggal_pesan(tgl_penerima.getText().toString());
                //adapter.updateItem(item);
                        Toast.makeText(
                        MainActivity.this, "Berhasil : Penerima " + penerima.getText() +
                                ", Tanggal Penerimaan : " + tgl_penerima.getText(), Toast.LENGTH_LONG).show();
                tampil.cancel();
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tombol Batal
                Toast.makeText(MainActivity.this, "Update Status Dibatalkan", Toast.LENGTH_LONG).show();
                tampil.cancel();
            }
        });


    }

    public boolean validasiResi(String kode) {
        return kode.length() > 9;
    }

    public boolean validasiNama(String nama) {
        return nama.length() > 0;
    }

    public boolean validasiTgl(String tgl) {
        return tgl.length() > 0;
    }




    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                datePicker = new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
                datePicker.setOnCancelListener(mDateCancelListener);
                return datePicker;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0", 2) + ", " + mYear;
                    tgl_penerima.setText(sdate);
                }
            };

    private DatePickerDialog.OnCancelListener mDateCancelListener = new DatePickerDialog.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialog) {
            Calendar today = Calendar.getInstance();
           // tgl_penerima.setText("May 05, 2016");
             /*
            String sdate = arrMonth[today.getTime().getMonth()] + " " + LPad(today.getTime().getDay()+ "", "0", 2) + ", " + today.getTime()
                    .getYear();
            tgl_penerima.setText(sdate);*/
        }
    };

    private static String LPad(String schar, String spad, int len) {
        String sret = schar;
        for (int i = sret.length(); i < len; i++) {
            sret = spad + sret;
        }
        return new String(sret);
    }



}
