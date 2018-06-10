package com.example.gui_f.viewmodel.noctua.NewUser;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.ServerCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface NewUser {
    void registerNewUser(UserDTO user, Context context, final ServerCallback callback);
    //0 - Error
    //1 - User registered
    //2 - User already exists
}
