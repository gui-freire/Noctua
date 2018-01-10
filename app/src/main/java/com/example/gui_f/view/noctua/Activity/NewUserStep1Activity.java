package com.example.gui_f.view.noctua.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewUserStep1Activity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText email;
    private EditText birthday;
    private EditText password;
    private Button btnContinue;

    private UserDTO user = new UserDTO();

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_step1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        i = getIntent();

        name = (EditText) findViewById(R.id.editName);
        surname = (EditText) findViewById(R.id.editSurname);
        email = (EditText) findViewById(R.id.editEmailNewUsr);
        birthday = (EditText) findViewById(R.id.editBday);
        password = (EditText) findViewById(R.id.editPasswReg);
        btnContinue = (Button) findViewById(R.id.btnContinue);


        if(savedInstanceState != null){
            name.setText(savedInstanceState.getString("Name"));
            surname.setText(savedInstanceState.getString("Surname"));
            email.setText(savedInstanceState.getString("Email"));
            birthday.setText(savedInstanceState.getString("Birthday"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                user.setBirthday(birthday.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());

                Intent intent = new Intent(v.getContext(), NewUserStep2Activity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Name", name.getText().toString());
        outState.putString("Surname", surname.getText().toString());
        outState.putString("Birthday", birthday.getText().toString());
        outState.putString("Email", email.getText().toString());
    }
}
