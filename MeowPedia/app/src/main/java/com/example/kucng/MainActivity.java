package com.example.kucng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void bio(View view) {
        startActivity(new Intent(MainActivity.this, Biokucing.class));

    }
    public void panduan(View view) {
        startActivity(new Intent(MainActivity.this, panduanpemula.class));

    }

    public void jenis(View view) {
        startActivity(new Intent(MainActivity.this, jeniskucing.class));

    }

    public void quis(View view) {
        startActivity(new Intent(MainActivity.this, quis.class));

    }

    public void admin(View view) {
        startActivity(new Intent(MainActivity.this, Login.class));

    }
    public void penyakit(View view) {
        startActivity(new Intent(MainActivity.this, Penyakitt.class));

    }

    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apa Kamu Ingin Keluar?");
        builder.setCancelable(true);
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                startActivity(new Intent(MainActivity.this, splashout.class));
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}