package com.example.gui_f.viewmodel.noctua.Password;

import android.util.Log;

import com.example.gui_f.model.noctua.Password.PasswordService;
import com.example.gui_f.model.noctua.Password.PasswordServiceImpl;

/**
 * Created by gui-f on 06/01/2018.
 */

public class PasswordImpl implements Password{

    private PasswordService passwordService = new PasswordServiceImpl();

    @Override
    public void forgotPassword(String email) {
        Log.i("PasswordActivity", "Sending email to service");
    }
}
