package com.example.gui_f.view.noctua.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.GenericError;
import com.example.gui_f.viewmodel.noctua.NewUser.NewUser;
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

    private Context context = this;

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

                result = register.changeResponsible(email, dto, context);

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

    private void showAlertDialog() {
        new AlertDialog.Builder(RegisterResponsibleActivity.this)
        .setMessage(getResources().getString(R.string.warning_save))
        .setPositiveButton(getResources().getString(R.string.SaveFragment),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("FragmentAlertDialog", "Positive click!");
//                        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
                        setProgressBarIndeterminateVisibility(true);
                        dto.setEmail(responsibleEmail.getText().toString());
                        dto.setName(responsibleName.getText().toString());
                        dto.setRelation(relation.getText().toString());
                        email = intent.getStringExtra("Email");

                        result = register.changeResponsible(email, dto, context);

                        if(result){
                            setProgressBarIndeterminateVisibility(false);
                            finish();
                            ((Activity) context).finish();
                        } else{
                            setProgressBarIndeterminateVisibility(false);
                            showErrorDialog();
                        }
                    }
                })

        .setNegativeButton(getResources().getString(R.string.YesFragment),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("FragmentAlertDialog", "Negative click!");
                        finish();
                    }
                }).show();
    }


    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    public void showErrorDialog(){
        new AlertDialog.Builder(RegisterResponsibleActivity.this)
                .setMessage(getResources().getString(R.string.Error))
        .setNeutralButton(getResources().getString(R.string.Okay),null).show();
    }

    public void showSuccessDialog(){
        new AlertDialog.Builder(RegisterResponsibleActivity.this)
                .setMessage(getResources().getString(R.string.RegisterSuccess))
        .setNeutralButton(getResources().getString(R.string.Okay),null).show();
    }

}
