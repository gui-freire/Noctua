package com.example.gui_f.model.noctua.MainScreen;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gui_f.model.noctua.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public class MainScreenServiceImpl implements MainScreenService {

    private VitalResponse vital = new VitalResponse();
    private JSONObject json = new JSONObject();
    private List<VitalResponse> vitalList = new ArrayList<>();
    private String webserviceUri = "http://jfjosajfsjaf";

    @Override
    public VitalResponse searchLast(int id, Context context) {
        try{
            json.put("id", id);
            Log.d("SearchLast", "Sending user to webservice");

            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, webserviceUri, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject("vitals");
                                vital.setHeartbeats(jsonObject.getString("heartbeat"));
                                vital.setPression(jsonObject.getString("pression"));

                            } catch (JSONException je) {
                                Log.d("JsonMainScreenError", "Something went wrong on the webservice call " + je.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(error.getMessage());
                }
            });

            AppController.getInstance(context).addToRequestQueue(request);
            //Mock
            vital.setHeartbeats("68");
            vital.setPression("11/8");

            return vital;
        } catch (JSONException je){
            Log.d("SearchLastJsonFail", "Error in sending user to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.d("SearchLastFail", "Error in sending user to webservice " + e.getMessage());
            return null;
        }


    }

    @Override
    public List<VitalResponse> searchDaily(int id, int day, Context context) {
        try{
            json.put("id", id);
            json.put("day", day);
            Log.i("SearchDay", "Sending user and day to webservice");

            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, webserviceUri, json,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject("vitals");
                                Iterator<String> temp = jsonObject.keys();
//                                while(1 == 0){
//                                    String key = temp.next();
//                                    JSONArray obj = jsonObject.getJSONArray(key);
//                                    vital.setPression("kfak");
//                                }
                                vital.setHeartbeats(jsonObject.getString("heartbeat"));
                                vital.setPression(jsonObject.getString("pression"));

                            } catch (JSONException je) {
                                Log.d("JsonMainScreenError", "Something went wrong on the webservice call " + je.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(error.getMessage());
                }
            });

            AppController.getInstance(context).addToRequestQueue(request);

            vital.setPression("10/7");
            vital.setHeartbeats("72");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setPression("10/8");
            vital.setHeartbeats("75");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setPression("10/3");
            vital.setHeartbeats("74");
            vitalList.add(vital);

            return vitalList;
        } catch (JSONException je){
            Log.d("SearchDayJsonFail", "Error in sending user and day to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.d("SearchDayFail", "Error in sending user and day to webservice " + e.getMessage());
            return null;
        }


        //TODO: ver como iterar pela lista do JSON


    }

    @Override
    public List<VitalResponse> searchWeekly(int id, int week, int month, Context context) {
        try{
            json.put("id", id);
            json.put("week", week);
            json.put("month", month);
            Log.i("SearchWeek", "Sending user, week and month to webservice");

            vital.setHeartbeats("60");
            vital.setPression("11/10");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setHeartbeats("64");
            vital.setPression("13/10");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setHeartbeats("67");
            vital.setPression("16/10");
            vitalList.add(vital);

            return vitalList;
        }catch (JSONException je){
            Log.d("SearchWeekJsonFail", "Error in sending user, week and month to webservice " + je.getMessage());
            return null;
        }catch (Exception e){
            Log.d("SearchWeekFail", "Error in sending user, week and month to webservice " + e.getMessage());
            return null;
        }


    }

    @Override
    public List<VitalResponse> searchMonthly(int id, int month, Context context) {
        try{
            json.put("id", id);
            json.put("month", month);
            Log.i("SearchMonth", "Sending user and month to webservice");

            vital.setHeartbeats("69");
            vital.setPression("13/9");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setHeartbeats("60");
            vital.setPression("11/10");
            vitalList.add(vital);
            vital = new VitalResponse();

            vital.setHeartbeats("60");
            vital.setPression("11/13");
            vitalList.add(vital);

            return vitalList;
        } catch (JSONException je){
            Log.i("SearchMonthJsonFail", "Error in sending user and month to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.i("SearchMonthJsonFail", "Error in sending user and month to webservice " + e.getMessage());
            return null;
        }
    }
}
