package com.example.gui_f.view.noctua.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.Login;
import com.example.gui_f.viewmodel.noctua.LoginImpl;
import com.example.gui_f.viewmodel.noctua.MainScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button login;
    private TextView forgotPwd;
    private TextView newUser;
    private Login loginImpl = new LoginImpl();

    private String passwordText;
    private String userText;

    private UserDTO userDTO;

    private Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = (EditText) findViewById(R.id.editUser);
        password = (EditText) findViewById(R.id.editPassword);

        login = (Button) findViewById(R.id.btnLogin);
        forgotPwd = (TextView) findViewById(R.id.textForgotPwdLoginScreen);
        newUser = (TextView) findViewById(R.id.textNewUserLoginScreen);


        if(savedInstanceState != null){
            user.setText(savedInstanceState.getString("User"));
            password.setText(savedInstanceState.getString("Password"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();


        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), PasswordActivity.class);
                startActivity(intent2);
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), NewUserStep1Activity.class);
                startActivity(intent3);
                finish();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText = user.getText().toString();
                passwordText = password.getText().toString();

                userDTO = loginImpl.searchUser(userText, passwordText, context);
                if(!userDTO.isExists()){
                    showIncorrectDialog();
                }
                else if(userDTO != null) {
                    Intent mainIntent = new Intent(LoginActivity.this, MainScreenActivity.class);
                    mainIntent.putExtra("user", userDTO);
                    startActivity(mainIntent);
                    finish();
                } else{
                    showInexistentDialog();
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
        outState.putString("User", user.getText().toString());
        outState.putString("Password", password.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showIncorrectDialog(){
        new AlertDialog.Builder(LoginActivity.this)
                .setMessage(R.string.IncorrectUser)
                .setNeutralButton(R.string.Okay, null)
                .show();
    }

    public void showInexistentDialog(){
        new AlertDialog.Builder(LoginActivity.this)
                .setMessage(R.string.UserAlreadyExists)
                .setPositiveButton(R.string.CreateNew, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LoginActivity.this, NewUserStep1Activity.class);
                        startActivity(intent);
                        ((Activity) context).finish();
                    }
                })
                .setNegativeButton(R.string.Okay, null)
                .show();
    }

}
