package com.flyminds.chris.buckit;

import android.net.Uri;

/**
 * Created by Chris on 7/29/16.
 */
public class MenuItems {

    String type;
    Uri image;

    public MenuItems(String type, Uri image) {
        this.type = type;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public Uri getImage() {
        return image;
    }
}
