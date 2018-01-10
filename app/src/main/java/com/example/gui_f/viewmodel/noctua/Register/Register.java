package com.example.gui_f.viewmodel.noctua.Register;

import android.content.Context;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface Register {
    boolean changeData(UserDTO user, Context context);

    boolean changeResponsible(String email, ResponsibleDTO resp, Context context);
}
