package com.example.tugasalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar() .setTitle("Pengingat Tugas");
    }

    public void INPUTTUGAS(View view) {
        Intent INPUTTUGAS = new Intent(MainActivity.this, input.class);
        startActivity(INPUTTUGAS);
    }

    public void EDITTUGAS(View view) {
        Intent EDITTUGAS = new Intent(MainActivity.this, coba.class);
        startActivity(EDITTUGAS);
    }

    public void LIHATTUGAS(View view) {
        Intent LIHATTUGAS = new Intent(MainActivity.this, edit.class);
        startActivity(LIHATTUGAS);
    }

    public void HAPUSTUGAS(View view) {
        Intent HAPUSTUGAS = new Intent(MainActivity.this, hapus.class);
        startActivity(HAPUSTUGAS);
    }
}
