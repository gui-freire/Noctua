package com.example.gui_f.model.noctua.Register;

import android.content.Context;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;
import com.example.gui_f.utils.JsonCallback;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface RegisterService {
    boolean changeData(UserDTO user, Context context, final JsonCallback jsonCallback);

    boolean changeResponsible(String user, UserDTO userDTO, Context context, final JsonCallback jsonCallback);
}
