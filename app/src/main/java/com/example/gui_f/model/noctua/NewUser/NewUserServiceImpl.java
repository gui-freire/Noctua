package com.example.gui_f.model.noctua.NewUser;

import android.util.Log;

import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 03/01/2018.
 */

public class NewUserServiceImpl implements NewUserService {
    JSONObject json = new JSONObject();

    @Override
    public int registerNewUser(UserDTO user) {
        try{
            json.put("name", user.getName());
            json.put("surname", user.getSurname());
            json.put("birthday", user.getBirthday());
            json.put("email", user.getEmail());
            json.accumulate("responsible", user.getResponsible());

            Log.i("RegisterNewUser", "User sent to service");

            //TODO: FAZER CHAMADA DO SERVIÇO
            //return chamada
            return 1;
        } catch (JSONException je){
            Log.i("RegisterNwUserJsonError", "Error in sending user to service " + je.getMessage());
            return 0;
        } catch (Exception e){
            Log.i("RegisterNewUserError", "Error in sending user to service " + e.getMessage());
            return 0;
        }
    }
}
