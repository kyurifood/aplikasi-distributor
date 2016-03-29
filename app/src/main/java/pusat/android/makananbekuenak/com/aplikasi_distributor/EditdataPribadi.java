package pusat.android.makananbekuenak.com.aplikasi_distributor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditdataPribadi extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdatapribadi);
    }

    public void submitProcess(View view)
    {
        Toast.makeText(this, "Submit Process!", Toast.LENGTH_SHORT).show();
    }

    public void CancelProcess(View view)
    {
        Toast.makeText(this, "Cancel Process!", Toast.LENGTH_SHORT).show();
    }
}