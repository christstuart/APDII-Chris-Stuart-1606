package com.flyminds.chris.buckit;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Chris on 7/27/16.
 */
public class Place implements Serializable {

    ArrayList<String> date;
    ArrayList<String>  time;
    ArrayList<Uri> image;
    String name;
    String phoneNumber;
    String Website;
    double Lat;
    double Long;

    public Place(ArrayList<String> date, ArrayList<String> time, ArrayList<Uri> image, String name, String phoneNumber, String website, double lat, double aLong) {
        this.date = date;
        this.time = time;
        this.image = image;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Website = website;
        Lat = lat;
        Long = aLong;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public ArrayList<Uri> getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return Website;
    }

    public double getLat() {
        return Lat;
    }

    public double getLong() {
        return Long;
    }
}
