package com.example.gui_f.viewmodel.noctua.NewUser;

import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface NewUser {
    int registerNewUser(UserDTO user);
    //0 - Error
    //1 - User registered
    //2 - User already exists
}