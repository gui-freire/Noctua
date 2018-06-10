package com.example.gui_f.viewmodel.noctua.Diary;

import android.content.Context;
import android.util.Log;

import com.example.gui_f.model.noctua.Diary.DiaryService;
import com.example.gui_f.model.noctua.Diary.DiaryServiceImpl;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 27/12/2017.
 */

public class DiaryImpl implements Diary {

    private DiaryService diaryService = new DiaryServiceImpl();

    @Override
    public boolean sendFeeling(String user, String feel, Context context, final JsonCallback jsonCallback) {
        Log.i("DiaryImpl", "Sending feeling...");
        try{
            return diaryService.sendFeeling(user, feel, context, jsonCallback);
        } catch (Exception e){
            Log.i("DiaryImplFail", "Error in sending feeling! " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendDiary(String user, String diary, String feel, Context context, final JsonCallback jsonCallback) {
        Log.i("DiaryImpl", "Sending DiaryActivity...");
        try{
            return diaryService.sendDiary(user, diary, feel, context, jsonCallback);
        } catch(Exception e){
            Log.i("DiaryImplFail", "Error in sending diary! " + e.getMessage());
            return false;
        }
    }
}
