package com.example.gui_f.model.noctua.Login;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 23/12/2017.
 */

public interface LoginService {
    UserDTO searchUser(String user, String password, Context context);
}
