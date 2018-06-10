package com.example.gui_f.viewmodel.noctua.MainScreen;

import android.content.Context;

import com.example.gui_f.model.noctua.MainScreen.VitalResponse;

import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public interface MainScreen {
    public VitalResponse searchLast(int id, Context context);

    public List<VitalResponse> searchDaily(int id, int day, Context context);

    public List<VitalResponse> searchWeekly(int id, int week, int month, Context context);

    public List<VitalResponse> searchMonthly(int id, int month, Context context);
}
