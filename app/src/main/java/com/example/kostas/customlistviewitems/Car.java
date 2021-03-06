package com.example.kostas.customlistviewitems;

/**
 * Created by Kostas on 11/6/2017.
 */

public class Car {
    private String make;
    private int year;
    private int iconID;
    private String condition;


    public Car(String make, int year, int iconID, String condition){
        super();
        this.make = make;
        this.year = year;
        this.iconID = iconID;
        this.condition = condition;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getIconID() {
        return iconID;
    }

    public String getCondition() {
        return condition;
    }
}
