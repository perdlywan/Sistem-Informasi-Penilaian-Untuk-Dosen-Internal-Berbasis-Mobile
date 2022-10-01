package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class TambahKuisoner extends AppCompatActivity {
    Spinner spinDosen;
    Button btn_simpan;
    RadioGroup radiogrup1;
    RadioGroup radiogrup2;
    RadioGroup radiogrup3;
    RadioGroup radiogrup4;
    RadioGroup radiogrup5;
    RadioGroup radiogrup6;
    RadioGroup radiogrup7;
    RadioGroup radiogrup8;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tambah_kuisoner);

        Spinner spinner = findViewById(R.id.comboDosen);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dosen, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinDosen = findViewById(R.id.comboDosen);
        btn_simpan = findViewById(R.id.btn_simpan);
        radiogrup1 = findViewById(R.id.radioGroup1);
        radiogrup2 = findViewById(R.id.radioGroup2);
        radiogrup3 = findViewById(R.id.radioGroup3);
        radiogrup4 = findViewById(R.id.radioGroup4);
        radiogrup5 = findViewById(R.id.radioGroup5);
        radiogrup6 = findViewById(R.id.radioGroup6);
        radiogrup7 = findViewById(R.id.radioGroup7);
        radiogrup8 = findViewById(R.id.radioGroup8);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radiogrup1.getCheckedRadioButtonId();
                radioButton1 = findViewById(selectedId);

                int selectedId2 = radiogrup2.getCheckedRadioButtonId();
                radioButton2 = findViewById(selectedId2);

                int selectedId3 = radiogrup3.getCheckedRadioButtonId();
                radioButton3 = findViewById(selectedId3);

                int selectedId4 = radiogrup4.getCheckedRadioButtonId();
                radioButton4 = findViewById(selectedId4);

                int selectedId5 = radiogrup5.getCheckedRadioButtonId();
                radioButton5 = findViewById(selectedId5);

                int selectedId6 = radiogrup6.getCheckedRadioButtonId();
                radioButton6 = findViewById(selectedId6);

                int selectedId7 = radiogrup7.getCheckedRadioButtonId();
                radioButton7 = findViewById(selectedId7);

                int selectedId8 = radiogrup8.getCheckedRadioButtonId();
                radioButton8 = findViewById(selectedId8);
                insert_data();
            }
        });
    }

    private void insert_data(){
        final String nama_dosen = spinDosen.getSelectedItem().toString().trim();
        final String pertanyaan1 = radioButton1.getText().toString().trim();
        final String pertanyaan2 = radioButton2.getText().toString().trim();
        final String pertanyaan3 = radioButton3.getText().toString().trim();
        final String pertanyaan4 = radioButton4.getText().toString().trim();
        final String pertanyaan5 = radioButton5.getText().toString().trim();
        final String pertanyaan6 = radioButton6.getText().toString().trim();
        final String pertanyaan7 = radioButton7.getText().toString().trim();
        final String pertanyaan8 = radioButton8.getText().toString().trim();

        ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Loading.....");

        if(nama_dosen.isEmpty()){
            Toast.makeText(this,"Pilih Nama Dosen", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan1.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan2.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan3.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan4.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan5.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan6.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan7.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pertanyaan8.isEmpty()){
            Toast.makeText(this,"Setiap pertanyaan wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.SIMPAN_KUISONER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("success")){
                                Toast.makeText(TambahKuisoner.this, "Data kuisoner berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else {
                                Toast.makeText(TambahKuisoner.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(TambahKuisoner.this, error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nama_dosen",nama_dosen);
                    params.put("pertanyaan1",pertanyaan1);
                    params.put("pertanyaan2",pertanyaan2);
                    params.put("pertanyaan3",pertanyaan3);
                    params.put("pertanyaan4",pertanyaan4);
                    params.put("pertanyaan5",pertanyaan5);
                    params.put("pertanyaan6",pertanyaan6);
                    params.put("pertanyaan7",pertanyaan7);
                    params.put("pertanyaan8",pertanyaan8);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(TambahKuisoner.this);
            requestQueue.add(request);
        }
    }


}