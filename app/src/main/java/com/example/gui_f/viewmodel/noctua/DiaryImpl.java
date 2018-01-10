package com.example.gui_f.viewmodel.noctua;

import android.content.Context;
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
    public boolean sendFeeling(String user, String feel, Context context) {
        Log.i("DiaryImpl", "Sending feeling...");
        FeelEnum feeling = FeelEnum.valueOf(feel);
        try{
            return diaryService.sendFeeling(user, feeling, context);
        } catch (Exception e){
            Log.i("DiaryImplFail", "Error in sending feeling! " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendDiary(String user, String diary, String feel, Context context) {
        Log.i("DiaryImpl", "Sending DiaryActivity...");
        FeelEnum feeling = FeelEnum.valueOf(feel);
        try{
            return diaryService.sendDiary(user, diary, feeling, context);
        } catch(Exception e){
            Log.i("DiaryImplFail", "Error in sending diary! " + e.getMessage());
            return false;
        }
    }
}
