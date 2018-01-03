package com.example.gui_f.view.noctua;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.noctua.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText birthday;
    private EditText email;
    private Button save;
    private Button responsible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.editRegisterName);
        surname = (EditText) findViewById(R.id.editRegisterSurname);
        birthday = (EditText) findViewById(R.id.editRegisterBirthday);
        email = (EditText) findViewById(R.id.editRegisterEmail);
        save = (Button) findViewById(R.id.btnRegisterSave);
        responsible = (Button) findViewById(R.id.btnRegisterResp);

        responsible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterResponsible.class);
                startActivityForResult(intent, 1);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RegisterResponsible.RESULT_OK){
            Intent intent = new Intent(this, MainScreenActivity.class);
            startActivity(intent);
        }
    }

    private void showDialog() {
        DialogFragment newFragment = WarnigSaveDialog.newInstance(R.string.warning_save);
        newFragment.show(getFragmentManager(), "tag");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
        Intent intent = new Intent(getBaseContext(), MainScreenActivity.class);
        startActivity(intent);
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }
}
