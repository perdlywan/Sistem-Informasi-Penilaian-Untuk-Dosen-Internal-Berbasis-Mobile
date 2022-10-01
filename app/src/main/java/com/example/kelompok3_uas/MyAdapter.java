package com.example.kelompok3_uas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Mahasiswa> {

    Context context;
    List<Mahasiswa> arrayListMahasiswa;

    public MyAdapter(@NonNull Context context, List<Mahasiswa> arrayListMahasiswa) {
        super(context, R.layout.custom_list_item,arrayListMahasiswa);

        this.context = context;
        this.arrayListMahasiswa = arrayListMahasiswa;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvNama = view.findViewById(R.id.txt_nama);

        tvID.setText(arrayListMahasiswa.get(position).getNim());
        tvNama.setText(arrayListMahasiswa.get(position).getNama());

        return view;
    }
}
