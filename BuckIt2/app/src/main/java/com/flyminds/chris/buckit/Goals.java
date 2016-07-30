package com.flyminds.chris.buckit;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Chris on 7/29/16.
 */
public class Goals extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.goals,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridView experiencias = (GridView) getActivity().findViewById(R.id.goals_gridview);

        ArrayList<Place> places = new ArrayList<>();

        ArrayList<String> date = new ArrayList<String>();
        date.add("Monday");

        ArrayList<String> time = new ArrayList<String>();
        time.add("9:00am-11:00pm");

        ArrayList<Uri> uris = new ArrayList<Uri>();
        uris.add(Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/agua"));

        places.add(new Place(date,time,uris,"Gustitos","787-565-1441","www.facebook.com",3.3,-1.3));


        BaseAdapters.GoalsAdapter experienciasAdapter = new BaseAdapters.GoalsAdapter(places,getActivity());
        experiencias.setAdapter(experienciasAdapter);

    }
}
