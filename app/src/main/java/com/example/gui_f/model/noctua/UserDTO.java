package com.example.gui_f.model.noctua;

/**
 * Created by gui-f on 20/12/2017.
 */

public class UserDTO {
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private ResponsibleDTO responsible;
    private boolean resp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponsibleDTO getResponsible() {
        return responsible;
    }

    public void setResponsible(ResponsibleDTO responsible) {
        this.responsible = responsible;
    }

    public boolean isResp() {
        return resp;
    }

    public void setResp(boolean resp) {
        this.resp = resp;
    }
}
