package com.example.gui_f.viewmodel.noctua.Login;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 23/12/2017.
 */

public interface Login {
    UserDTO searchUser(String user, String password, String firebaeKey, Context context, final JsonCallback callback);
}
