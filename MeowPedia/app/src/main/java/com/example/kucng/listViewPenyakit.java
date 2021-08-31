package com.example.kucng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listViewPenyakit extends BaseAdapter {

    private ArrayList<String> id;
    private ArrayList<String> nama;
    private ArrayList<String> penjelasan;
    private ArrayList<String> penanganan;
    private AppCompatActivity activity;



    public listViewPenyakit(ArrayList<String> id, ArrayList<String> nama, ArrayList<String> penjelasan, ArrayList<String> penanganan, AppCompatActivity activity) {
        this.id = id;
        this.nama = nama;
        this.penjelasan = penjelasan;
        this.penanganan = penanganan;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.row2, parent, false);

        convertView.findViewById(R.id.isi1).setTag(String.valueOf(id.get(position)));

        ((TextView)convertView.findViewById(R.id.isi1)).setText(String.valueOf(nama.get(position)));

        return convertView;
    }
}
