package com.example.gui_f.view.noctua.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
import com.example.gui_f.view.noctua.UserAlreadyExists;
import com.example.gui_f.viewmodel.noctua.NewUser.NewUser;
import com.example.gui_f.viewmodel.noctua.NewUser.NewUserImpl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewUserStep2Activity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText relation;
    private Button login;
    private Intent i;

    private ResponsibleDTO responsible = new ResponsibleDTO();
    private UserDTO received = new UserDTO();
    private NewUser newUser = new NewUserImpl();
    private int result;
    private Context context = this;

    private UserAlreadyExists userAlreadyExists = new UserAlreadyExists();
    private GenericError genericError = new GenericError();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_step2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       name = (EditText) findViewById(R.id.editNameResponsible);
       email = (EditText) findViewById(R.id.editEmailResponsible);
       relation = (EditText) findViewById(R.id.editRelation);
       login = (Button) findViewById(R.id.btnSignOn);

       if(savedInstanceState != null){
           name.setText(savedInstanceState.getString("Name"));
           email.setText(savedInstanceState.getString("Email"));
           relation.setText(savedInstanceState.getString("Relation"));
       }
    }

    @Override
    protected void onStart() {
        super.onStart();

        i = getIntent();

        received = (UserDTO) i.getParcelableExtra("user");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsible.setEmail(email.getText().toString());
                responsible.setName(name.getText().toString());
                responsible.setRelation(relation.getText().toString());
                received.setResponsible(responsible);

                result = newUser.registerNewUser(received, context);
                if(result == 0){
                    showErrorDialog();
                } else if(result == 1) {
                    showUserRegisteredDialog();
                    Intent intent = new Intent(v.getContext(), MainScreenActivity.class);
                    intent.putExtra("user", received);

                    startActivity(intent);
                    finish();
                } else if(result == 2) {
                    showUserExistsDialog();
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
        super.onSaveInstanceState(outState);
        outState.putString("Name", name.getText().toString());
        outState.putString("Email", email.getText().toString());
        outState.putString("Relation", relation.getText().toString());
    }

    public void showErrorDialog(){
        new AlertDialog.Builder(NewUserStep2Activity.this)
                .setMessage(R.string.Error)
                .setNeutralButton(R.string.Okay, null)
                .show();
    }

    public void showUserRegisteredDialog(){
        new AlertDialog.Builder(NewUserStep2Activity.this)
                .setMessage(R.string.NewUserSuccess)
                .setNeutralButton(R.string.Okay, null)
                .show();
    }

    public void showUserExistsDialog(){
        new AlertDialog.Builder(NewUserStep2Activity.this)
                .setMessage(R.string.UserAlreadyExists)
                .setNeutralButton(R.string.Cancel, null)
                .show();
    }
}
