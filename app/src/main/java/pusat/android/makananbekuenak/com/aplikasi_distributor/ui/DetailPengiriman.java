package pusat.android.makananbekuenak.com.aplikasi_distributor.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import pusat.android.makananbekuenak.com.aplikasi_distributor.R;
import pusat.android.makananbekuenak.com.aplikasi_distributor.domain.Item_Pesanan;

public class DetailPengiriman extends Fragment {

	String get_resi, get_pengirim, get_namapenerima, get_tgl;
	private Item_Pesanan item_pesanan;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View preview = inflater.inflate(R.layout.detail_pengiriman, container, false);

		EditText pengirim = (EditText) preview.findViewById(R.id.pengiriman);
		EditText Noresi = (EditText) preview.findViewById(R.id.no_resi);
		EditText penerima = (EditText) preview.findViewById(R.id.penerima);
		EditText tgl = (EditText) preview.findViewById(R.id.tgl_penerima);

		Bundle bb = getActivity().getIntent().getExtras();

		get_resi = bb.getString("panggil_resi");
		get_pengirim = bb.getString("panggil_pengirim");
		get_namapenerima = bb.getString("panggil_nama");
		get_tgl = bb.getString("panggil_tgl");

		pengirim.setText("" + get_pengirim);
		Noresi.setText("" + get_resi);
		penerima.setText("" + get_namapenerima);
		tgl.setText("" + get_tgl);

	    return preview;
	}
}
