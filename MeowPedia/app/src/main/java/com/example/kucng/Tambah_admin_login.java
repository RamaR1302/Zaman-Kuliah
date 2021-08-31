package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tambah_admin_login extends AppCompatActivity {
    private DatabaseReference DBKoneksi;




    EditText TextNama, TextFakta, TextPenjelasan;
    Button Tsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_admin_login);

        TextNama = findViewById(R.id.textView);
        TextFakta = findViewById(R.id.textView2);
        TextPenjelasan = findViewById(R.id.textView3);

        Tsave = findViewById(R.id.save);




        DBKoneksi = FirebaseDatabase.getInstance().getReference( "login");




        Tsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
                finish();
            }
        });


    }


    private void simpanData() {

        String imagename = TextNama.getText().toString();
        Model2 contact = new Model2(imagename,
                TextNama.getText().toString(),
                TextFakta.getText().toString(),
                TextPenjelasan.getText().toString()

        );


        DBKoneksi.child(imagename).setValue(contact);
    }




}