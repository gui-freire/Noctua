package com.example.gui_f.viewmodel.noctua.Register;

import android.util.Log;

import com.example.gui_f.model.noctua.Register.RegisterService;
import com.example.gui_f.model.noctua.Register.RegisterServiceImpl;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 03/01/2018.
 */

public class RegisterImpl implements Register {

    RegisterService registerService = new RegisterServiceImpl();

    @Override
    public boolean changeData(UserDTO user) {
        Log.i("ChangeData", "Sending user to service");
        return registerService.changeData(user);
    }
}
