package com.example.kucng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Tampil_data_penyakit extends AppCompatActivity {
    private DatabaseReference DBKoneksi;
    private String fotoUrl, contactId;

    ImageView FotoContact;
    TextView TextNama, Textpenjelasan, Textpenanganan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data_penyakit);
        FotoContact = findViewById(R.id.imageview);
        TextNama = findViewById(R.id.View);
        Textpenjelasan = findViewById(R.id.View2);
        Textpenanganan = findViewById(R.id.View9);






        DBKoneksi = FirebaseDatabase.getInstance().getReference("penyakit");

        contactId = getIntent().getExtras().getString("id");


        readData();

    }

    private void readData() {



        Query findQuery = DBKoneksi.orderByKey().equalTo(contactId);

        findQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot getSnapshot : dataSnapshot.getChildren()){

                    TextNama.setText(getSnapshot.child("nama").getValue().toString());
                    Textpenjelasan.setText(getSnapshot.child("penjelasan").getValue().toString());
                    Textpenanganan.setText(getSnapshot.child("penanganan").getValue().toString());


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}