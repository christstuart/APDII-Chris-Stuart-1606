package com.flyminds.chris.buckit;

import android.net.Uri;

/**
 * Created by Chris on 7/27/16.
 */
public class Oferta {

    String oferta;
    Uri image;

    public Oferta(String oferta, Uri image) {
        this.oferta = oferta;
        this.image = image;
    }

    public String getOferta() {
        return oferta;
    }

    public Uri getImage() {
        return image;
    }
}
