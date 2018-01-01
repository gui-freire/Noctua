package com.example.gui_f.model.noctua.MainScreen;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gui-f on 01/01/2018.
 */

public class MainScreenServiceImpl implements MainScreenService {

    VitalResponse vital = new VitalResponse();
    JSONObject json = new JSONObject();

    //TODO: FAZER CHAMADAS NOS SERVIÇOS
    @Override
    public VitalResponse searchLast(String user) {
        try{
            json.put("user", user);
            Log.i("SearchLast", "Sending user to webservice");

            //Mock
            vital.setHeartbeats("68");
            vital.setPression("11/8");

            return vital;
        } catch (JSONException je){
            Log.i("SearchLastJsonFail", "Error in sending user to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.i("SearchLastFail", "Error in sending user to webservice " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchDaily(String user, int day) {
        try{
            json.put("user", user);
            json.put("day", day);
            Log.i("SearchDay", "Sending user and day to webservice");

            vital.setPression("10/7");
            vital.setHeartbeats("72");

            return vital;
        } catch (JSONException je){
            Log.i("SearchDayJsonFail", "Error in sending user and day to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.i("SearchDayFail", "Error in sending user and day to webservice " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchWeekly(String user, int week, int month) {
        try{
            json.put("user", user);
            json.put("week", week);
            json.put("month", month);
            Log.i("SearchWeek", "Sending user, week and month to webservice");

            vital.setHeartbeats("60");
            vital.setHeartbeats("11/10");

            return vital;
        }catch (JSONException je){
            Log.i("SearchWeekJsonFail", "Error in sending user, week and month to webservice " + je.getMessage());
            return null;
        }catch (Exception e){
            Log.i("SearchWeekFail", "Error in sending user, week and month to webservice " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchMonthly(String user, int month) {
        try{
            json.put("user", user);
            json.put("month", month);
            Log.i("SearchMonth", "Sending user and month to webservice");

            vital.setHeartbeats("69");
            vital.setPression("13/9");

            return vital;
        } catch (JSONException je){
            Log.i("SearchMonthJsonFail", "Error in sending user and month to webservice " + je.getMessage());
            return null;
        } catch (Exception e){
            Log.i("SearchMonthJsonFail", "Error in sending user and month to webservice " + e.getMessage());
            return null;
        }
    }
}
