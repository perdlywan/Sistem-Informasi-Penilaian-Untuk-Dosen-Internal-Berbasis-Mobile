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

public class MyAdapter3 extends ArrayAdapter<Dosen> {

    Context context;
    List<Dosen> arrayListDosen;

    public MyAdapter3(@NonNull Context context, List<Dosen> arrayListDosen) {
        super(context, R.layout.custom_list_item,arrayListDosen);

        this.context = context;
        this.arrayListDosen = arrayListDosen;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item2, null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvNama = view.findViewById(R.id.txt_nama);

        tvID.setText(arrayListDosen.get(position).getKodeDosen());
        tvNama.setText(arrayListDosen.get(position).getNamaDosen());

        return view;
    }
}
