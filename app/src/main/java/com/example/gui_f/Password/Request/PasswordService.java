package com.example.gui_f.Password.Request;

import android.content.Context;

/**
 * Created by gui-f on 06/01/2018.
 */

public interface PasswordService {
    boolean forgotPassword(String email, Context context);
}
