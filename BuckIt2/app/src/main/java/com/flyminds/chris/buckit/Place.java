package com.flyminds.chris.buckit;

import java.io.Serializable;

/**
 * Created by Chris on 7/27/16.
 */
public class Place implements Serializable {

    String date;
    String time;

    public Place(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
