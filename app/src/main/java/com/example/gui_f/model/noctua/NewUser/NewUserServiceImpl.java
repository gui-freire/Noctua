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

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            httpResponse = response.toString();
//                        } catch (JSONException je) {
//                            Log.d("JsonNewUserError", "Something went wrong on the webservice call " + je.getMessage())
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(error.getMessage());
//            }
//        });
//
//        AppController.getInstance(context).addToRequestQueue(request);
    }
}
