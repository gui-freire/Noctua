package com.example.gui_f.model.noctua.Login;

import android.util.Log;

import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginServiceImpl implements LoginService {

    LoginRequest request = new LoginRequest();
    UserDTO userReturn = new UserDTO();

    @Override
    public UserDTO searchUser(String user) {
        JSONObject json = new JSONObject();

        try{
            json.put("user", user);

            userReturn = request.searchUser(json);

            return userReturn;
        } catch(JSONException je){
            Log.i("SearchUserFail", "Error sending user for search " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.i("SearchUserFail", "Error sending user for search " + e.getMessage());
            return null;
        }
    }
}
