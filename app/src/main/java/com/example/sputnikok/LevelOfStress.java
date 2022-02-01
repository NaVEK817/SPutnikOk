package com.example.sputnikok;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LevelOfStress extends AppCompatActivity {
    Button next;
    CheckBox yes,no;
    TextView quest, zagol;
    String recom;
    String [] a;
    int i = 0;
    float bal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_of_stress);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        next = findViewById(R.id.next);
        yes = findViewById(R.id.checkYes);
        no = findViewById(R.id.checkNo);
        quest = findViewById(R.id.quest);
        zagol = findViewById(R.id.zagol);
        a = getResources().getStringArray(R.array.task);
        quest.setText(a[0]);
        zagol.setText("Вопрос " + "1" + "/" + Integer.toString(a.length));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i+1==a.length){
                    AlertDialog.Builder quitDialog = new AlertDialog.Builder(LevelOfStress.this);
                    quitDialog.setCancelable(false);
                    quitDialog.setTitle("Ваш результат:" + Float.toString(bal) + "/66" );
                    if (bal<=5){
                        recom = "Стресс отсутствует.";
                    }
                    if (bal >=6 && bal <=12){
                        recom = "Вы испытываете умеренный стресс, который может быть компенсирован с помощью рационального использования времени, периодического отдыха и нахождения оптимального выхода из сложившейся ситуации.";
                    }
                    if (bal >=13 && bal <=24){
                        recom = "Требуется применение специальных методов преодоления стресса.";
                    }
                    if (bal >=25 && bal <=40){
                        recom = "Cильный уровень стресса, следует сообщить об этом сокомандникам. Срочно пересмотреть свое отношение к актуальной проблеме, заняться устранением стресса.";
                    }
                    if (bal > 40){
                        recom = "Cледует заняться своим здоровьем, пока обратимые психопатологические процессы не привели к стойким физиологическим или органическим изменениям, компенсировать которые будет весьма сложно.";
                    }
                    quitDialog.setPositiveButton(recom, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    });
                    quitDialog.show();
                }
                if (yes.isChecked() && no.isChecked()){
                    i--;
                    AlertDialog.Builder quitDialog = new AlertDialog.Builder(LevelOfStress.this);
                    quitDialog.setCancelable(false);
                    quitDialog.setTitle("Вы не можете выбрать сразу два варианта.");
                    quitDialog.setPositiveButton("Вернуться к тестированию", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    quitDialog.show();
                }
                if (!(yes.isChecked()) && !(no.isChecked())){
                    i--;
                    AlertDialog.Builder quitDialog = new AlertDialog.Builder(LevelOfStress.this);
                    quitDialog.setCancelable(false);
                    quitDialog.setTitle("Вы не можете не выбрать вариант.");
                    quitDialog.setPositiveButton("Вернуться к тестированию", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    quitDialog.show();
                }
                if (yes.isChecked()){
                    yes.setChecked(false);
                    quest.setText(a[i]);
                    if (i <=23){
                        bal++;
                    }
                    if ((i > 23) && (i<=35)){
                        bal+=1.5;
                    }
                    if (i>35){
                        bal+=2;
                    }
                }
                if (no.isChecked()){
                    no.setChecked(false);
                    quest.setText(a[i]);
                }
                zagol.setText("Вопрос " + Integer.toString(i+1) + "/" + Integer.toString(a.length));
            }
        });
    }
    @Override
    public void onBackPressed() {
        bal=0;
        i=0;
        Intent intent = new Intent(LevelOfStress.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
