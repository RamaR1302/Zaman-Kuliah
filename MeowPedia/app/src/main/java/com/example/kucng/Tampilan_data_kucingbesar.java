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
import com.squareup.picasso.Picasso;

public class Tampilan_data_kucingbesar extends AppCompatActivity {
    private DatabaseReference DBKoneksi;
    private String fotoUrl, contactId;

    ImageView FotoContact;
    TextView TextNama, Textfakta, Textpenjelasan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_data_kucingbesar);
        FotoContact = findViewById(R.id.imageview);
        TextNama = findViewById(R.id.View);
        Textfakta = findViewById(R.id.View2);
        Textpenjelasan = findViewById(R.id.View3);






        DBKoneksi = FirebaseDatabase.getInstance().getReference("kucingbesar");

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
                    Textfakta.setText(getSnapshot.child("asal").getValue().toString());
                    Textpenjelasan.setText(getSnapshot.child("penjelasan").getValue().toString());
                    fotoUrl = getSnapshot.child("foto").getValue().toString();

                    Picasso.get().load(fotoUrl).fit().into(FotoContact);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}