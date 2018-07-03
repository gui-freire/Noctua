package com.example.gui_f.utils;

import org.json.JSONObject;

/**
 * Created by gui-f on 10/06/2018.
 */

public interface JsonCallback {
    void onSuccess(JSONObject jsonObject);

    void onError();
}
