package com.example.sputnikok;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DeathElevation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_elevation);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DeathElevation.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
