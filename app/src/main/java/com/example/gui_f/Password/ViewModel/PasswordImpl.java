package com.example.gui_f.Password.ViewModel;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.Password.Request.PasswordService;
import com.example.gui_f.Password.Request.PasswordServiceImpl;

/**
 * Created by gui-f on 06/01/2018.
 */

public class PasswordImpl implements Password{

    private PasswordService passwordService = new PasswordServiceImpl();

    @Override
    public boolean forgotPassword(String email, Context context) {
        Log.d("PasswordActivity", "Sending email to service");
        try{
            return passwordService.forgotPassword(email, context);
        } catch (Exception e){
            Log.d("PasswordError", "Error in forgotPassoword " + e.getMessage());
            return false;
        }
    }
}
