package com.example.gui_f.Password.Request;

import android.content.Context;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 06/01/2018.
 */

public class PasswordServiceImpl implements PasswordService {

    private JSONObject json = new JSONObject();
    private String webserviceUri = "http://jfajflksla";
    private String httpResponse;

    @Override
    public boolean forgotPassword(final String email, Context context) {
        try{
            json.put("email", email);
            return true;
            //TODO:fazer chamada no metodo
        } catch (JSONException je){
            Log.d("PasswordJsonError", "Error in sending email to service " + je.getMessage());
            return false;
        } catch (Exception e){
            Log.d("PasswordError", "Error in sending email to service " + e.getMessage());
            return false;
        }

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            httpResponse = response.toString();
//                        } catch (Exception je) {
//                            Log.d("PasswordError", "Something went wrong on the webservice call " + je.getMessage());
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
//
//        if(httpResponse == "200"){
//            return true;
//        } else {
//            return false;
//        }
    }
}
