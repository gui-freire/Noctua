package com.example.gui_f.model.noctua;

/**
 * Created by gui-f on 23/12/2017.
 */

public class LoginServiceImpl implements LoginService {
    @Override
    public UserDTO searchUser(String user) {
        UserDTO userReturn = new UserDTO();
        userReturn.setHeartbeats("68");
        userReturn.setPression("11/8");
        userReturn.setName(user);

        return userReturn;
    }
}
