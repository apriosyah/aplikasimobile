package com.example.tugasalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class lihat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);
        getSupportActionBar() .setTitle("Lihat Pengingat");
    }

    public void KEMBALI(View view) {
            Intent KEMBALI = new Intent(lihat.this, MainActivity.class);
            startActivity(KEMBALI);
        }
}
