package com.example.gui_f.viewmodel.noctua.NewUser;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.NewUser.NewUserService;
import com.example.gui_f.model.noctua.NewUser.NewUserServiceImpl;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.ServerCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public class NewUserImpl implements NewUser {

    NewUserService newUserService = new NewUserServiceImpl();

    @Override
    public void registerNewUser(UserDTO user, Context context, final ServerCallback callback) {
        try{
            Log.i("RegisterNewUser", "User sent to service");
            newUserService.registerNewUser(user, context, callback);
        } catch(Exception e){
            Log.i("RegisterNewUserFail", "Error while user sent to service");
//            return 0;
        }
    }
}
