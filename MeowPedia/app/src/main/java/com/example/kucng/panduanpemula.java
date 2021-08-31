package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class panduanpemula extends AppCompatActivity {
    MediaPlayer audioBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduanpemula);
        audioBackground = MediaPlayer.create(this, R.raw.panduan);
        //Set looping ke true untuk mengulang audio jika telah selesai

        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
    }
    public void perlengkapan(View view) {
        startActivity(new Intent(panduanpemula.this, perlengkapan.class));

    }

    public void perawatan(View view) {
        startActivity(new Intent(panduanpemula.this, caraperawatan.class));

    }
}