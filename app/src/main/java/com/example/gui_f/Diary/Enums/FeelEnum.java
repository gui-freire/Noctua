package com.example.gui_f.Diary.Enums;

/**
 * Created by gui-f on 27/12/2017.
 */

public enum FeelEnum {
    GOOD("Good", 0),
    MODERATE("Moderate", 1),
    BAD("Bad", 2);

    private String feeling;
    private int value;

    FeelEnum(String feeling, int value){
        this.feeling = feeling;
        this.value = value;
    }

    @Override
    public String toString() {
        return feeling;
    }
}
