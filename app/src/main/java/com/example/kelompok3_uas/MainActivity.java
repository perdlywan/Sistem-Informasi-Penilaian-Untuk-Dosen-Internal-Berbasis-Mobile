package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void halamanDataMahasiswa(View view) {
        startActivity(new Intent(getApplicationContext(),mahasiswaActivity.class));
    }

    public void halamanPenilaianDosen(View view) {
        startActivity(new Intent(getApplicationContext(),kuisonerActivity.class));
    }

    public void halamanDataDosen(View view) {
        startActivity(new Intent(getApplicationContext(),DosenActivity.class));
    }


}