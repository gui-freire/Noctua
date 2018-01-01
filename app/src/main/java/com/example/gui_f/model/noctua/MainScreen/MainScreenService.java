package com.example.gui_f.model.noctua.MainScreen;

/**
 * Created by gui-f on 01/01/2018.
 */

public interface MainScreenService {

    public VitalResponse searchLast(String user);

    public VitalResponse searchDaily(String user, int day);

    public VitalResponse searchWeekly(String user, int week, int month);

    public VitalResponse searchMonthly(String user, int month);
}
