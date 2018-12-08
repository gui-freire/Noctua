package com.example.gui_f.Login.ViewModel;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.Login.Request.LoginService;
import com.example.gui_f.Login.Request.LoginServiceImpl;
import com.example.gui_f.Domain.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginImpl implements Login {
    private LoginService login = new LoginServiceImpl();

    @Override
    public UserDTO searchUser(String user, String password, String firebaseKey, Context context, final JsonCallback jsonCallback) {
        Log.i("SearchUser", "Sending user to service");
        return login.searchUser(user, password, firebaseKey, context, jsonCallback);
    }
}
