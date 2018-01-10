package com.example.gui_f.viewmodel.noctua;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 23/12/2017.
 */

public interface Login {
    UserDTO searchUser(String user, String password, Context context);
}
