package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView nim,nama,nama2,tempatLahir,tanggalLahir,status,alamat,kecamatan,kota,provinsi,kodePos,noHP,pendidikan,prodi;
    Button kembali;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail);

        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        nama2 = findViewById(R.id.nama2);
        tempatLahir = findViewById(R.id.tempatLahir);
        tanggalLahir = findViewById(R.id.tanggalLahir);
        status = findViewById(R.id.status);
        alamat = findViewById(R.id.alamat);
        kecamatan = findViewById(R.id.kecamatan);
        kota = findViewById(R.id.kota);
        provinsi = findViewById(R.id.provinsi);
        kodePos = findViewById(R.id.kodePos);
        noHP = findViewById(R.id.NoHP);
        pendidikan = findViewById(R.id.pendidikan);
        prodi = findViewById(R.id.prodi);
        kembali = findViewById(R.id.btnBack);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), mahasiswaActivity.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        nim.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNim());
        nama.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNama());
        nama2.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNama());
        tempatLahir.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getTempatLahir());
        tanggalLahir.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getTanggalLahir());
        status.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getStatus());
        alamat.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getAlamat());
        kecamatan.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKecamatan());
        kota.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKota());
        provinsi.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getProvinsi());
        kodePos.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getKodePos());
        noHP.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getNoHp());
        pendidikan.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getPendidikan());
        prodi.setText(mahasiswaActivity.mahasiswaArrayList.get(position).getProdi());
    }
}