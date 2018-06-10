package com.example.gui_f.model.noctua.Login;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 23/12/2017.
 */

public interface LoginService {
    UserDTO searchUser(String user, String password, String firebaseKey, Context context, final JsonCallback jsonCallback);
}
