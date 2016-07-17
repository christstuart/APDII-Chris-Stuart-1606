package com.flyminds.chris.buckit;

import android.net.Uri;

/**
 * Created by Chris on 7/17/16.
 */
public class FoodCategories {

    String categoryName;
    Uri image;

    public FoodCategories(String categoryName, Uri image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public Uri getImage() {
        return image;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
