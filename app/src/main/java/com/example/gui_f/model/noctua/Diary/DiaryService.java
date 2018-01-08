package com.example.gui_f.model.noctua.Diary;

/**
 * Created by gui-f on 27/12/2017.
 */

public interface DiaryService {

    boolean sendFeeling(String user, FeelEnum feel);

    boolean sendDiary(String user, String diary, FeelEnum feel);
}
