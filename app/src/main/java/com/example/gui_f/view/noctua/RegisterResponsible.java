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

public class RegisterResponsible extends AppCompatActivity {

    private EditText responsibleName;
    private EditText responsibleEmail;
    private EditText relation;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_responsible);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        responsibleName = (EditText) findViewById(R.id.editNameResponsibleRegister);
        responsibleEmail = (EditText) findViewById(R.id.editEmailResponsibleRegister);
        relation = (EditText) findViewById(R.id.editRelationRegister);
        save = (Button) findViewById(R.id.btnRespRegisterSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RegisterResponsible.RESULT_OK);
                finish();
            }
        });
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
        finish();
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

}
