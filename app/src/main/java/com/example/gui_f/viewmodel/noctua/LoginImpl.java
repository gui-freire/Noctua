package com.example.gui_f.viewmodel.noctua;

import com.example.gui_f.model.noctua.Login.LoginService;
import com.example.gui_f.model.noctua.Login.LoginServiceImpl;
import com.example.gui_f.model.noctua.UserDTO;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginImpl implements Login {
    private LoginService login = new LoginServiceImpl();

    @Override
    public UserDTO searchUser(String user) {
        return login.searchUser(user);
    }
}
