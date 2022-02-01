package com.example.sputnikok;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Sunrise extends AppCompatActivity {
    Button timeZ, timeV, swap;
    ImageView imageView;
    Integer flagForSwap = 1;
    int ZHour =7, ZMinute=0, VHour = 21, VMinute=0;
    int DIALOG_ZAK = 1, DIALOG_VOS =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunrise);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.zakat).into(imageView);
        timeZ = findViewById(R.id.buttontimeZ);
        timeV = findViewById(R.id.buttontimeV);
        swap = findViewById(R.id.swapplace);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagForSwap == 1){
                    Glide.with(Sunrise.this).load(R.drawable.rasvet).into(imageView);
                    flagForSwap = 0;
                }
                else{
                    Glide.with(Sunrise.this).load(R.drawable.zakat).into(imageView);
                    flagForSwap = 1;
                }
            }
        });

        timeZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ZAK);
            }
        });
        timeV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_VOS);
            }
        });
    }
    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ZHour = hourOfDay;
            ZMinute = minute;
            VHour = hourOfDay;
            VMinute = minute;
        }
    };
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ZAK) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, ZHour, ZMinute, true);
            return tpd;
        }
        if (id == DIALOG_VOS) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, VHour, VMinute, true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Sunrise.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
