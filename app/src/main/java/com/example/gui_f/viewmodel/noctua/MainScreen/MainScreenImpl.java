package com.example.gui_f.viewmodel.noctua.MainScreen;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.MainScreen.MainScreenService;
import com.example.gui_f.model.noctua.MainScreen.MainScreenServiceImpl;
import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.utils.JsonCallback;

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
    public VitalResponse searchLast(int id, Context context, final JsonCallback jsonCallback) {
        try{
            Log.i("SearchLast","Sending data to MainScreenService");
            vital = mainScreenService.searchLast(id, context, jsonCallback);
            return vital;
        } catch (Exception e){
            Log.i("SearchLastFail", "Error in searchLast " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchDaily(int id, int day, Context context, final JsonCallback jsonCallback) {
        try{
            Log.i("SearchDay", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchDaily(id, day, context, jsonCallback);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchDayFail", "Error in searchDaily " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchWeekly(int id, int week, int month, Context context, final JsonCallback jsonCallback) {
        try{
            Log.i("SearchWeek", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchWeekly(id, week, month, context, jsonCallback);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchWeekFail", "Error in searchWeekly " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VitalResponse> searchMonthly(int id, int month, Context context, final JsonCallback jsonCallback) {
        try{
            Log.i("SearchMonth", "Sending data to MainScreenService");
            vitalList = mainScreenService.searchMonthly(id, month, context, jsonCallback);
            return vitalList;
        }catch (Exception e){
            Log.i("SearchMonthFail", "Error in searchMonthly " + e.getMessage());
            return null;
        }
    }
}
