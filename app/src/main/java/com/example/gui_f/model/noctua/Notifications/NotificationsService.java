package com.example.gui_f.model.noctua.Notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by gui-f on 09/01/2018.
 */

public class NotificationsService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKENTAG", "Refreshed token: " + refreshedToken);
    }
}
