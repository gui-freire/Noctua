package com.example.gui_f.model.noctua.MainScreen;

import android.content.Context;

import com.example.gui_f.utils.JsonCallback;

import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public interface MainScreenService {

    public VitalResponse searchLast(int id, Context context, final JsonCallback jsonCallback);

    public List<VitalResponse> searchDaily(int id, int day, Context context, final JsonCallback jsonCallback);

    public List<VitalResponse> searchWeekly(int id, int week, int month, Context context, final JsonCallback jsonCallback);

    public List<VitalResponse> searchMonthly(int id, int month, Context context, final JsonCallback jsonCallback);
}
