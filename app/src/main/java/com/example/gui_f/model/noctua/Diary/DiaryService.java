package com.example.gui_f.model.noctua.Diary;

import android.content.Context;

/**
 * Created by gui-f on 27/12/2017.
 */

public interface DiaryService {

    boolean sendFeeling(String user, FeelEnum feel, Context context);

    boolean sendDiary(String user, String diary, FeelEnum feel, Context context);
}
