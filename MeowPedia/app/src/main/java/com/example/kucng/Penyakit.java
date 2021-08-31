package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Penyakit extends AppCompatActivity {
    private DatabaseReference DBKoneksi;




    EditText TextNama, TextFakta, TextPenjelasan;
    Button Tsave;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit);

        TextNama = findViewById(R.id.textView);
        TextFakta = findViewById(R.id.textView2);
        TextPenjelasan = findViewById(R.id.textView3);

        Tsave = findViewById(R.id.save);




        DBKoneksi = FirebaseDatabase.getInstance().getReference( "penyakit");




        Tsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpanData();
                tersimpan();
                Toast.makeText(getApplicationContext(),"data telah berhasil di simpan", Toast.LENGTH_SHORT).show();
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


    private void simpanData() {

        String imagename = TextNama.getText().toString();
        Model2 contact = new Model2(imagename,
                TextNama.getText().toString(),
                TextFakta.getText().toString(),
                TextPenjelasan.getText().toString()

                );


        DBKoneksi.child(imagename).setValue(contact);
    }

    public void tersimpan(){
        mediaPlayer = MediaPlayer.create(this, R.raw.tambah);
        mediaPlayer.setVolume(1,1);
        //Memulai audio
        mediaPlayer.start();
    }


}