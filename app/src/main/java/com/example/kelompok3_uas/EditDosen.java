package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class EditDosen extends AppCompatActivity {
    AutoCompleteTextView txtStatusDosen,txtPendidikanDosen,txtJabatanDosen,txtGolonganDosen,txtProdiDosen;
    TextInputEditText txtKodeDosen,txtNidnDosen,txtNamaDosen,txttempatLahirDosen,txttanggalLahirDosen,txtalamatDosen,txtkelurahanDosen,
            txtkecamatanDosen,txtkotaDosen,txtprovinsiDosen,txtkodePosDosen,txtnomorHpDosen,
            txtBidangDosen;
    Button btn_UpdateDosen;
    private int position;

    String[] items = {"Belum Menikah","Menikah","Duda/Janda"};

    AutoCompleteTextView autoCompleteTextTxt;

    ArrayAdapter<String> adapterItems;


    String[] items2 = {"S1","S2","S3"};

    AutoCompleteTextView autoCompleteTextTxt2;

    ArrayAdapter<String> adapterItems2;


    String[] items3 = {"Asisten Ahli","Lektor","Lektor Kepala","Guru Besar"};

    AutoCompleteTextView autoCompleteTextTxt3;

    ArrayAdapter<String> adapterItems3;


    String[] items4 = {"III A","III B","III C","III D","IV A","IV B","IV C","IV D"};

    AutoCompleteTextView autoCompleteTextTxt4;

    ArrayAdapter<String> adapterItems4;


    String[] items5 = {"Teknik Informatika","Sistem Informasi","Sistem Komputer"};

    AutoCompleteTextView autoCompleteTextTxt5;

    ArrayAdapter<String> adapterItems5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_dosen);

        txtKodeDosen = findViewById(R.id.ed1Dosen);
        txtNidnDosen = findViewById(R.id.ed2Dosen);
        txtNamaDosen = findViewById(R.id.ed3Dosen);
        txttempatLahirDosen = findViewById(R.id.ed4Dosen);
        txttanggalLahirDosen = findViewById(R.id.ed5Dosen);
        txtStatusDosen = findViewById(R.id.autoCompleteTextViewDosen);
        txtalamatDosen = findViewById(R.id.ed6Dosen);
        txtkelurahanDosen = findViewById(R.id.ed7Dosen);
        txtkecamatanDosen = findViewById(R.id.ed8Dosen);
        txtkotaDosen = findViewById(R.id.ed9Dosen);
        txtprovinsiDosen = findViewById(R.id.ed10Dosen);
        txtkodePosDosen = findViewById(R.id.ed11Dosen);
        txtnomorHpDosen = findViewById(R.id.ed12Dosen);
        txtPendidikanDosen = findViewById(R.id.autoCompleteTextView2Dosen);
        txtJabatanDosen = findViewById(R.id.autoCompleteTextView3Dosen);
        txtGolonganDosen = findViewById(R.id.autoCompleteTextView4Dosen);
        txtProdiDosen = findViewById(R.id.autoCompleteTextView5Dosen);
        txtBidangDosen = findViewById(R.id.ed13Dosen);
        btn_UpdateDosen = findViewById(R.id.btnUpdateDosen);

        btn_UpdateDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDataDosen();
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        txtKodeDosen.setText(DosenActivity.dosenArrayList.get(position).getKodeDosen());
        txtNidnDosen.setText(DosenActivity.dosenArrayList.get(position).getNidn());
        txtNamaDosen.setText(DosenActivity.dosenArrayList.get(position).getNamaDosen());
        txttempatLahirDosen.setText(DosenActivity.dosenArrayList.get(position).getTmptLahir());
        txttanggalLahirDosen.setText(DosenActivity.dosenArrayList.get(position).getTglLahir());
        txtStatusDosen.setText(DosenActivity.dosenArrayList.get(position).getStatus());
        txtalamatDosen.setText(DosenActivity.dosenArrayList.get(position).getAlamat());
        txtkelurahanDosen.setText(DosenActivity.dosenArrayList.get(position).getKelurahan());
        txtkecamatanDosen.setText(DosenActivity.dosenArrayList.get(position).getKecamatan());
        txtkotaDosen.setText(DosenActivity.dosenArrayList.get(position).getKota_Kab());
        txtprovinsiDosen.setText(DosenActivity.dosenArrayList.get(position).getProvinsi());
        txtkodePosDosen.setText(DosenActivity.dosenArrayList.get(position).getKodePos());
        txtnomorHpDosen.setText(DosenActivity.dosenArrayList.get(position).getNoHp());
        txtPendidikanDosen.setText(DosenActivity.dosenArrayList.get(position).getPendidikan());
        txtJabatanDosen.setText(DosenActivity.dosenArrayList.get(position).getJabatanAkademik());
        txtGolonganDosen.setText(DosenActivity.dosenArrayList.get(position).getGolongan());
        txtProdiDosen.setText(DosenActivity.dosenArrayList.get(position).getProdi());
        txtBidangDosen.setText(DosenActivity.dosenArrayList.get(position).getBidangKeahlian());

        autoCompleteTextTxt = findViewById(R.id.autoCompleteTextViewDosen);

        adapterItems = new ArrayAdapter<>(this,R.layout.dropdown_item,items);

        autoCompleteTextTxt.setAdapter(adapterItems);


        autoCompleteTextTxt2 = findViewById(R.id.autoCompleteTextView2Dosen);

        adapterItems2 = new ArrayAdapter<>(this,R.layout.dropdown_item,items2);

        autoCompleteTextTxt2.setAdapter(adapterItems2);


        autoCompleteTextTxt3 = findViewById(R.id.autoCompleteTextView3Dosen);

        adapterItems3 = new ArrayAdapter<>(this,R.layout.dropdown_item,items3);

        autoCompleteTextTxt3.setAdapter(adapterItems3);


        autoCompleteTextTxt4 = findViewById(R.id.autoCompleteTextView4Dosen);

        adapterItems4 = new ArrayAdapter<>(this,R.layout.dropdown_item,items4);

        autoCompleteTextTxt4.setAdapter(adapterItems4);


        autoCompleteTextTxt5 = findViewById(R.id.autoCompleteTextView5Dosen);

        adapterItems5 = new ArrayAdapter<>(this,R.layout.dropdown_item,items5);

        autoCompleteTextTxt5.setAdapter(adapterItems5);
    }

    public void updateDataDosen() {
        String KodeDosen = txtKodeDosen.getText().toString();
        String Nidn = txtNidnDosen.getText().toString();
        String NamaDosen = txtNamaDosen.getText().toString();
        String TmptLahir = txttempatLahirDosen.getText().toString();
        String TglLahir = txttanggalLahirDosen.getText().toString();
        String Status = txtStatusDosen.getText().toString();
        String Alamat = txtalamatDosen.getText().toString();
        String Kelurahan = txtkelurahanDosen.getText().toString();
        String Kecamatan = txtkecamatanDosen.getText().toString();
        String Kota_Kab = txtkotaDosen.getText().toString();
        String Provinsi = txtprovinsiDosen.getText().toString();
        String KodePos = txtkodePosDosen.getText().toString();
        String NoHp = txtnomorHpDosen.getText().toString();
        String Pendidikan = txtPendidikanDosen.getText().toString();
        String JabatanAkademik = txtJabatanDosen.getText().toString();
        String Golongan = txtGolonganDosen.getText().toString();
        String Prodi = txtProdiDosen.getText().toString();
        String BidangKeahlian = txtBidangDosen.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.EDIT_DOSEN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EditDosen.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),DosenActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditDosen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("KodeDosen",KodeDosen);
                params.put("Nidn",Nidn);
                params.put("NamaDosen",NamaDosen);
                params.put("TmptLahir",TmptLahir);
                params.put("TglLahir",TglLahir);
                params.put("Status",Status);
                params.put("Alamat",Alamat);
                params.put("Kelurahan",Kelurahan);
                params.put("Kecamatan",Kecamatan);
                params.put("Kota_Kab",Kota_Kab);
                params.put("Provinsi",Provinsi);
                params.put("KodePos",KodePos);
                params.put("NoHp",NoHp);
                params.put("Pendidikan",Pendidikan);
                params.put("JabatanAkademik",JabatanAkademik);
                params.put("Golongan",Golongan);
                params.put("Prodi",Prodi);
                params.put("BidangKeahlian",BidangKeahlian);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditDosen.this);
        requestQueue.add(request);
    }
}