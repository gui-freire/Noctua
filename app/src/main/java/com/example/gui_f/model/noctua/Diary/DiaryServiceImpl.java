package com.example.gui_f.model.noctua.Diary;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gui_f.Constants;
import com.example.gui_f.model.noctua.AppController;
import com.example.gui_f.utils.JsonCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 27/12/2017.
 */

public class DiaryServiceImpl implements DiaryService {

    private JSONObject json = new JSONObject();
    private String webserviceUri = Constants.URL + "/Noctua/diario/enviarDiario";
    private String httpResponse;

    @Override
    public boolean sendFeeling(String user, String feel, Context context, final JsonCallback jsonCallback) {
        try{
            json.put("User", user);
            json.put("Feeling", feel.toString());
            Log.i("SendFeeling", "Sending feeling to request");
            return true;
        } catch (Exception e){
            Log.i("SendFeelingError", "Error sending feeling to request: " + e.getMessage());
            return false;
        }

//        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            httpResponse = response.toString();
//                        } catch (JSONException je) {
//                            Log.d("JsonDiaryError", "Something went wrong on the webservice call " + je.getMessage())
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
//        } else{
//            return false;
//        }
    }

    @Override
    public boolean sendDiary(String user, String diary, String feel, Context context, final JsonCallback jsonCallback) {
        try{
            json.put("User", user);
            json.put("DiaryActivity", diary);
            json.put("Feeling", feel);
            Log.i("SendDiary", "Sending diary to request");

            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, webserviceUri, json,
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

        } catch (Exception e){
            Log.i("SendDiaryError", "Error sending diary to request: " + e.getMessage());
            return false;
        }
    }
}
