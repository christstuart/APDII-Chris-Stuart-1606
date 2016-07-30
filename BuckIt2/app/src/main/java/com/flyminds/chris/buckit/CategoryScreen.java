package com.flyminds.chris.buckit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CategoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Moon Bold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setTitle("Category");

        final Button finish = (Button) findViewById(R.id.finish);

        finish.setBackgroundColor(Color.TRANSPARENT);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SystemBarTintManager tintManager = new SystemBarTintManager(this);

        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);

        tintManager.setTintColor(Color.BLACK);


        Intent intent = getIntent();


        TextView categoryName = (TextView) findViewById(R.id.category_name);
        categoryName.setText(intent.getStringExtra("Name"));


        TwoWayGridView sport_gridview = (TwoWayGridView) findViewById(R.id.gridview);

        ArrayList<AllCategories> sportCategory = new ArrayList<>();

        sportCategory.add(new AllCategories("Gym", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        sportCategory.add(new AllCategories("Boxing \nClasses",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        sportCategory.add(new AllCategories("Zumba \nClasses",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        sportCategory.add(new AllCategories("Sport \nClinics",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sportCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sport_gridview.setNumColumns(sportCategory.size());

        BaseAdapters.TopAdapter foodAdapter = new BaseAdapters.TopAdapter(sportCategory,this);



        sport_gridview.setAdapter(foodAdapter);


        sport_gridview.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(CategoryScreen.this,DetailScreen.class);

                startActivity(intent1);

            }
        });


        TwoWayGridView dos_gridview = (TwoWayGridView) findViewById(R.id.gridviewdos);

        ArrayList<AllCategories> dosCategory = new ArrayList<>();

        dosCategory.add(new AllCategories("Gym", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        dosCategory.add(new AllCategories("Boxing \nClasses",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        dosCategory.add(new AllCategories("Zumba \nClasses",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        dosCategory.add(new AllCategories("Sport \nClinics",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));
        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        dosCategory.add(new AllCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Sport"));

        sport_gridview.setNumColumns(dosCategory.size());

        BaseAdapters.BottomAdapter dosAdapter = new BaseAdapters.BottomAdapter(dosCategory,this);



        dos_gridview.setAdapter(dosAdapter);


        dos_gridview.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(CategoryScreen.this,DetailScreen.class);

                startActivity(intent1);

            }
        });


    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }





}
