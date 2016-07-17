package com.flyminds.chris.buckit;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Chris on 7/11/16.
 */
public class DicoverFragment extends Fragment {

    private static final String TAG = "DicoverFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.discover_frag, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridView gridView = (GridView) getActivity().findViewById(R.id.discover_gridview);

        ArrayList<DiscoverFavorites> discoverFavorites = new ArrayList<>();

        discoverFavorites.add(new DiscoverFavorites("WOMEN'S WORLD OLYMPIC QUALIFICATION TOURNAMENT", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"white","Sport"));
        discoverFavorites.add(new DiscoverFavorites("Gustitos Criollos", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/chu"),"other","Food"));
        discoverFavorites.add(new DiscoverFavorites("Dreamland Festival", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/ev"),"other","Events"));
        discoverFavorites.add(new DiscoverFavorites("menTa Cuisine", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"white","Food"));
        discoverFavorites.add(new DiscoverFavorites("Capitanes de Arecibo", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage"),"white","Sport"));
        discoverFavorites.add(new DiscoverFavorites("La Gran Gala del Museo de Arte de Puerto Rico", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/pin"),"other","Event"));


        BaseAdapters.discoverAdapter adapter = new BaseAdapters.discoverAdapter(discoverFavorites, getActivity());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
            }
        });


    }
}
