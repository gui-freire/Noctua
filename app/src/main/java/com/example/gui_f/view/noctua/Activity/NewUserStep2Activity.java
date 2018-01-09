package com.example.gui_f.view.noctua.Activity;

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
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    private UserAlreadyExists userAlreadyExists = new UserAlreadyExists();
    private GenericError genericError = new GenericError();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_step2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

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
        currentUser = mAuth.getCurrentUser();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                responsible.setEmail(email.getText().toString());
                responsible.setName(name.getText().toString());
                responsible.setRelation(relation.getText().toString());
                received.setResponsible(responsible);

                result = newUser.registerNewUser(received);
                mAuth.createUserWithEmailAndPassword(received.getEmail(), received.getPassword());
                if(result == 0){
//                    genericError.setMessage(R.string.Error);
//                    genericError.onCreateDialog(savedInstanceState);
                } else if(result == 1) {
                    Intent intent = new Intent(v.getContext(), MainScreenActivity.class);
                    intent.putExtra("user", received);

                    startActivity(intent);
                    finish();
                } else if(result == 2){
//                    userAlreadyExists.onCreateDialog(savedInstanceState);
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
}
