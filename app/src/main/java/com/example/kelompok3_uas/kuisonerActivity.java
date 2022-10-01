package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class kuisonerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_kuisoner);
    }


    public void tambahKuisoner(View view) {
        startActivity(new Intent(getApplicationContext(),TambahKuisoner.class));
    }

    public void historyKuisoner(View view) {
        startActivity(new Intent(getApplicationContext(), HistoryKuisoner.class));
    }
}