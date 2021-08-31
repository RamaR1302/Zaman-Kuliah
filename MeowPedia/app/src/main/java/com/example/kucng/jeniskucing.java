package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class jeniskucing extends AppCompatActivity {
    MediaPlayer audioBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeniskucing);
        audioBackground = MediaPlayer.create(this, R.raw.jenis);
        //Set looping ke true untuk mengulang audio jika telah selesai

        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
    }
    public void petcat(View view) {
        startActivity(new Intent(jeniskucing.this, Petcatt.class));

    }

    public void wild(View view) {
        startActivity(new Intent(jeniskucing.this, Wildcatt.class));

    }
}