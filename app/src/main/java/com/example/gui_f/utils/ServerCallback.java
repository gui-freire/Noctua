package com.example.gui_f.utils;

import org.json.JSONObject;

/**
 * Created by gui-f on 09/06/2018.
 */

public interface ServerCallback {
    void onSuccess(int result);

    void onError();
}
