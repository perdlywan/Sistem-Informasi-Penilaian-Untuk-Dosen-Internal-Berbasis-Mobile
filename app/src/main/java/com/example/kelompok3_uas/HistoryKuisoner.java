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

public class HistoryKuisoner extends AppCompatActivity {

    ListView listView;
    MyAdapter2 adapter;
    public static ArrayList<Kuisoner> kuisonerArrayList = new ArrayList<>();
    Kuisoner kuisoner;
    public static HistoryKuisoner hk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_history_kuisoner);

        listView = findViewById(R.id.HistorylistView);
        adapter = new MyAdapter2(this,kuisonerArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence [] dialogItem = {"View Data","Edit Data","Delete Data"};
                builder.setTitle(kuisonerArrayList.get(position).getNama_dosen());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){

                            case 0:
                                startActivity(new Intent(getApplicationContext(),DetailKuisoner.class)
                                        .putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(),EditKuisoner.class)
                                        .putExtra("position",position));
                                break;
                            case 2:
                                deleteData(kuisonerArrayList.get(position).getId());
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });

        retrieveData();
    }

    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.TAMPIL_KUISONER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        kuisonerArrayList.clear();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(sucess.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String nama_dosen = object.getString("nama_dosen");
                                    String pertanyaan1 = object.getString("pertanyaan1");
                                    String pertanyaan2 = object.getString("pertanyaan2");
                                    String pertanyaan3 = object.getString("pertanyaan3");
                                    String pertanyaan4 = object.getString("pertanyaan4");
                                    String pertanyaan5 = object.getString("pertanyaan5");
                                    String pertanyaan6 = object.getString("pertanyaan6");
                                    String pertanyaan7 = object.getString("pertanyaan7");
                                    String pertanyaan8 = object.getString("pertanyaan8");

                                    kuisoner = new Kuisoner(id,nama_dosen,pertanyaan1,pertanyaan2,pertanyaan3,pertanyaan4,pertanyaan5,pertanyaan6,pertanyaan7,pertanyaan8);
                                    kuisonerArrayList.add(kuisoner);
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
                Toast.makeText(HistoryKuisoner.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void deleteData(String id) {
        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.HAPUS_KUISONER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("Data Deleted")) {
                            Toast.makeText(HistoryKuisoner.this, "Data kuisoner berhasil dihapus", Toast.LENGTH_SHORT).show();
                            HistoryKuisoner.this.retrieveData();
                        }
                        else {
                            Toast.makeText(HistoryKuisoner.this, "Data kuisoner gagal dihapus", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HistoryKuisoner.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id", id);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}