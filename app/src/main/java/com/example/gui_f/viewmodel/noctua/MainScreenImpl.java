package com.example.gui_f.viewmodel.noctua;

import android.util.Log;

import com.example.gui_f.model.noctua.MainScreen.MainScreenService;
import com.example.gui_f.model.noctua.MainScreen.MainScreenServiceImpl;
import com.example.gui_f.model.noctua.MainScreen.VitalResponse;

/**
 * Created by gui-f on 01/01/2018.
 */

public class MainScreenImpl implements MainScreen {

    private MainScreenService mainScreenService = new MainScreenServiceImpl();
    private VitalResponse vital = new VitalResponse();

    @Override
    public VitalResponse searchLast(String user) {
        try{
            Log.i("SearchLast","Sending data to MainScreenService");
            vital = mainScreenService.searchLast(user);

            if(vital == null){
                Log.i("SearchLastNull", "Error in MainScreenServiceImpl");
                return null;
            } else{
                return vital;
            }
        } catch (Exception e){
            Log.i("SearchLastFail", "Error in searchLast " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchDaily(String user, int day) {
        try{
            Log.i("SearchDay", "Sending data to MainScreenService");
            vital = mainScreenService.searchDaily(user, day);

            if(vital == null){
                Log.i("SearchDayNull", "Error in MainScreenServiceImpl");
                return null;
            } else{
                return vital;
            }
        }catch (Exception e){
            Log.i("SearchDayFail", "Error in searchDaily " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchWeekly(String user, int week, int month) {
        try{
            Log.i("SearchWeek", "Sending data to MainScreenService");
            vital = mainScreenService.searchWeekly(user, week, month);

            if(vital == null){
                Log.i("SearchWeekNull", "Error in MainScreenServiceImpl");
                return null;
            } else{
                return vital;
            }
        }catch (Exception e){
            Log.i("SearchWeekFail", "Error in searchWeekly " + e.getMessage());
            return null;
        }
    }

    @Override
    public VitalResponse searchMonthly(String user, int month) {
        try{
            Log.i("SearchMonth", "Sending data to MainScreenService");
            vital = mainScreenService.searchMonthly(user, month);

            if(vital == null){
                Log.i("SearchMonthNull", "Error in MainScreenServiceImpl");
                return null;
            } else{
                return vital;
            }
        }catch (Exception e){
            Log.i("SearchMonthFail", "Error in searchMonthly " + e.getMessage());
            return null;
        }
    }
}
