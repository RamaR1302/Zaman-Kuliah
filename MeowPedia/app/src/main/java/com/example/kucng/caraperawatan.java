package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class caraperawatan extends AppCompatActivity {
    MediaPlayer audioBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caraperawatan);
        audioBackground = MediaPlayer.create(this, R.raw.caraperawatan);
        //Set looping ke true untuk mengulang audio jika telah selesai

        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
    }
    public void mandi(View view) {
        startActivity(new Intent(caraperawatan.this, mandi.class));

    }

    public void bermain(View view) {
        startActivity(new Intent(caraperawatan.this, bermain.class));

    }
    public void kebiasaan(View view) {
        startActivity(new Intent(caraperawatan.this, kebiasaan.class));

    }
}