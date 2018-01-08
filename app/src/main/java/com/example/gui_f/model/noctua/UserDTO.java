package com.example.gui_f.model.noctua;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gui-f on 20/12/2017.
 */

public class UserDTO implements Parcelable{
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

    public UserDTO(){}

    //Parcelable methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(birthday);
        dest.writeString(email);
        dest.writeInt(resp ? 1 : 0);
    }

    public static final Parcelable.Creator<UserDTO> CREATOR = new Creator<UserDTO>() {
        @Override
        public UserDTO createFromParcel(Parcel source) {
            return new UserDTO(source);
        }

        @Override
        public UserDTO[] newArray(int size) {
            return new UserDTO[size];
        }
    };

    public UserDTO(Parcel pc){
        name = pc.readString();
        surname = pc.readString();
        birthday = pc.readString();
        email = pc.readString();
        resp = (pc.readInt() == 1);
    }
}
