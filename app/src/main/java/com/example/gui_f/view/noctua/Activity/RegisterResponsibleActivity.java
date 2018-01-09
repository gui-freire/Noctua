package com.example.gui_f.view.noctua.Activity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
import com.example.gui_f.viewmodel.noctua.Register.Register;
import com.example.gui_f.viewmodel.noctua.Register.RegisterImpl;

public class RegisterResponsibleActivity extends AppCompatActivity {

    private EditText responsibleName;
    private EditText responsibleEmail;
    private EditText relation;
    private Button save;

    private ResponsibleDTO dto = new ResponsibleDTO();
    private Register register = new RegisterImpl();

    private Intent intent;

    private String email;

    private boolean result;
    private GenericError genericError = new GenericError();

    private UserDTO received = new UserDTO();
    private ResponsibleDTO receivedResp = new ResponsibleDTO();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_responsible);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        responsibleName = (EditText) findViewById(R.id.editNameResponsibleRegister);
        responsibleEmail = (EditText) findViewById(R.id.editEmailResponsibleRegister);
        relation = (EditText) findViewById(R.id.editRelationRegister);
        save = (Button) findViewById(R.id.btnRespRegisterSave);

        intent = getIntent();
        received = intent.getParcelableExtra("user");
        receivedResp = received.getResponsible();

        responsibleName.setText(receivedResp.getName());
        responsibleEmail.setText(receivedResp.getEmail());
        relation.setText(receivedResp.getRelation());

        if(savedInstanceState != null){
            responsibleName.setText(savedInstanceState.getString("Name"));
            responsibleEmail.setText(savedInstanceState.getString("Email"));
            relation.setText(savedInstanceState.getString("Relation"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dto.setEmail(responsibleEmail.getText().toString());
                dto.setName(responsibleName.getText().toString());
                dto.setRelation(relation.getText().toString());
                email = intent.getStringExtra("Email");

                result = register.changeResponsible(email, dto);

                if(result){
                    finish();
                } else {
//                    genericError.setMessage(R.string.Error);
//                    genericError.onCreateDialog(savedInstanceState);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Name", responsibleName.getText().toString());
        outState.putString("Email", responsibleEmail.getText().toString());
        outState.putString("Relation", relation.getText().toString());
    }

    private void showDialog() {
        Fragment newFragment = DialogFragment.instantiate(this, "Tem certeza de que deseja sair sem salvar?");
//        newFragment.
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
        dto.setEmail(responsibleEmail.getText().toString());
        dto.setName(responsibleName.getText().toString());
        dto.setRelation(relation.getText().toString());
        email = intent.getStringExtra("Email");

        result = register.changeResponsible(email, dto);

        if(result){
            finish();
        } else {
//                    genericError.setMessage(R.string.Error);
//                    genericError.onCreateDialog(savedInstanceState);
        }

        finish();
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
        finish();
    }

//    @Override
//    public void onBackPressed() {
//        showDialog();
//    }

}