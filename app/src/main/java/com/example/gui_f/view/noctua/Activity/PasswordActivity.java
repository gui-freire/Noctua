package com.example.gui_f.view.noctua.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
import com.example.gui_f.viewmodel.noctua.Password.Password;
import com.example.gui_f.viewmodel.noctua.Password.PasswordImpl;

public class PasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button send;
    private Password password = new PasswordImpl();
    private GenericError genericError = new GenericError();
    private Context context = this;

    private Intent intent;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
