package com.example.gui_f.model.noctua.Register;

import android.util.Log;

import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 03/01/2018.
 */

public class RegisterServiceImpl implements RegisterService {

    JSONObject json = new JSONObject();

    @Override
    public boolean changeData(UserDTO user) {
        try{
            json.put("name", user.getName());
            json.put("surname", user.getSurname());
            json.put("birthday", user.getBirthday());
            json.put("email", user.getEmail());
            json.accumulate("responsible", user.getResponsible());

            Log.i("Register", "User with changes sent to service");

            //TODO: FAZER CHAMADA DO SERVIÇO
            //return chamada
            return true;
        } catch (JSONException je){
            Log.i("RegisterJsonError", "Error in sending changed user to service " + je.getMessage());
            return false;
        } catch (Exception e){
            Log.i("RegisterError", "Error in sending changed user to service " + e.getMessage());
            return false;
        }
    }
}
