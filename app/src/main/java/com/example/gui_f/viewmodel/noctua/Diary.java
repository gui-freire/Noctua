package com.example.gui_f.viewmodel.noctua;

import android.content.Context;

/**
 * Created by gui-f on 27/12/2017.
 */

public interface Diary {

    boolean sendFeeling(String user, String feel, Context context);

    boolean sendDiary(String user, String diary, String feel, Context context);
}
