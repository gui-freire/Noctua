package com.example.gui_f.NewUser.Presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.Domain.UserDTO;
import com.example.gui_f.Home.Presentation.MainScreenActivity;
import com.example.gui_f.noctua.R;
import com.example.gui_f.utils.ServerCallback;
import com.example.gui_f.NewUser.ViewModel.NewUser;
import com.example.gui_f.NewUser.ViewModel.NewUserImpl;

public class NewUserStep2Activity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText surname;
    private Button login;
    private Intent i;

    private UserDTO received = new UserDTO();
    private NewUser newUser = new NewUserImpl();
    private int result;
    private Context context = this;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_step2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


       name = (EditText) findViewById(R.id.editNameResponsible);
       email = (EditText) findViewById(R.id.editEmailResponsible);
       surname = (EditText) findViewById(R.id.editRelation);
       login = (Button) findViewById(R.id.btnSignOn);

       if(savedInstanceState != null){
           name.setText(savedInstanceState.getString("Name"));
           email.setText(savedInstanceState.getString("Email"));
           surname.setText(savedInstanceState.getString("Surname"));
       }
    }

    @Override
    protected void onStart() {
        super.onStart();

        i = getIntent();

        received = (UserDTO) i.getParcelableExtra("user");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                received.setEmailResp(email.getText().toString());
                received.setNameResp(name.getText().toString());
                received.setSurnameResp(surname.getText().toString());

                newUser.registerNewUser(received, context, new ServerCallback() {
                    @Override
                    public void onSuccess(int result) {
                        if(result == 400){
                            showErrorDialog();
                        } else if(result == 200) {
                            showUserRegisteredDialog();
                            Intent intent = new Intent(v.getContext(), MainScreenActivity.class);
                            intent.putExtra("user", received);

                            startActivity(intent);
                            finish();
                        } else if(result == 2) {
                            showUserExistsDialog();
                        }
                    }

                    @Override
                    public void onError() {

                    }
                });

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
        outState.putString("Surname", surname.getText().toString());
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
