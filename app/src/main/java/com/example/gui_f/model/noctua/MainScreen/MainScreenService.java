package com.example.gui_f.model.noctua.MainScreen;

import android.content.Context;

import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public interface MainScreenService {

    public VitalResponse searchLast(String user, Context context);

    public List<VitalResponse> searchDaily(String user, int day, Context context);

    public List<VitalResponse> searchWeekly(String user, int week, int month, Context context);

    public List<VitalResponse> searchMonthly(String user, int month, Context context);
}
