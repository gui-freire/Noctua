package com.example.gui_f.model.noctua;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gui-f on 20/12/2017.
 */

public class ResponsibleDTO implements Parcelable {
    private String name;
    private String relation;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponsibleDTO(){}

    //Parcelable methods

    public ResponsibleDTO(Parcel pc){
        name = pc.readString();
        relation = pc.readString();
        email = pc.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(relation);
        dest.writeString(email);
    }

    public static final Parcelable.Creator<ResponsibleDTO> CREATOR = new Creator<ResponsibleDTO>() {
        @Override
        public ResponsibleDTO createFromParcel(Parcel source) {
            return new ResponsibleDTO(source);
        }

        @Override
        public ResponsibleDTO[] newArray(int size) {
            return new ResponsibleDTO[size];
        }
    };
}
