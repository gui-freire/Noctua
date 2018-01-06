package com.example.gui_f.model.noctua.Password;

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 06/01/2018.
 */

public class PasswordServiceImpl implements PasswordService {

    private JSONObject json = new JSONObject();

    @Override
    public void forgotPassword(String email) {
        try{
            json.put("email", email);

            //TODO:fazer chamada no metodo
        } catch (JSONException je){
            Log.i("PasswordJsonError", "Error in sending email to service " + je.getMessage());
        } catch (Exception e){
            Log.i("PasswordError", "Error in sending email to service " + e.getMessage());
        }
    }
}
