package com.example.gui_f.model.noctua.NewUser;

import android.content.Context;

import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.ServerCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface NewUserService {
    void registerNewUser(UserDTO user, Context context, final ServerCallback callback);
}
