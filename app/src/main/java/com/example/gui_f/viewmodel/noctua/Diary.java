package com.example.gui_f.viewmodel.noctua;

/**
 * Created by gui-f on 27/12/2017.
 */

public interface Diary {

    boolean sendFeeling(String user, String feel);

    boolean sendDiary(String user, String diary);
}
