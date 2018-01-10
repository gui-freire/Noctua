package com.example.gui_f.model.noctua.Register;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gui_f.model.noctua.AppController;
import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 03/01/2018.
 */

public class RegisterServiceImpl implements RegisterService {

    private JSONObject json = new JSONObject();
    private String webserviceUri = "http://jfsajfsa";
    private String httpResponse;

    @Override
    public boolean changeData(UserDTO user, Context context) {
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

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            httpResponse = response.toString();
//                        } catch (Exception e){
//                            Log.d("RegisterError", "Something went wrong on the webservice call " + e.getMessage());
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

//        if(httpResponse == "200"){
//            return true;
//        } else{
//            return false;
//        }
    }

    @Override
    public boolean changeResponsible(String user, ResponsibleDTO responsibleDTO, Context context) {
        try{
            json.put("user", user);
            json.accumulate("responsible", responsibleDTO);

            Log.i("RegisterResponsible", "Sending responsible to service");
            return true;
        } catch (JSONException je){
            Log.i("RegisterRespJsonError", "Error in sending responsible to service " + je.getMessage());
            return false;
        } catch (Exception e){
            Log.i("RegisterRespError", "Error in sending responsible to service " + e.getMessage());
            return false;
        }

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            httpResponse = response.toString();
//                        } catch (Exception e) {
//                            Log.d("JsonLoginError", "Something went wrong on the webservice call " + e.getMessage());
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
