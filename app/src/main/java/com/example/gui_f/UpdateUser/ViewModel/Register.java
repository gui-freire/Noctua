package com.example.gui_f.UpdateUser.ViewModel;

import android.content.Context;

import com.example.gui_f.Domain.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface Register {
    boolean changeData(UserDTO user, Context context, final JsonCallback jsonCallback);

    boolean changeResponsible(String email, UserDTO resp, Context context, final JsonCallback jsonCallback);
}
