package com.flyminds.chris.buckit;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

import java.util.ArrayList;

/**
 * Created by Chris on 7/15/16.
 */
public class SportFragment extends Fragment {

    private static final String TAG = "SportFragment";
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Client mKinveyClient = new Client.Builder("kid_WJFaHn5GmZ", "169d568121764862ad5950c15c9d2f5a"
                , getActivity()).build();

        mKinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e(TAG, "Kinvey Ping Failed", t);
            }

            public void onSuccess(Boolean b) {
                Log.d(TAG, "Kinvey Ping Success");
            }
        });
        
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.sportfragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView statename = (TextView) getActivity().findViewById(R.id.statename_sport);
        TextView catname = (TextView) getActivity().findViewById(R.id.categoryname_sport);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "Moon Bold.otf");
        statename.setTypeface(custom_font);
        catname.setTypeface(custom_font);

        GridView sport_gridview = (GridView) getActivity().findViewById(R.id.sport_gridview);

        ArrayList<FoodCategories> foodCategories = new ArrayList<>();

        foodCategories.add(new FoodCategories("Gym", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        foodCategories.add(new FoodCategories("Boxing Classes",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        foodCategories.add(new FoodCategories("Zumba Classes",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        foodCategories.add(new FoodCategories("Sport Clinics",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        foodCategories.add(new FoodCategories("Game tickets",Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));

        BaseAdapters.CategoryAdapter foodAdapter = new BaseAdapters.CategoryAdapter(foodCategories,getActivity());

        sport_gridview.setAdapter(foodAdapter);


    }
}
