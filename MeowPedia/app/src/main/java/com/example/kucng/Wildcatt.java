package com.example.kucng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class Wildcatt extends AppCompatActivity {
    MediaPlayer audioBackground;
    private DatabaseReference DBKoneksi;
    private ListView listViewContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildcatt);
        audioBackground = MediaPlayer.create(this, R.raw.wildcat);
        //Set looping ke true untuk mengulang audio jika telah selesai

        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
        DBKoneksi = FirebaseDatabase.getInstance().getReference("kucingbesar");
        listViewContact = findViewById(R.id.listViewContact);



        readData();


        listViewContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String idContact = ((TextView)view.findViewById(R.id.isi1)).getTag().toString();

                Intent Tampil_data_kucingbesar = new Intent(Wildcatt.this, Tampilan_data_kucingbesar.class);

                Tampil_data_kucingbesar.putExtra("id", idContact);

                startActivity(Tampil_data_kucingbesar);


            }
        });

    }

    private void readData() {
        final ArrayList<String> id = new ArrayList<>();
        final ArrayList<String> nama = new ArrayList<>();
        final ArrayList<String> fakta= new ArrayList<>();
        final ArrayList<String> penjelasan = new ArrayList<>();
        final ArrayList<String> foto = new ArrayList<>();

        DBKoneksi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterable = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterable.iterator();

                while (iterator.hasNext()){

                    Model value = iterator.next().getValue(Model.class);

                    assert value != null;
                    id.add(value.getId());
                    nama.add(value.getNama());
                    fakta.add(value.getAsal());
                    penjelasan.add(value.getPenjelasan());
                    foto.add(value.getFoto());

                    ((listViewAdaptar)listViewContact.getAdapter()).notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listViewContact.setAdapter(new listViewAdaptar(id, nama, fakta,foto,this));
    }

    @Override
    public void onResume(){
        super.onResume();
        readData();
    }
}