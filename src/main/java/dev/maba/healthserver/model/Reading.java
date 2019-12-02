package dev.maba.healthserver.model;

import java.util.Date;

public class Reading {



    public Reading(String readingType, Float value, Date date, User user) {
        this.readingType = readingType;
        this.value = value;
        this.date = date;
        this.user = user;
    }

    String readingType;
    Float value;
    Date date;
    User user;


}
