package com.example.gui_f.view.noctua;

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
import com.example.gui_f.viewmodel.noctua.Password.Password;
import com.example.gui_f.viewmodel.noctua.Password.PasswordImpl;

public class PasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button send;
    private Password password = new PasswordImpl();
    private GenericError genericError = new GenericError();

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
        //TODO: enviar e-mail para o serviço para enviar um email com senha e usuário


    }

    @Override
    protected void onStart() {
        super.onStart();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    password.forgotPassword(email.getText().toString());
                }catch (Exception e){
//                    genericError.setMessage(R.string.SomethingWrong);
//                    genericError.onCreateDialog(savedInstanceState);
                }
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
