package com.example.gui_f.Home.Domain;

/**
 * Created by gui-f on 29/01/2018.
 */

public class VitalCard {

    private int imageId;

    private int nameId;

    private String value;

    public VitalCard(int imageId, int nameId, String value){
        setImageId(imageId);
        setNameId(nameId);
        setValue(value);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
