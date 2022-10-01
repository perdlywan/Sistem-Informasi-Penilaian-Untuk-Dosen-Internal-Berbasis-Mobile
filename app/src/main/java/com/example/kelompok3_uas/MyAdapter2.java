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

public class MyAdapter2 extends ArrayAdapter<Kuisoner> {

    Context context;
    List<Kuisoner> arrayListKuisoner;

    public MyAdapter2(@NonNull Context context, List<Kuisoner> arrayListKuisoner) {
        super(context, R.layout.custom_list_item2,arrayListKuisoner);

        this.context = context;
        this.arrayListKuisoner = arrayListKuisoner;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item2, null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvNama = view.findViewById(R.id.txt_nama);

        tvID.setText(arrayListKuisoner.get(position).getId());
        tvNama.setText(arrayListKuisoner.get(position).getNama_dosen());

        return view;
    }
}
