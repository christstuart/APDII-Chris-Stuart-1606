package com.flyminds.chris.buckit;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Chris on 7/15/16.
 */
public class DiscoverFavorites implements Serializable {

    String title;
    Uri image;
    String imageName;
    String category;

    public DiscoverFavorites(String title, Uri image, String imageName, String category) {
        this.title = title;
        this.image = image;
        this.imageName = imageName;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Uri getImage() {
        return image;
    }

    public String getImageName() {
        return imageName;
    }

    public String getCategory() {
        return category;
    }
}
