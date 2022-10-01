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

public class DosenActivity extends AppCompatActivity {
    ListView listViewDosen;
    MyAdapter3 adapter;
    public static ArrayList<Dosen> dosenArrayList = new ArrayList<>();
    Dosen dosen;
    public static DosenActivity da;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dosen);

        listViewDosen = findViewById(R.id.ListViewDosen);
        adapter = new MyAdapter3(this,dosenArrayList);
        listViewDosen.setAdapter(adapter);

        listViewDosen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long KodeDosen) {
                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence [] dialogItem = {"View Data","Edit Data","Delete Data"};
                builder.setTitle(dosenArrayList.get(position).getNamaDosen());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){

                            case 0:
                                startActivity(new Intent(getApplicationContext(),DetailDosen.class)
                                        .putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(),EditDosen.class)
                                        .putExtra("position",position));
                                break;
                            case 2:
                                deleteData(dosenArrayList.get(position).getKodeDosen());
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });

        retrieveData();
    }

    private void deleteData(String KodeDosen){
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.HAPUS_DOSEN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("Data Deleted")) {
                            Toast.makeText(DosenActivity.this, "Data dosen berhasil dihapus", Toast.LENGTH_SHORT).show();
                            DosenActivity.this.retrieveData();
                        }
                        else {
                            Toast.makeText(DosenActivity.this, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DosenActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("KodeDosen", KodeDosen);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.TAMPIL_DOSEN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dosenArrayList.clear();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(sucess.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String KodeDosen = object.getString("KodeDosen");
                                    String Nidn = object.getString("Nidn");
                                    String NamaDosen = object.getString("NamaDosen");
                                    String TmptLahir = object.getString("TmptLahir");
                                    String TglLahir = object.getString("TglLahir");
                                    String Status = object.getString("Status");
                                    String Alamat = object.getString("Alamat");
                                    String Kelurahan = object.getString("Kelurahan");
                                    String Kecamatan = object.getString("Kecamatan");
                                    String Kota_Kab = object.getString("Kota_Kab");
                                    String Provinsi = object.getString("Provinsi");
                                    String KodePos = object.getString("KodePos");
                                    String NoHp = object.getString("NoHp");
                                    String Pendidikan = object.getString("Pendidikan");
                                    String JabatanAkademik = object.getString("JabatanAkademik");
                                    String Golongan = object.getString("Golongan");
                                    String Prodi = object.getString("Prodi");
                                    String BidangKeahlian = object.getString("BidangKeahlian");


                                    dosen = new Dosen(KodeDosen,Nidn,NamaDosen,TmptLahir,TglLahir,
                                            Status,Alamat,Kelurahan,Kecamatan,Kota_Kab,Provinsi,KodePos,NoHp,Pendidikan,
                                            JabatanAkademik,Golongan,Prodi,BidangKeahlian);
                                    dosenArrayList.add(dosen);
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
                Toast.makeText(DosenActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void tambahDosen(View view) {
        startActivity(new Intent(getApplicationContext(),add_dosen_activity.class));
    }
}