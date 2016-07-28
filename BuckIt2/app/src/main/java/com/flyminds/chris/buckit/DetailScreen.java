package com.flyminds.chris.buckit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Moon Bold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setTitle("Detail");

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Detail");

        SystemBarTintManager tintManager = new SystemBarTintManager(this);

        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);

        tintManager.setTintColor(Color.BLACK);

        TextView description = (TextView) findViewById(R.id.description_id);
        TextView precio = (TextView) findViewById(R.id.precio_text);
        description.setTextColor(Color.BLACK);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "MoonLight.otf");
        description.setTypeface(custom_font);
        precio.setTypeface(custom_font);

        TwoWayGridView hours_gridview = (TwoWayGridView) findViewById(R.id.gridview_hours);

        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place("Monday","9:00am-11:00pm"));
        places.add(new Place("Tuesday","9:00am-11:00pm"));
        places.add(new Place("Thursday","9:00am-11:00pm"));
        places.add(new Place("Friday","9:00am-11:00pm"));

        hours_gridview.setNumColumns(places.size());

        BaseAdapters.HourAdapter hourAdapter = new BaseAdapters.HourAdapter(places,this);

        hours_gridview.setAdapter(hourAdapter);


        TwoWayGridView oferta_gridview = (TwoWayGridView) findViewById(R.id.gridview_ofertas);

        ArrayList<Oferta> ofertas = new ArrayList<>();

        ofertas.add(new Oferta("1", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("2", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("3", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("4", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));

        if (oferta_gridview != null) {
            oferta_gridview.setNumColumns(ofertas.size());
        }

        BaseAdapters.OfertaAdapter ofertaAdapter = new BaseAdapters.OfertaAdapter(ofertas,this);

        oferta_gridview.setAdapter(ofertaAdapter);


    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
