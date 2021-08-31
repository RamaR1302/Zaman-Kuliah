package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class Biokucing extends AppCompatActivity {
    MediaPlayer audioBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biokucing);
        audioBackground = MediaPlayer.create(this, R.raw.bio);
        //Set looping ke true untuk mengulang audio jika telah selesai

        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
    }
}