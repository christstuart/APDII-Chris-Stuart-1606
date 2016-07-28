package com.flyminds.chris.buckit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chris on 7/15/16.
 */
public class BaseAdapters {

    private static final String TAG = "BaseAdapters";

    static public class discoverAdapter extends BaseAdapter {

        ArrayList<DiscoverFavorites> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public discoverAdapter(ArrayList<DiscoverFavorites> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.discover_items, parent, false);
            }

            DiscoverFavorites favorite = (DiscoverFavorites) getItem(position);

            TextView categoryName = (TextView) convertView.findViewById(R.id.categoryname_discover);
            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            categoryName.setTypeface(custom_font);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_info);

            imageView.setImageURI(favorite.getImage());

            categoryName.setText(favorite.getCategory());

            View color = convertView.findViewById(R.id.view_color);
            TextView middleText = (TextView) convertView.findViewById(R.id.middle_text);
           // middleText.setTypeface(custom_font);

            middleText.setText(favorite.getTitle());

            if (favorite.getImageName().equals("white")) {
                color.setAlpha(0);
                middleText.setTextColor(Color.BLACK);
            } else {
                middleText.setTextColor(Color.WHITE);
            }

            return convertView;
        }
    }



    static public class CategoryAdapter extends BaseAdapter {

        ArrayList<AllCategories> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public CategoryAdapter(ArrayList<AllCategories> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.food_items, parent, false);
            }

            AllCategories favorite = (AllCategories) getItem(position);

            ImageView food_gridview_image = (ImageView) convertView.findViewById(R.id.food_gridview_image);
            TextView foodText = (TextView) convertView.findViewById(R.id.food_gridview_text);

            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            foodText.setTypeface(custom_font);

            foodText.setText(favorite.getCategoryName());
            food_gridview_image.setImageURI(favorite.getImage());

            return convertView;
        }
    }

    static public class TopAdapter extends BaseAdapter {


        ArrayList<AllCategories> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public TopAdapter(ArrayList<AllCategories> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.top_item, parent, false);
            }

            AllCategories favorite = (AllCategories) getItem(position);

            ImageView food_gridview_image = (ImageView) convertView.findViewById(R.id.food_gridview_image);
            TextView foodText = (TextView) convertView.findViewById(R.id.food_gridview_text);

            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            foodText.setTypeface(custom_font);

            foodText.setText(favorite.getCategoryName());
            food_gridview_image.setImageURI(favorite.getImage());

            return convertView;
        }
    }


    static public class BottomAdapter extends BaseAdapter {


        ArrayList<AllCategories> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public BottomAdapter(ArrayList<AllCategories> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.bottom_item, parent, false);
            }

            AllCategories favorite = (AllCategories) getItem(position);

            ImageView food_gridview_image = (ImageView) convertView.findViewById(R.id.food_gridview_image);
            TextView foodText = (TextView) convertView.findViewById(R.id.food_gridview_text);

            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            foodText.setTypeface(custom_font);

            foodText.setText(favorite.getCategoryName());
            food_gridview_image.setImageURI(favorite.getImage());

            return convertView;
        }
    }

    static public class HourAdapter extends BaseAdapter {


        ArrayList<Place> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public HourAdapter(ArrayList<Place> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.hour_item, parent, false);
            }

            Place favorite = (Place) getItem(position);

            TextView food_gridview_image = (TextView) convertView.findViewById(R.id.date);
            TextView foodText = (TextView) convertView.findViewById(R.id.time);

            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            Typeface custom_font2 = Typeface.createFromAsset(context.getAssets(), "MoonLight.otf");
            food_gridview_image.setTypeface(custom_font);
            foodText.setTypeface(custom_font2);

            foodText.setText(favorite.getTime());
            food_gridview_image.setText(favorite.getDate());

            return convertView;
        }
    }


    static public class OfertaAdapter extends BaseAdapter {


        ArrayList<Oferta> discoverFavorites;
        Context context;

        private static final long ID_CONSTANT = 0xDEADBEEF;

        public OfertaAdapter(ArrayList<Oferta> book, Context context) {
            this.discoverFavorites = book;
            this.context = context;
        }

        @Override
        public int getCount() {
            if (discoverFavorites != null) {
                return discoverFavorites.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (discoverFavorites != null && position < discoverFavorites.size() && position >= 0) {
                return discoverFavorites.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return ID_CONSTANT + position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.oferta_item, parent, false);
            }

            Oferta favorite = (Oferta) getItem(position);

            TextView oferta_text = (TextView) convertView.findViewById(R.id.oferta_text);
            ImageView oferta_image = (ImageView) convertView.findViewById(R.id.oferta_image);

            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "Moon Bold.otf");
            Typeface custom_font2 = Typeface.createFromAsset(context.getAssets(), "MoonLight.otf");
            oferta_text.setTypeface(custom_font);

            oferta_text.setText(favorite.getOferta());
            oferta_image.setImageURI(favorite.getImage());

            return convertView;
        }
    }


}
