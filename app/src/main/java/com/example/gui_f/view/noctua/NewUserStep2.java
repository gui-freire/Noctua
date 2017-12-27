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

import com.example.gui_f.ObjectWrapperForBinder;
import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;

public class NewUserStep2 extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText relation;
    private Button login;

    private ResponsibleDTO responsible = new ResponsibleDTO();
    private UserDTO received = new UserDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                final Bundle bundle = new Bundle();
                bundle.putBinder("user", new ObjectWrapperForBinder(received));
                Intent intent = new Intent(v.getContext(), MainScreen.class);
                intent.putExtra("user", bundle);
                startActivity(intent);
                finish();
            }
        });

    }

}
