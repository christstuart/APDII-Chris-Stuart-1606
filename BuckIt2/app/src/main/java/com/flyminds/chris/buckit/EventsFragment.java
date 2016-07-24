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
public class EventsFragment extends Fragment {

    private static final String TAG = "EventsFragment";
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.eventsfragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView statename = (TextView) getActivity().findViewById(R.id.statename_event);
        TextView catname = (TextView) getActivity().findViewById(R.id.categoryname_event);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "Moon Bold.otf");
        statename.setTypeface(custom_font);
        catname.setTypeface(custom_font);

        GridView event_gridview = (GridView) getActivity().findViewById(R.id.event_gridview);

        ArrayList<AllCategories> eventCategorie = new ArrayList<>();

        eventCategorie.add(new AllCategories("Concert", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Event"));
        eventCategorie.add(new AllCategories("Marathons",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Event"));
        eventCategorie.add(new AllCategories("Circus",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"Event"));

        BaseAdapters.CategoryAdapter foodAdapter = new BaseAdapters.CategoryAdapter(eventCategorie,getActivity());

        event_gridview.setAdapter(foodAdapter);


        event_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
