package com.example.gui_f.viewmodel.noctua;

import android.util.Log;

import com.example.gui_f.model.noctua.Diary.DiaryService;
import com.example.gui_f.model.noctua.Diary.DiaryServiceImpl;
import com.example.gui_f.model.noctua.Diary.FeelEnum;

/**
 * Created by gui-f on 27/12/2017.
 */

public class DiaryImpl implements Diary {

    private DiaryService diaryService = new DiaryServiceImpl();

    @Override
    public boolean sendFeeling(String user, String feel) {
        Log.i("DiaryImpl", "Sending feeling...");
        FeelEnum feeling = FeelEnum.valueOf(feel);
        try{
            return diaryService.sendFeeling(user, feeling);
        } catch (Exception e){
            Log.i("DiaryImplFail", "Error in sending feeling! " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendDiary(String user, String diary) {
        Log.i("DiaryImpl", "Sending DiaryActivity...");
        try{
            return diaryService.sendDiary(user, diary);
        } catch(Exception e){
            Log.i("DiaryImplFail", "Error in sending diary! " + e.getMessage());
            return false;
        }
    }
}
