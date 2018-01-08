package com.example.gui_f.model.noctua.MainScreen;

import java.util.List;

/**
 * Created by gui-f on 01/01/2018.
 */

public interface MainScreenService {

    public VitalResponse searchLast(String user);

    public List<VitalResponse> searchDaily(String user, int day);

    public List<VitalResponse> searchWeekly(String user, int week, int month);

    public List<VitalResponse> searchMonthly(String user, int month);
}
