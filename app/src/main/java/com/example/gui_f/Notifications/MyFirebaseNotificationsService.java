package com.example.gui_f.Notifications;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by gui-f on 09/01/2018.
 */

public class MyFirebaseNotificationsService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //TODO: se necessário fazer algum tratamento com as mensagens, fazer aqui
        super.onMessageReceived(remoteMessage);
    }
}
