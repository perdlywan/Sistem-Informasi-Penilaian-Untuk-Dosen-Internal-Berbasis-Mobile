package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class add_dosen_activity extends AppCompatActivity {
    AutoCompleteTextView txtStatusDosen,txtPendidikanDosen,txtJabatanDosen,txtGolonganDosen,txtProdiDosen;
    TextInputEditText txtKodeDosen,txtNidnDosen,txtNamaDosen,txttempatLahirDosen,txttanggalLahirDosen,txtalamatDosen,txtkelurahanDosen,
            txtkecamatanDosen,txtkotaDosen,txtprovinsiDosen,txtkodePosDosen,txtnomorHpDosen,
            txtBidangDosen;
    Button btn_simpanDosen;


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
        setContentView(R.layout.activity_add_dosen);

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
        btn_simpanDosen = findViewById(R.id.btnSimpanDosen);

        btn_simpanDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataDosen();
            }
        });

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

    private void insertDataDosen(){
        final String KodeDosen = txtKodeDosen.getText().toString().trim();
        final String Nidn = txtNidnDosen.getText().toString().trim();
        final String NamaDosen = txtNamaDosen.getText().toString().trim();
        final String TmptLahir = txttempatLahirDosen.getText().toString().trim();
        final String TglLahir = txttanggalLahirDosen.getText().toString().trim();
        final String Status = txtStatusDosen.getText().toString().trim();
        final String Alamat = txtalamatDosen.getText().toString().trim();
        final String Kelurahan = txtkelurahanDosen.getText().toString().trim();
        final String Kecamatan = txtkecamatanDosen.getText().toString().trim();
        final String Kota_Kab = txtkotaDosen.getText().toString().trim();
        final String Provinsi = txtprovinsiDosen.getText().toString().trim();
        final String KodePos = txtkodePosDosen.getText().toString().trim();
        final String NoHp = txtnomorHpDosen.getText().toString().trim();
        final String Pendidikan = txtPendidikanDosen.getText().toString().trim();
        final String JabatanAkademik = txtJabatanDosen.getText().toString().trim();
        final String Golongan = txtGolonganDosen.getText().toString().trim();
        final String Prodi = txtProdiDosen.getText().toString().trim();
        final String BidangKeahlian = txtBidangDosen.getText().toString().trim();

        ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");

        if(KodeDosen.isEmpty()){
            Toast.makeText(this,"Masukkan Kode Dosen", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Nidn.isEmpty()){
            Toast.makeText(this,"Masukkan Nidn", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(NamaDosen.isEmpty()){
            Toast.makeText(this,"Masukkan Nama Dosen", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TmptLahir.isEmpty()){
            Toast.makeText(this,"Masukkan Tempat Lahir", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TglLahir.isEmpty()){
            Toast.makeText(this,"Masukkan Tanggal Lahir", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Status.isEmpty()){
            Toast.makeText(this,"Masukkan Status", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Alamat.isEmpty()){
            Toast.makeText(this,"Masukkan Alamat", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Kelurahan.isEmpty()){
            Toast.makeText(this,"Masukkan Kelurahan", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Kecamatan.isEmpty()){
            Toast.makeText(this,"Masukkan Kecamatan", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Kota_Kab.isEmpty()){
            Toast.makeText(this,"Masukkan Kota / Kab", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Provinsi.isEmpty()){
            Toast.makeText(this,"Masukkan Provinsi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(KodePos.isEmpty()){
            Toast.makeText(this,"Masukkan Kode Pos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(NoHp.isEmpty()){
            Toast.makeText(this,"Masukkan Nomor Handphone", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Pendidikan.isEmpty()){
            Toast.makeText(this,"Masukkan Pendidikan", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(JabatanAkademik.isEmpty()){
            Toast.makeText(this,"Masukkan Jabatan Akademik", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Golongan.isEmpty()){
            Toast.makeText(this,"Masukkan Golongan", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(Prodi.isEmpty()){
            Toast.makeText(this,"Masukkan Program Studi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(BidangKeahlian.isEmpty()){
            Toast.makeText(this,"Masukkan Bidang Keahlian", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.SIMPAN_DOSEN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(add_dosen_activity.this, "Data dosen berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                DosenActivity.da.retrieveData();
                            }
                            else {
                                Toast.makeText(add_dosen_activity.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(add_dosen_activity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
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

            RequestQueue requestQueue = Volley.newRequestQueue(add_dosen_activity.this);
            requestQueue.add(request);
        }
    }
}