package com.example.gui_f.model.noctua.NewUser;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gui_f.model.noctua.AppController;
import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 03/01/2018.
 */

public class NewUserServiceImpl implements NewUserService {
    private JSONObject json = new JSONObject();
    private String webserviceUri;
    private String httpResponse;

    @Override
    public int registerNewUser(UserDTO user, Context context) {
        try{
            json.put("name", user.getName());
            json.put("surname", user.getSurname());
            json.put("email", user.getEmail());
            json.put("nameResp", user.getNameResp());
            json.put("surnameResp", user.getSurnameResp());
            json.put("emailResp", user.getEmailResp());

            Log.i("RegisterNewUser", "User sent to service");

            //TODO: FAZER CHAMADA DO SERVIÇO
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                httpResponse = response.toString();
                            } catch (Exception je) {
                                Log.d("JsonNewUserError", "Something went wrong on the webservice call " + je.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(error.getMessage());
                }
            });

            AppController.getInstance(context).addToRequestQueue(request);
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
