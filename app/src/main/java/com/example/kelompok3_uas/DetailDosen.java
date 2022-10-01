package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DetailDosen extends AppCompatActivity {
    TextView NamaDosen1,Kode,Nidn,NamaDosen,TempatLahir,TanggalLahir,Status,Alamat,Kelurahan,Kecamatan,
    Kota,Provinsi,KodePos,NoHp,Pendidikan,Jabatan,Golongan,Prodi,Bidang;
    Button btnKembaliDosen;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail_dosen);

        NamaDosen1 = findViewById(R.id.namaDosen1);
        Kode = findViewById(R.id.kode);
        Nidn = findViewById(R.id.nidn);
        NamaDosen = findViewById(R.id.namaDosen);
        TempatLahir = findViewById(R.id.TmptLahir);
        TanggalLahir = findViewById(R.id.TglLahir);
        Status = findViewById(R.id.Status);
        Alamat = findViewById(R.id.Alamat);
        Kelurahan = findViewById(R.id.Kelurahan);
        Kecamatan = findViewById(R.id.Kecamatan);
        Kota = findViewById(R.id.Kota);
        Provinsi = findViewById(R.id.Provinsi);
        KodePos = findViewById(R.id.KodePos);
        NoHp = findViewById(R.id.NoHp);
        Pendidikan = findViewById(R.id.Pendidikan);
        Jabatan = findViewById(R.id.Jabatan);
        Golongan = findViewById(R.id.Golongan);
        Prodi = findViewById(R.id.Prodi);
        Bidang = findViewById(R.id.Bidang);
        btnKembaliDosen = findViewById(R.id.btnBackDosen);

        btnKembaliDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DosenActivity.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        Kode.setText(DosenActivity.dosenArrayList.get(position).getKodeDosen());
        NamaDosen1.setText(DosenActivity.dosenArrayList.get(position).getNamaDosen());
        NamaDosen.setText(DosenActivity.dosenArrayList.get(position).getNamaDosen());
        Nidn.setText(DosenActivity.dosenArrayList.get(position).getNidn());
        TempatLahir.setText(DosenActivity.dosenArrayList.get(position).getTmptLahir());
        TanggalLahir.setText(DosenActivity.dosenArrayList.get(position).getTglLahir());
        Status.setText(DosenActivity.dosenArrayList.get(position).getStatus());
        Alamat.setText(DosenActivity.dosenArrayList.get(position).getAlamat());
        Kelurahan.setText(DosenActivity.dosenArrayList.get(position).getKelurahan());
        Kecamatan.setText(DosenActivity.dosenArrayList.get(position).getKecamatan());
        Kota.setText(DosenActivity.dosenArrayList.get(position).getKota_Kab());
        Provinsi.setText(DosenActivity.dosenArrayList.get(position).getProvinsi());
        KodePos.setText(DosenActivity.dosenArrayList.get(position).getKodePos());
        NoHp.setText(DosenActivity.dosenArrayList.get(position).getNoHp());
        Pendidikan.setText(DosenActivity.dosenArrayList.get(position).getPendidikan());
        Jabatan.setText(DosenActivity.dosenArrayList.get(position).getJabatanAkademik());
        Golongan.setText(DosenActivity.dosenArrayList.get(position).getGolongan());
        Prodi.setText(DosenActivity.dosenArrayList.get(position).getProdi());
        Bidang.setText(DosenActivity.dosenArrayList.get(position).getBidangKeahlian());
    }
}