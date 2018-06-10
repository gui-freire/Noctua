package com.example.gui_f.viewmodel.noctua.Register;

import android.content.Context;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface Register {
    boolean changeData(UserDTO user, Context context, final JsonCallback jsonCallback);

    boolean changeResponsible(String email, UserDTO resp, Context context, final JsonCallback jsonCallback);
}
