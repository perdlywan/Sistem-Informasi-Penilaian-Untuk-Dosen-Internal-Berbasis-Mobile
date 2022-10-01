package com.example.kelompok3_uas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mahasiswaActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;
    public static ArrayList<Mahasiswa> mahasiswaArrayList = new ArrayList<>();
    Mahasiswa mahasiswa;
    public static mahasiswaActivity mo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mahasiswa);

        listView = findViewById(R.id.ListView);
        adapter = new MyAdapter(this,mahasiswaArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long nim) {

                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence [] dialogItem = {"View Data","Edit Data","Delete Data"};
                builder.setTitle(mahasiswaArrayList.get(position).getNama());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){

                            case 0:
                                startActivity(new Intent(getApplicationContext(),DetailActivity.class)
                                        .putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(),EditActivity.class)
                                        .putExtra("position",position));
                                break;
                            case 2:
                                deleteData(mahasiswaArrayList.get(position).getNim());
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });

        retrieveData();
    }
    private void deleteData(String nim){
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.HAPUS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("Data Deleted")) {
                            Toast.makeText(mahasiswaActivity.this, "Data mahasiswa berhasil dihapus", Toast.LENGTH_SHORT).show();
                            mahasiswaActivity.this.retrieveData();
                        }
                        else {
                            Toast.makeText(mahasiswaActivity.this, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mahasiswaActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("nim", nim);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.TAMPIL_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        mahasiswaArrayList.clear();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(sucess.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String nim = object.getString("nim");
                                    String nama = object.getString("nama_mahasiswa");
                                    String tempatLahir = object.getString("tempat_lahir");
                                    String tanggalLahir = object.getString("tanggal_lahir");
                                    String status = object.getString("status");
                                    String alamat = object.getString("alamat");
                                    String kecamatan = object.getString("kecamatan");
                                    String kota = object.getString("kota_kab");
                                    String provinsi = object.getString("provinsi");
                                    String kodePos = object.getString("kode_pos");
                                    String noHp = object.getString("no_hp");
                                    String pendidikan = object.getString("pendidikan_terakhir");
                                    String prodi = object.getString("prodi");


                                    mahasiswa = new Mahasiswa(nim,nama,tempatLahir,tanggalLahir,status,
                                            alamat,kecamatan,kota,provinsi,kodePos,noHp,pendidikan,prodi);
                                    mahasiswaArrayList.add(mahasiswa);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mahasiswaActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void tambahMahasiswa(View view) {
        startActivity(new Intent(getApplicationContext(),add_mahasiswa_activity.class));
    }
}