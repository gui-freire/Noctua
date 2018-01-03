package com.example.gui_f.view.noctua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.ObjectWrapperForBinder;
import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.viewmodel.noctua.NewUser.NewUser;
import com.example.gui_f.viewmodel.noctua.NewUser.NewUserImpl;

public class NewUserStep2Activity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText relation;
    private Button login;

    private ResponsibleDTO responsible = new ResponsibleDTO();
    private UserDTO received = new UserDTO();
    private NewUser newUser = new NewUserImpl();
    int result;

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

       responsible.setEmail(email.getText().toString());
       responsible.setName(name.getText().toString());
       responsible.setRelation(relation.getText().toString());

       received = ((ObjectWrapperForBinder)getIntent().getExtras().getBinder("user")).getData();
       received.setResponsible(responsible);

       //TODO: fazer chamada no webservice para salvar dados

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = newUser.registerNewUser(received);
                if(result == 0){
                    genericError.setMessage(R.string.Error);
                    genericError.onCreateDialog(savedInstanceState);
                } else if(result == 1) {
                    final Bundle bundle = new Bundle();
                    bundle.putBinder("user", new ObjectWrapperForBinder(received));
                    Intent intent = new Intent(v.getContext(), MainScreenActivity.class);
                    intent.putExtra("user", bundle);
                    startActivity(intent);
                    finish();
                } else if(result == 2){
                    userAlreadyExists.onCreateDialog(savedInstanceState);
                }
            }
        });

    }

}
