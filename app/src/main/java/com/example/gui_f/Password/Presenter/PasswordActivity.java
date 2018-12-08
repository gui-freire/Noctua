package com.example.gui_f.Password.Presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.noctua.R;
import com.example.gui_f.Password.ViewModel.Password;
import com.example.gui_f.Password.ViewModel.PasswordImpl;

public class PasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button send;
    private Password password = new PasswordImpl();
    private Context context = this;

    private Intent intent;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        intent = getIntent();

        email = (EditText) findViewById(R.id.editEmail);
        send = (Button) findViewById(R.id.btnSend);
    }

    @Override
    protected void onStart() {
        super.onStart();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    showSuccessDialog();
                    password.forgotPassword(email.getText().toString(), context);
                }catch (Exception e){
                    showErrorDialog();
                }
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void showSuccessDialog(){
        new AlertDialog.Builder(PasswordActivity.this)
                .setMessage(R.string.ChangePassword)
                .setNeutralButton(R.string.Okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    public void showErrorDialog(){
        new AlertDialog.Builder(PasswordActivity.this)
                .setMessage(R.string.Error)
                .setNeutralButton(R.string.Okay, null)
                .show();
    }
}
