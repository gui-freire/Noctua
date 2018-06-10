package com.example.gui_f.model.noctua;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gui-f on 20/12/2017.
 */

public class UserDTO implements Parcelable{
    private int id;
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private String password;
    private ResponsibleDTO responsible;
    private String firebaseKey;
    private boolean resp;
    private boolean exists;
    private String nameResp;
    private String  surnameResp;
    private String emailResp;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public String getFirebaseKey() {
        return firebaseKey;
    }

    public void setFirebaseKey(String firebaseKey) {
        this.firebaseKey = firebaseKey;
    }

    public UserDTO(){}

    //Parcelable methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(birthday);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeInt(resp ? 1 : 0);
        dest.writeInt(exists ? 1 : 0);
        dest.writeParcelable(responsible, flags);
        dest.writeString(firebaseKey);
        dest.writeString(getNameResp());
        dest.writeString(getSurnameResp());
        dest.writeString(getEmailResp());
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
        id = pc.readInt();
        name = pc.readString();
        surname = pc.readString();
        birthday = pc.readString();
        email = pc.readString();
        password = pc.readString();
        resp = (pc.readInt() == 1);
        exists = (pc.readInt() == 1);
        responsible = pc.readParcelable(ResponsibleDTO.class.getClassLoader());
        firebaseKey = pc.readString();
        setNameResp(pc.readString());
        setSurnameResp(pc.readString());
        setEmailResp(pc.readString());
    }

    public String getNameResp() {
        return nameResp;
    }

    public void setNameResp(String nameResp) {
        this.nameResp = nameResp;
    }

    public String getSurnameResp() {
        return surnameResp;
    }

    public void setSurnameResp(String surnameResp) {
        this.surnameResp = surnameResp;
    }

    public String getEmailResp() {
        return emailResp;
    }

    public void setEmailResp(String emailResp) {
        this.emailResp = emailResp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
