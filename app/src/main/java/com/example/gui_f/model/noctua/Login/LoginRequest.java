package com.example.gui_f.model.noctua.Login;

import com.example.gui_f.model.noctua.ResponsibleDTO;
import com.example.gui_f.model.noctua.UserDTO;

import org.json.JSONObject;

/**
 * Created by gui-f on 01/01/2018.
 */

public class LoginRequest {
    //TODO: FAZER CHAMADA NO SERVIÇO

    public UserDTO searchUser(JSONObject in){
        //Mock
        UserDTO response = new UserDTO();
        ResponsibleDTO responsibleDTO = new ResponsibleDTO();

        response.setEmail("gui-freire@uol.com.br");
        response.setBirthday("30/04/1997");
        response.setName("Guilherme");
        response.setSurname("Freire");

        responsibleDTO.setName("Cristina");
        responsibleDTO.setRelation("Mãe");
        responsibleDTO.setEmail("cfmd@uol.com.br");

        response.setResponsible(responsibleDTO);

        return response;
    }
}
