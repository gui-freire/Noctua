package com.example.gui_f.viewmodel.noctua.NewUser;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.NewUser.NewUserService;
import com.example.gui_f.model.noctua.NewUser.NewUserServiceImpl;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 03/01/2018.
 */

public class NewUserImpl implements NewUser {

    NewUserService newUserService = new NewUserServiceImpl();

    @Override
    public int registerNewUser(UserDTO user, Context context) {
        try{
            Log.i("RegisterNewUser", "User sent to service");
            return newUserService.registerNewUser(user, context);
        } catch(Exception e){
            Log.i("RegisterNewUserFail", "Error while user sent to service");
            return 0;
        }
    }
}
