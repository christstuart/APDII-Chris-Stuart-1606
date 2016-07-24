package com.flyminds.chris.buckit;

import android.net.Uri;

/**
 * Created by Chris on 7/17/16.
 */
public class AllCategories {

    String categoryName;
    Uri image;
    String Category;

    public AllCategories(String categoryName, Uri image, String category) {
        this.categoryName = categoryName;
        this.image = image;
        Category = category;
    }

    public Uri getImage() {
        return image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategory() {
        return Category;
    }
}
