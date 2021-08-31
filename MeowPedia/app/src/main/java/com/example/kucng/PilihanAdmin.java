package com.example.kucng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class PilihanAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_admin);

    }
    public void kucing(View view) {
        Intent intent = new Intent(PilihanAdmin.this, DataKucing.class);
        startActivity(intent);
    }

    public void wildcat(View view) {
        Intent intent = new Intent(PilihanAdmin.this, DataKucingBesar.class);
        startActivity(intent);
    }

    public void penyakit(View view) {
        Intent intent = new Intent(PilihanAdmin.this, DataPenyakit.class);
        startActivity(intent);
    }
}