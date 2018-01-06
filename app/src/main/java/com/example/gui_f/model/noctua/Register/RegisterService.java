package com.example.gui_f.model.noctua.Register;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 03/01/2018.
 */

public interface RegisterService {
    boolean changeData(UserDTO user);

    boolean changeResponsible(String user, ResponsibleDTO responsibleDTO);
}
