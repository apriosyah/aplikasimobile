package com.example.tugasalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hapus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus);
        getSupportActionBar() .setTitle("Hapus Pengingat");
    }

    public void KEMBALI(View view) {
        Intent KEMBALI = new Intent(hapus.this, MainActivity.class);
        startActivity(KEMBALI);
    }
}
