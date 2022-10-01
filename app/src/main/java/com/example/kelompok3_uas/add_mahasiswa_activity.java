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

public class add_mahasiswa_activity extends AppCompatActivity {

    AutoCompleteTextView txtStatus,txtPendidikan,txtProdi;
    TextInputEditText txtnim,txtnama,txttempatLahir,txttanggalLahir,txtalamat,txtkecamatan,txtkota,txtprovinsi,txtkodePos,txtnomorHp;
    Button btn_simpan;

    String[] items = {"Belum Menikah","Menikah","Duda/Janda"};

    AutoCompleteTextView autoCompleteTextTxt;

    ArrayAdapter<String> adapterItems;


    String[] items2 = {"SMA","SMK","Paket C"};

    AutoCompleteTextView autoCompleteTextTxt2;

    ArrayAdapter<String> adapterItems2;


    String[] items3 = {"Teknik Informatika","Sistem Informasi","Sistem Komputer"};

    AutoCompleteTextView autoCompleteTextTxt3;

    ArrayAdapter<String> adapterItems3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_mahasiswa);

        txtnim = findViewById(R.id.ed1);
        txtnama = findViewById(R.id.ed2);
        txttempatLahir = findViewById(R.id.ed3);
        txttanggalLahir = findViewById(R.id.ed4);
        txtStatus = findViewById(R.id.autoCompleteTextView);
        txtalamat = findViewById(R.id.ed6);
        txtkecamatan = findViewById(R.id.ed7);
        txtkota = findViewById(R.id.ed8);
        txtprovinsi = findViewById(R.id.ed9);
        txtkodePos = findViewById(R.id.ed10);
        txtnomorHp = findViewById(R.id.ed11);
        txtPendidikan = findViewById(R.id.autoCompleteTextView2);
        txtProdi = findViewById(R.id.autoCompleteTextView3);
        btn_simpan = findViewById(R.id.btnSimpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });


        autoCompleteTextTxt = findViewById(R.id.autoCompleteTextView);

        adapterItems = new ArrayAdapter<>(this,R.layout.dropdown_item,items);

        autoCompleteTextTxt.setAdapter(adapterItems);


        autoCompleteTextTxt2 = findViewById(R.id.autoCompleteTextView2);

        adapterItems2 = new ArrayAdapter<>(this,R.layout.dropdown_item,items2);

        autoCompleteTextTxt2.setAdapter(adapterItems2);


        autoCompleteTextTxt3 = findViewById(R.id.autoCompleteTextView3);

        adapterItems3 = new ArrayAdapter<>(this,R.layout.dropdown_item,items3);

        autoCompleteTextTxt3.setAdapter(adapterItems3);

    }

    private void insertData(){
        final String nim = txtnim.getText().toString().trim();
        final String nama = txtnama.getText().toString().trim();
        final String tempatLahir = txttempatLahir.getText().toString().trim();
        final String tanggalLahir = txttanggalLahir.getText().toString().trim();
        final String status = txtStatus.getText().toString().trim();
        final String alamat = txtalamat.getText().toString().trim();
        final String kecamatan = txtkecamatan.getText().toString().trim();
        final String kota = txtkota.getText().toString().trim();
        final String provinsi = txtprovinsi.getText().toString().trim();
        final String kodePos = txtkodePos.getText().toString().trim();
        final String noHp = txtnomorHp.getText().toString().trim();
        final String pendidikan = txtPendidikan.getText().toString().trim();
        final String prodi = txtProdi.getText().toString().trim();

        ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");

        if(nim.isEmpty()){
            Toast.makeText(this,"Masukkan Nim", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(nama.isEmpty()){
            Toast.makeText(this,"Masukkan Nama Lengkap", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(tempatLahir.isEmpty()){
            Toast.makeText(this,"Masukkan Tempat Lahir", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(tanggalLahir.isEmpty()){
            Toast.makeText(this,"Masukkan Tanggal Lahir", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(status.isEmpty()){
            Toast.makeText(this,"Masukkan Status", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(alamat.isEmpty()){
            Toast.makeText(this,"Masukkan Alamat", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(kecamatan.isEmpty()){
            Toast.makeText(this,"Masukkan Kecamatan", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(kota.isEmpty()){
            Toast.makeText(this,"Masukkan Kota / Kabupaten", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(provinsi.isEmpty()){
            Toast.makeText(this,"Masukkan Provinsi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(kodePos.isEmpty()){
            Toast.makeText(this,"Masukkan Kode Pos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(noHp.isEmpty()){
            Toast.makeText(this,"Masukkan Nomor Handphone", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pendidikan.isEmpty()){
            Toast.makeText(this,"Masukkan Pendidikan Terakhir", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(prodi.isEmpty()){
            Toast.makeText(this,"Masukkan Program Studi", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.SIMPAN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(add_mahasiswa_activity.this, "Data mahasiswa berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                mahasiswaActivity.mo.retrieveData();
                            }
                            else {
                                Toast.makeText(add_mahasiswa_activity.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(add_mahasiswa_activity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nim",nim);
                    params.put("nama_mahasiswa",nama);
                    params.put("tempat_lahir",tempatLahir);
                    params.put("tanggal_lahir",tanggalLahir);
                    params.put("status",status);
                    params.put("alamat",alamat);
                    params.put("kecamatan",kecamatan);
                    params.put("kota_kab",kota);
                    params.put("provinsi",provinsi);
                    params.put("kode_pos",kodePos);
                    params.put("no_hp",noHp);
                    params.put("pendidikan_terakhir",pendidikan);
                    params.put("prodi",prodi);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(add_mahasiswa_activity.this);
            requestQueue.add(request);
        }
    }
}