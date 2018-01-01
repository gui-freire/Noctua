package com.example.gui_f.view.noctua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.Diary;
import com.example.gui_f.viewmodel.noctua.DiaryImpl;

public class DiaryActivity extends AppCompatActivity {

    private Button send;
    private ImageView bad;
    private ImageView kinda;
    private ImageView good;
    private EditText diary;

    private String feeling;

    private Diary diaryService = new DiaryImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        send = (Button) findViewById(R.id.btnSendDiary);
        bad = (ImageView) findViewById(R.id.imgBad);
        kinda = (ImageView) findViewById(R.id.imgKinda);
        good = (ImageView) findViewById(R.id.imgGood);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        final String user = intent.getStringExtra("user");
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaryService.sendFeeling(user, "Bad");
            }
        });

        kinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaryService.sendFeeling(user, "Moderate");
            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaryService.sendFeeling(user, "Good");
            }
        });
    }

    @Override
    protected void onStop() {
        onSaveInstanceState();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("Diary", diary.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
