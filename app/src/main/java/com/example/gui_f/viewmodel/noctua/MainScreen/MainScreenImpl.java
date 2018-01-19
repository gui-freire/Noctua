package com.example.gui_f.viewmodel.noctua.MainScreen;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.MainScreen.MainScreenService;
import com.example.gui_f.model.noctua.MainScreen.MainScreenServiceImpl;
import com.example.gui_f.model.noctua.MainScreen.VitalResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public class MainScreenImpl implements MainScreen {

    private MainScreenService mainScreenService = new MainScreenServiceImpl();
    private VitalResponse vital = new VitalResponse();
    private List<VitalResponse> vitalList = new ArrayList<>();

    @Override
    public VitalResponse searchLast(String user, Context context) {
        try{
            Log.i("SearchLast","Sending data to MainScreenService");
            vital = mainScreenService.searchLast(user, context);
            return vital;
        } catch (Exception e){
            Log.i("SearchLastFail", "Error in searchLast " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchDaily(String user, int day, Context context) {
        try{
            Log.i("SearchDay", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchDaily(user, day, context);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchDayFail", "Error in searchDaily " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchWeekly(String user, int week, int month, Context context) {
        try{
            Log.i("SearchWeek", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchWeekly(user, week, month, context);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchWeekFail", "Error in searchWeekly " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchMonthly(String user, int month, Context context) {
        try{
            Log.i("SearchMonth", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchMonthly(user, month, context);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchMonthFail", "Error in searchMonthly " + e.getMessage());
            return null;
        }
    }
}
