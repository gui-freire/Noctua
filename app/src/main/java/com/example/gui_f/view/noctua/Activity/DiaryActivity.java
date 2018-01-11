package com.example.gui_f.view.noctua.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gui_f.model.noctua.Diary.FeelEnum;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
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

    private GenericError genericError = new GenericError();

    private Context context = this;

    private String user;

    private boolean badBool;
    private boolean kindaBool;
    private boolean goodBool;

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
        diary = (EditText) findViewById(R.id.editDiary);

        if(savedInstanceState != null){
            diary.setText(savedInstanceState.getString("Diary"));
        }
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
        user = intent.getStringExtra("user");
        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feeling = FeelEnum.BAD.toString();
                if(badBool){
                    badBool = false;
                    bad.clearColorFilter();
                } else {
                    bad.setColorFilter(getResources().getColor(R.color.tiffanyBlue));
                    badBool = true;
                    kinda.clearColorFilter();
                    kindaBool = false;
                    good.clearColorFilter();
                    goodBool = false;
                }
            }
        });

        kinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feeling = FeelEnum.MODERATE.toString();
                if(kindaBool){
                    kindaBool = false;
                    kinda.clearColorFilter();
                } else{
                    kinda.setColorFilter(getResources().getColor(R.color.tiffanyBlue));
                    kindaBool = true;
                    goodBool = false;
                    good.clearColorFilter();
                    badBool = false;
                    bad.clearColorFilter();
                }
            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feeling = FeelEnum.GOOD.toString();
                if(goodBool){
                    goodBool = false;
                    good.clearColorFilter();
                } else {
                    good.setColorFilter(getResources().getColor(R.color.tiffanyBlue));
                    goodBool = true;
                    kindaBool = false;
                    kinda.clearColorFilter();
                    badBool = false;
                    bad.clearColorFilter();
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (diary != null) {
                        diaryService.sendDiary(user, diary.getText().toString(), feeling, context);
                        ((Activity) context).finish();
                    } else{
                        diaryService.sendDiary(user, "", feeling, context);
                        ((Activity) context).finish();
                    }
                }catch (Exception e){
                    Log.d("Error", e.getMessage());
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("Diary", diary.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    public void showAlertDialog(){
        new AlertDialog.Builder(context)
                .setMessage(R.string.warning_save)
                .setPositiveButton(R.string.SaveFragment, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("AlertDialogPositive", "Positive click!");
                        try {
                            if (diary == null) {
                                diary.setText("");
                            }
                            if(diaryService.sendDiary(user, diary.getText().toString(), feeling, context))
                                showSuccessDialog();
                            else
                                showErrorDialog();
                        }catch (Exception e){
                            showErrorDialog();
                        }
                    }
                })
                .setNegativeButton(R.string.YesFragment, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    public void showErrorDialog(){
        new android.app.AlertDialog.Builder(DiaryActivity.this)
                .setMessage(getResources().getString(R.string.Error))
                .setNeutralButton(getResources().getString(R.string.Okay),null).show();
    }

    public void showSuccessDialog(){
        new android.app.AlertDialog.Builder(DiaryActivity.this)
                .setMessage(getResources().getString(R.string.RegisterSuccess))
                .setNeutralButton(getResources().getString(R.string.Okay),null).show();
    }
}
