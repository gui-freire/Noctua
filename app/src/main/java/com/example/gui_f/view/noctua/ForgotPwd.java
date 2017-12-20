package com.example.gui_f.view.noctua;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.noctua.R;

public class ForgotPwd extends AppCompatActivity {

    private EditText email;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText) findViewById(R.id.editEmail);
        send = (Button) findViewById(R.id.btnDiary);
        //TODO: enviar e-mail para o serviço para enviar um email com senha e usuário

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviar
                finish();
            }
        });
    }

}
