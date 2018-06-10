package com.example.gui_f.viewmodel.noctua.Register;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.Register.RegisterService;
import com.example.gui_f.model.noctua.Register.RegisterServiceImpl;
import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public class RegisterImpl implements Register {

    RegisterService registerService = new RegisterServiceImpl();

    @Override
    public boolean changeData(UserDTO user, Context context, final JsonCallback jsonCallback) {
        Log.d("ChangeData", "Sending user to service");
        try {
            return registerService.changeData(user, context, jsonCallback);
        }catch (Exception e){
            Log.d("ChangeDataError", "Error in sending Register! " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean changeResponsible(String email, UserDTO resp, Context context, final JsonCallback jsonCallback) {
        Log.i("ChangeResponsible", "Sending user to service");
        try{
            return registerService.changeResponsible(email, resp, context, jsonCallback);
        } catch (Exception e){
            Log.d("ChangeResponsibleError", "Error in sending Responsible Register! " + e.getMessage());
            return false;
        }
    }
}
