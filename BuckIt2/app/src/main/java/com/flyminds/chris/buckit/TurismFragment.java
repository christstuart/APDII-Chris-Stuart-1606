package com.flyminds.chris.buckit;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chris on 7/14/16.
 */
public class TurismFragment extends Fragment {

    private static final String TAG = "TurismFragment";
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.turismfragment,container,false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        GridView turism_gridview = (GridView) getActivity().findViewById(R.id.turism_gridview);

        ArrayList<AllCategories> turismCategory = new ArrayList<>();

        turismCategory.add(new AllCategories("Adventure", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Turism"));
        turismCategory.add(new AllCategories("Extreme",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Turism"));
        turismCategory.add(new AllCategories("Passive",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Turism"));

        BaseAdapters.CategoryAdapter foodAdapter = new BaseAdapters.CategoryAdapter(turismCategory,getActivity());

        turism_gridview.setAdapter(foodAdapter);

        turism_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AllCategories category = (AllCategories) parent.getAdapter().getItem(position);

                Log.i(TAG, "onItemClick: " + category.getCategory());

                Intent categoryIntent = new Intent(getActivity(),CategoryScreen.class);

                categoryIntent.putExtra("Name",category.getCategoryName());

                getActivity().startActivity(categoryIntent);

            }
        });


    }


}
