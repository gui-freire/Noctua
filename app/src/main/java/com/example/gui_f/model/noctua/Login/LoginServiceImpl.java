package com.example.gui_f.model.noctua.Login;

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
import com.example.gui_f.view.noctua.Activity.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginServiceImpl implements LoginService {

    private UserDTO userReturn = new UserDTO();
    private ResponsibleDTO dto = new ResponsibleDTO();
    private JSONObject responseRespons = new JSONObject();
    private JSONObject jsonObject = new JSONObject();

    private String webserviceUri = Constants.URL + "/Noctua/usuario/buscarUsuario";

    @Override
    public UserDTO searchUser(String user, String password, String firebaseKey, Context context, final JsonCallback jsonCallback) {

        try{
            jsonObject.put("email", user);
            jsonObject.put("password", password);
            jsonObject.put("firebaseId", firebaseKey);

            final JsonObjectRequest json = new JsonObjectRequest(Request.Method.POST, webserviceUri,jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                jsonCallback.onSuccess(response);
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.d("JsonLoginError", "Something went wrong on the webservice call " + e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error.networkResponse.statusCode == 404){
                        jsonCallback.onError();
                    }
                }
            });
            AppController.getInstance(context).addToRequestQueue(json);

        } catch(JSONException je){
            Log.i("SearchUserFail", "Error sending user for search " + je.getMessage());
            return null;
        } catch (Throwable e){
            Log.i("SearchUserFail", "Error sending user for search " + e.getMessage());
            e.printStackTrace();
            return null;
        }




        //MOCK
//        userReturn.setEmail("gui-freire@uol.com.br");
//        userReturn.setBirthday("30/04/1997");
//        userReturn.setName("Guilherme");
//        userReturn.setSurname("Freire");
//        userReturn.setExists(true);
//
//        dto.setName("Cristina");
//        dto.setRelation("Mãe");
//        dto.setEmail("cfmd@uol.com.br");

//        userReturn.setResponsible(dto);



        return userReturn;
    }

    private void parseJsonToUser(JSONObject resp){
        ResponsibleDTO dto = new ResponsibleDTO();
        try {
            dto.setRelation(resp.getString("relation"));
            dto.setName(resp.getString("nameResp"));
            dto.setEmail(resp.getString("emailResp"));

            userReturn.setResponsible(dto);
        } catch (JSONException je){
            Log.d("JsonParseError", "Something went wrong parsing JSON to ResponsibleDTO " + je.getMessage());
        }

    }
}

