package com.example.gui_f.UpdateUser.Presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gui_f.Domain.ResponsibleDTO;
import com.example.gui_f.Domain.UserDTO;
import com.example.gui_f.noctua.R;
import com.example.gui_f.utils.JsonCallback;
import com.example.gui_f.UpdateUser.ViewModel.Register;
import com.example.gui_f.UpdateUser.ViewModel.RegisterImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterResponsibleActivity extends AppCompatActivity {

    private EditText responsibleName;
    private EditText responsibleEmail;
    private EditText surname;
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
        surname = (EditText) findViewById(R.id.editRelationRegister);
        save = (Button) findViewById(R.id.btnRespRegisterSave);

        intent = getIntent();
        received = intent.getParcelableExtra("user");
        receivedResp = received.getResponsible();

        responsibleName.setText(receivedResp.getName());
        responsibleEmail.setText(receivedResp.getEmail());
        surname.setText(receivedResp.getRelation());


        if(savedInstanceState != null){
            responsibleName.setText(savedInstanceState.getString("Name"));
            responsibleEmail.setText(savedInstanceState.getString("Email"));
            surname.setText(savedInstanceState.getString("Relation"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                received.setEmailResp(responsibleEmail.getText().toString());
                received.setNameResp(responsibleName.getText().toString());
                received.setSurnameResp(surname.getText().toString());
                email = intent.getStringExtra("Email");

                register.changeResponsible(email, received, context, new JsonCallback() {
                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        int ret = 0;
                        try{
                            ret = jsonObject.getInt("key");
                        } catch (JSONException je){

                        }
                        if(ret == 200){
                            finish();
                        }
                    }

                    @Override
                    public void onError() {

                    }
                });
                }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Name", responsibleName.getText().toString());
        outState.putString("Email", responsibleEmail.getText().toString());
        outState.putString("Surname", surname.getText().toString());
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
                        received.setEmailResp(responsibleEmail.getText().toString());
                        received.setNameResp(responsibleName.getText().toString());
                        received.setSurnameResp(surname.getText().toString());
                        email = intent.getStringExtra("Email");

                        register.changeResponsible(email, received, context, new JsonCallback() {
                            @Override
                            public void onSuccess(JSONObject jsonObject) {
                                int ret = 0;
                                try{
                                    ret = jsonObject.getInt("key");
                                } catch (JSONException je){

                                }
                                if(ret == 200){
                                    setProgressBarIndeterminateVisibility(false);
                                    finish();
                                    ((Activity) context).finish();
                                } else{
                                    setProgressBarIndeterminateVisibility(false);
                                    showErrorDialog();
                                }
                            }

                            @Override
                            public void onError() {

                            }
                        });


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
