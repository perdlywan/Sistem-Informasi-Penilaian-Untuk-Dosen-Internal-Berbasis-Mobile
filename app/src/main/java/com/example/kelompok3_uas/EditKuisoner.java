package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class EditKuisoner extends AppCompatActivity {
    private  String pertanyaan1,pertanyaan2,pertanyaan3,pertanyaan4,pertanyaan5,
            pertanyaan6,pertanyaan7,pertanyaan8;
    Spinner spinDosen;
    EditText edId;
    Button btn_update;
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
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_kuisoner);

        Spinner spinner = findViewById(R.id.comboDosenEdit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dosen, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        edId = findViewById(R.id.edId);
        spinDosen = findViewById(R.id.comboDosenEdit);
        btn_update = findViewById(R.id.btn_updateKuisoner);
        radiogrup1 = findViewById(R.id.radioGroup1Edit);
        radiogrup2 = findViewById(R.id.radioGroup2Edit);
        radiogrup3 = findViewById(R.id.radioGroup3Edit);
        radiogrup4 = findViewById(R.id.radioGroup4Edit);
        radiogrup5 = findViewById(R.id.radioGroup5Edit);
        radiogrup6 = findViewById(R.id.radioGroup6Edit);
        radiogrup7 = findViewById(R.id.radioGroup7Edit);
        radiogrup8 = findViewById(R.id.radioGroup8Edit);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edId.setText(HistoryKuisoner.kuisonerArrayList.get(position).getId());

        int selectionPosition = adapter.getPosition(HistoryKuisoner.kuisonerArrayList.get(position).getNama_dosen());
        spinDosen.setSelection(selectionPosition);

        pertanyaan1 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan1().replaceAll("\\s+","");
        switch (pertanyaan1) {
            case "SangatBaik":
                radiogrup1.check(R.id.radio1Edit);
                break;
            case "Baik":
                radiogrup1.check(R.id.radio2Edit);
                break;
            case "Cukup":
                radiogrup1.check(R.id.radio3Edit);
                break;
            case "Kurang":
                radiogrup1.check(R.id.radio4Edit);
                break;
            case "SangatKurang":
                radiogrup1.check(R.id.radio5Edit);
                break;
        }

        pertanyaan2 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan2().replaceAll("\\s+","");
        switch (pertanyaan2) {
            case "SangatBaik":
                radiogrup2.check(R.id.radio6Edit);
                break;
            case "Baik":
                radiogrup2.check(R.id.radio7Edit);
                break;
            case "Cukup":
                radiogrup2.check(R.id.radio8Edit);
                break;
            case "Kurang":
                radiogrup2.check(R.id.radio9Edit);
                break;
            case "SangatKurang":
                radiogrup2.check(R.id.radio10Edit);
                break;
        }

        pertanyaan3 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan3().replaceAll("\\s+","");
        switch (pertanyaan3) {
            case "SangatBaik":
                radiogrup3.check(R.id.radio11Edit);
                break;
            case "Baik":
                radiogrup3.check(R.id.radio12Edit);
                break;
            case "Cukup":
                radiogrup3.check(R.id.radio13Edit);
                break;
            case "Kurang":
                radiogrup3.check(R.id.radio14Edit);
                break;
            case "SangatKurang":
                radiogrup3.check(R.id.radio15Edit);
                break;
        }


        pertanyaan4 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan4().replaceAll("\\s+","");
        switch (pertanyaan4) {
            case "SangatBaik":
                radiogrup4.check(R.id.radio16Edit);
                break;
            case "Baik":
                radiogrup4.check(R.id.radio17Edit);
                break;
            case "Cukup":
                radiogrup4.check(R.id.radio18Edit);
                break;
            case "Kurang":
                radiogrup4.check(R.id.radio19Edit);
                break;
            case "SangatKurang":
                radiogrup4.check(R.id.radio20Edit);
                break;
        }

        pertanyaan5 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan5().replaceAll("\\s+","");
        switch (pertanyaan5) {
            case "SangatBaik":
                radiogrup5.check(R.id.radio21Edit);
                break;
            case "Baik":
                radiogrup5.check(R.id.radio22Edit);
                break;
            case "Cukup":
                radiogrup5.check(R.id.radio23Edit);
                break;
            case "Kurang":
                radiogrup5.check(R.id.radio24Edit);
                break;
            case "SangatKurang":
                radiogrup5.check(R.id.radio25Edit);
                break;
        }

        pertanyaan6 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan6().replaceAll("\\s+","");
        switch (pertanyaan6) {
            case "SangatBaik":
                radiogrup6.check(R.id.radio26Edit);
                break;
            case "Baik":
                radiogrup6.check(R.id.radio27Edit);
                break;
            case "Cukup":
                radiogrup6.check(R.id.radio28Edit);
                break;
            case "Kurang":
                radiogrup6.check(R.id.radio29Edit);
                break;
            case "SangatKurang":
                radiogrup6.check(R.id.radio30Edit);
                break;
        }

        pertanyaan7 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan7().replaceAll("\\s+","");
        switch (pertanyaan7) {
            case "SangatBaik":
                radiogrup7.check(R.id.radio31Edit);
                break;
            case "Baik":
                radiogrup7.check(R.id.radio32Edit);
                break;
            case "Cukup":
                radiogrup7.check(R.id.radio33Edit);
                break;
            case "Kurang":
                radiogrup7.check(R.id.radio34Edit);
                break;
            case "SangatKurang":
                radiogrup7.check(R.id.radio35Edit);
                break;
        }

        pertanyaan8 = HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan8().replaceAll("\\s+","");
        switch (pertanyaan8) {
            case "SangatBaik":
                radiogrup8.check(R.id.radio36Edit);
                break;
            case "Baik":
                radiogrup8.check(R.id.radio37Edit);
                break;
            case "Cukup":
                radiogrup8.check(R.id.radio38Edit);
                break;
            case "Kurang":
                radiogrup8.check(R.id.radio39Edit);
                break;
            case "SangatKurang":
                radiogrup8.check(R.id.radio40Edit);
                break;
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
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
                UpdateDataKuisoner();
            }
        });


    }

    public void UpdateDataKuisoner() {
        String id = edId.getText().toString();
        String nama_dosen = spinDosen.getSelectedItem().toString();
        String pertanyaan1 = radioButton1.getText().toString();
        String pertanyaan2 = radioButton2.getText().toString();
        String pertanyaan3 = radioButton3.getText().toString();
        String pertanyaan4 = radioButton4.getText().toString();
        String pertanyaan5 = radioButton5.getText().toString();
        String pertanyaan6 = radioButton6.getText().toString();
        String pertanyaan7 = radioButton7.getText().toString();
        String pertanyaan8 = radioButton8.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, KoneksiServer.EDIT_KUISONER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EditKuisoner.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),HistoryKuisoner.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditKuisoner.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
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

        RequestQueue requestQueue = Volley.newRequestQueue(EditKuisoner.this);
        requestQueue.add(request);
    }
}