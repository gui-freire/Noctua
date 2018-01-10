package com.example.gui_f.viewmodel.noctua;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.Login.LoginService;
import com.example.gui_f.model.noctua.Login.LoginServiceImpl;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginImpl implements Login {
    private LoginService login = new LoginServiceImpl();

    @Override
    public UserDTO searchUser(String user, String password, Context context) {
        Log.i("SearchUser", "Sending user to service");
        return login.searchUser(user, password, context);
    }
}
