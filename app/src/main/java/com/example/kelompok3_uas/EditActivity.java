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

public class EditActivity extends AppCompatActivity {
    AutoCompleteTextView txtStatus,txtPendidikan,txtProdi;
    TextInputEditText txtnim,txtnama,txttempatLahir,txttanggalLahir,txtalamat,txtkecamatan,txtkota,txtprovinsi,txtkodePos,txtnomorHp;
    Button btn_update;
    private int position;

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
        setContentView(R.layout.activity_edit);

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
        btn_update = findViewById(R.id.btnUpdate);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        txtnim.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNim());
        txtnama.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNama());
        txttempatLahir.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getTempatLahir());
        txttanggalLahir.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getTanggalLahir());
        txtStatus.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getStatus());
        txtalamat.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getAlamat());
        txtkecamatan.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKecamatan());
        txtkota.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKota());
        txtprovinsi.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getProvinsi());
        txtkodePos.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKodePos());
        txtnomorHp.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNoHp());
        txtPendidikan.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getPendidikan());
        txtProdi.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getProdi());

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

    public void updateData(View view) {
       String nim = txtnim.getText().toString();
       String nama = txtnama.getText().toString();
       String tempatLahir = txttempatLahir.getText().toString();
       String tanggalLahir = txttanggalLahir.getText().toString();
       String status = txtStatus.getText().toString();
       String alamat = txtalamat.getText().toString();
       String kecamatan = txtkecamatan.getText().toString();
       String kota = txtkota.getText().toString();
       String provinsi = txtprovinsi.getText().toString();
       String kodePos = txtkodePos.getText().toString();
       String noHp = txtnomorHp.getText().toString();
       String pendidikan = txtPendidikan.getText().toString();
       String prodi = txtProdi.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.EDIT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EditActivity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),mahasiswaActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
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

        RequestQueue requestQueue = Volley.newRequestQueue(EditActivity.this);
        requestQueue.add(request);
    }
}