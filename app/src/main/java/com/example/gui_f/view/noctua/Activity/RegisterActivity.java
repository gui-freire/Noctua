package com.example.gui_f.view.noctua.Activity;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
import com.example.gui_f.view.noctua.WarnigSaveDialog;
import com.example.gui_f.viewmodel.noctua.Register.Register;
import com.example.gui_f.viewmodel.noctua.Register.RegisterImpl;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText birthday;
    private EditText email;
    private Button save;
    private Button responsible;
    private Register register = new RegisterImpl();
    private UserDTO user = new UserDTO();

    private GenericError genericError = new GenericError();

    private Context context = this;

    private Intent i;

    private UserDTO received = new UserDTO();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        i = getIntent();
        received = i.getParcelableExtra("user");

        name = (EditText) findViewById(R.id.editRegisterName);
        surname = (EditText) findViewById(R.id.editRegisterSurname);
        birthday = (EditText) findViewById(R.id.editRegisterBirthday);
        email = (EditText) findViewById(R.id.editRegisterEmail);
        save = (Button) findViewById(R.id.btnRegisterSave);
        responsible = (Button) findViewById(R.id.btnRegisterResp);

        name.setText(received.getName());
        surname.setText(received.getSurname());
        birthday.setText(received.getBirthday());
        email.setText(received.getEmail());

        if(savedInstanceState != null){
            name.setText(savedInstanceState.getString("Name"));
            surname.setText(savedInstanceState.getString("Surname"));
            birthday.setText(savedInstanceState.getString("Birthday"));
            email.setText(savedInstanceState.getString("Email"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        responsible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterResponsibleActivity.class);
                intent.putExtra("user", received);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                user.setBirthday(birthday.getText().toString());
                user.setEmail(email.getText().toString());
                boolean result = register.changeData(user, context);
                if(result){
                    finish();
                }
                else{
                    //genericError.setMessage(R.string.Error);
//                    genericError.onCreateDialog(savedInstanceState);
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
        outState.putString("Surname", surname.getText().toString());
        outState.putString("Birthday", birthday.getText().toString());
        outState.putString("Email", email.getText().toString());
    }

    private void showDialog() {
        DialogFragment newFragment = WarnigSaveDialog.newInstance(R.string.warning_save);
        newFragment.show(getFragmentManager(), "tag");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
        user.setName(name.getText().toString());
        user.setSurname(surname.getText().toString());
        user.setBirthday(birthday.getText().toString());
        user.setEmail(email.getText().toString());
        boolean result = register.changeData(user, context);
        if(result){
            finish();
        }
        else{
            //genericError.setMessage(R.string.Error);
//                    genericError.onCreateDialog(savedInstanceState);
        };
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
        finish();
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }
}
