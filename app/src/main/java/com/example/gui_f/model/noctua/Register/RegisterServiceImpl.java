package com.example.gui_f.model.noctua.Register;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gui_f.Constants;
import com.example.gui_f.model.noctua.AppController;
import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 03/01/2018.
 */

public class RegisterServiceImpl implements RegisterService {

    private JSONObject json = new JSONObject();
    private String webserviceUri = Constants.URL + "/Noctua/mudar/mudarUsuario";
    private String httpResponse;

    @Override
    public boolean changeData(UserDTO user, Context context, final JsonCallback jsonCallback) {
        try{
            json.put("id", user.getId());
            json.put("name", user.getName());
            json.put("surname", user.getSurname());
            json.put("email", user.getEmail());
            json.put("nameResp", user.getNameResp());
            json.put("surnameResp", user.getSurnameResp());
            json.put("emailResp", user.getEmailResp());

            Log.i("Register", "User with changes sent to service");

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            jsonCallback.onSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(error.getMessage());
                }
            });

            AppController.getInstance(context).addToRequestQueue(request);

            if(httpResponse == "200"){
                return true;
            } else{
                return false;
            }

        } catch (JSONException je){
            Log.i("RegisterJsonError", "Error in sending changed user to service " + je.getMessage());
            return false;
        } catch (Exception e){
            Log.i("RegisterError", "Error in sending changed user to service " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean changeResponsible(String user, UserDTO userDTO, Context context, final JsonCallback jsonCallback) {
        try{
            json.put("id", userDTO.getId());
            json.put("name", userDTO.getName());
            json.put("surname", userDTO.getSurname());
            json.put("email", userDTO.getEmail());
            json.put("nameResp", userDTO.getNameResp());
            json.put("surnameResp", userDTO.getSurnameResp());
            json.put("emailResp", userDTO.getEmailResp());

            Log.i("RegisterResponsible", "Sending responsible to service");
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            jsonCallback.onSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(error.getMessage());
                }
            });

            AppController.getInstance(context).addToRequestQueue(request);
            return true;
        } catch (JSONException je){
            Log.i("RegisterRespJsonError", "Error in sending responsible to service " + je.getMessage());
            return false;
        } catch (Exception e){
            Log.i("RegisterRespError", "Error in sending responsible to service " + e.getMessage());
            return false;
        }
    }
}
