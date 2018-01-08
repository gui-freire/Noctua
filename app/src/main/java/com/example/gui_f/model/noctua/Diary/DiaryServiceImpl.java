package com.example.gui_f.model.noctua.Diary;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by gui-f on 27/12/2017.
 */

public class DiaryServiceImpl implements DiaryService {

    JSONObject json = new JSONObject();

    @Override
    public boolean sendFeeling(String user, FeelEnum feel) {
        try{
            json.put("User", user);
            json.put("Feeling", feel.toString());
            Log.i("SendFeeling", "Sending feeling to request");
            //TODO: Fazer chamada no serviço
            return true;
        } catch (Exception e){
            Log.i("SendFeelingError", "Error sending feeling to request: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendDiary(String user, String diary, FeelEnum feel) {
        try{
            json.put("User", user);
            json.put("DiaryActivity", diary);
            json.put("Feeling", feel);
            Log.i("SendDiary", "Sending diary to request");
            //TODO: Fazer chamada no serviço
            return true;
        } catch (Exception e){
            Log.i("SendDiaryError", "Error sending diary to request: " + e.getMessage());
            return false;
        }
    }
}
