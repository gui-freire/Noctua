package com.example.gui_f.noctua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gui_f.ObjectWrapperForBinder;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.view.noctua.ForgotPwd;
import com.example.gui_f.view.noctua.MainScreen;
import com.example.gui_f.view.noctua.NewUserStep1;

public class Login extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button login;
    private TextView forgotPwd;
    private TextView newUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = (EditText) findViewById(R.id.editUser);
        password = (EditText) findViewById(R.id.editPassword);

        login = (Button) findViewById(R.id.btnLogin);
        forgotPwd = (TextView) findViewById(R.id.textForgotPwd);
        newUser = (TextView) findViewById(R.id.textNewUser);

        final String userText = user.getText().toString();
        String passwordText = user.getText().toString();

        //TODO: Fazer chamada do método de autenticação
        //UserDTO user = autentication(userText, passwordText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*
            if(user != null){
                Intent intent = new Intent(this, MainScreen.class);
                intent.putExtra("user", user);
                startActivity(intent);
            */
             UserDTO user = new UserDTO();
             user.setHeartbeats("68");
             user.setPression("11/8");
             user.setName("Guilherme");
             final Bundle bundle = new Bundle();
             bundle.putBinder("user", new ObjectWrapperForBinder(user));
            Intent intent = new Intent(v.getContext(), MainScreen.class);
            intent.putExtra("user", bundle);
            startActivity(intent);
            finish();
            }
        });

        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ForgotPwd.class);
                startActivity(intent);
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewUserStep1.class);
                startActivity(intent);
                finish();
            }
        });

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

}
