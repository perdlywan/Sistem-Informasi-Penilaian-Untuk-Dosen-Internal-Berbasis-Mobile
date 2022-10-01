package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DetailKuisoner extends AppCompatActivity {
    TextView namaDosen,pertanyaan1,pertanyaan2,pertanyaan3,pertanyaan4,pertanyaan5,
            pertanyaan6,pertanyaan7,pertanyaan8;
    Button kembali;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_kuisoner);

        namaDosen = findViewById(R.id.namaDosen);
        pertanyaan1 = findViewById(R.id.pertanyaan1);
        pertanyaan2 = findViewById(R.id.pertanyaan2);
        pertanyaan3 = findViewById(R.id.pertanyaan3);
        pertanyaan4 = findViewById(R.id.pertanyaan4);
        pertanyaan5 = findViewById(R.id.pertanyaan5);
        pertanyaan6 = findViewById(R.id.pertanyaan6);
        pertanyaan7 = findViewById(R.id.pertanyaan7);
        pertanyaan8 = findViewById(R.id.pertanyaan8);
        kembali = findViewById(R.id.btnKembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HistoryKuisoner.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        namaDosen.setText(HistoryKuisoner.kuisonerArrayList.get(position).getNama_dosen());
        pertanyaan1.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan1());
        pertanyaan2.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan2());
        pertanyaan3.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan3());
        pertanyaan4.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan4());
        pertanyaan5.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan5());
        pertanyaan6.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan6());
        pertanyaan7.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan7());
        pertanyaan8.setText(HistoryKuisoner.kuisonerArrayList.get(position).getPertanyaan8());
    }
}