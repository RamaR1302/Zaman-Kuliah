package com.example.kucng;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class AdminEditKucing extends AppCompatActivity {

    private DatabaseReference DBKoneksi;
    private StorageReference STKoneksi;


    ImageView FotoContact;
    TextView TextNama, Textfakta, Textpenjelasan;
    Button TombolEdit, TombolHapus;

    private String fotoUrl, contactId;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_kucing);

    FotoContact = findViewById(R.id.imageview);
    TextNama = findViewById(R.id.textView);
    Textfakta = findViewById(R.id.textView2);
    Textpenjelasan = findViewById(R.id.textView3);
    TombolEdit = findViewById(R.id.edit);
    TombolHapus = findViewById(R.id.hapus);

    DBKoneksi = FirebaseDatabase.getInstance().getReference("kucing");

    contactId = getIntent().getExtras().getString("id");


    readData();

    TombolEdit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateData();
            ubah();
            Toast.makeText(getApplicationContext(),"Data berhasil di Ubah", Toast.LENGTH_SHORT).show();
            Thread thread = new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        finish();
                    }
                }
            };
            thread.start();
        }
    });

    TombolHapus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            deleteData();
            deleteFoto();
            hapus();
            Toast.makeText(getApplicationContext(),"Data di hapus", Toast.LENGTH_SHORT).show();
            Thread thread = new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        finish();
                    }
                }
            };
            thread.start();
        }
    });
}

    private void deleteFoto() {
        STKoneksi = FirebaseStorage.getInstance().getReferenceFromUrl(fotoUrl);

        STKoneksi.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });

    }

    private void deleteData() {
        Query delQuery = DBKoneksi.orderByKey().equalTo(contactId);
        delQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DBKoneksi.child(contactId).removeValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void updateData() {
        Query editQuery = DBKoneksi.orderByKey().equalTo(contactId);

        editQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot addSnapshot : dataSnapshot.getChildren()){
                    addSnapshot.getRef().child("nama").setValue(TextNama.getText().toString());
                    addSnapshot.getRef().child("asal").setValue(Textfakta.getText().toString());
                    addSnapshot.getRef().child("penjelasan").setValue(Textpenjelasan.getText().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void ubah(){
        mediaPlayer = MediaPlayer.create(this, R.raw.ubah);
        mediaPlayer.setVolume(1,1);
        //Memulai audio
        mediaPlayer.start();
    }

    public void hapus(){
        mediaPlayer = MediaPlayer.create(this, R.raw.hapusdata);
        mediaPlayer.setVolume(1,1);
        //Memulai audio
        mediaPlayer.start();
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

