package com.flyminds.chris.buckit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.forprofile, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Moon Bold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );


        setTitle("Profile");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.profileviewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.profiletabs);
        tabLayout.setupWithViewPager(viewPager);

        SystemBarTintManager tintManager = new SystemBarTintManager(this);

        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);

        tintManager.setTintColor(Color.BLACK);


        final Client mKinveyClient = new Client.Builder("kid_WJFaHn5GmZ", "169d568121764862ad5950c15c9d2f5a"
                , this.getApplicationContext()).build();

        mKinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e(TAG, "Kinvey Ping Failed", t);
            }

            public void onSuccess(Boolean b) {

                if (mKinveyClient.user().isUserLoggedIn()) {

                    if (mKinveyClient.user().getUsername().equals("Anon")) {

                        Toast.makeText(ProfileActivity.this, "Log in", Toast.LENGTH_SHORT).show();

                    } else {


                        Log.d(TAG, "Kinvey Ping Success");

                        Log.i(TAG, "onCreate: " + "LogIn " + mKinveyClient.user().getUsername());

                        Log.i(TAG, "onCreate: " + mKinveyClient.user().isUserLoggedIn());

                        ImageView profile_image = (ImageView) findViewById(R.id.profile_image);
                        TextView profile_name = (TextView) findViewById(R.id.profile_name);


                        if (profile_name != null) {
                            profile_name.setText(mKinveyClient.user().getUsername());

                        }

                        if (mKinveyClient.user().get("profile_picture") == null) {

                            Toast.makeText(ProfileActivity.this, "Your photo didn't save.", Toast.LENGTH_SHORT).show();

                        } else {

                            Picasso.with(ProfileActivity.this).load(mKinveyClient.user().get("profile_picture").toString()).into(profile_image);
                        }
                        Log.i(TAG, "onCreate: " + mKinveyClient.user().getUsername());
                        Log.i(TAG, "onSuccess: " + mKinveyClient.user().get("profile_picture"));


                    }

                } else {


                }


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Experiencias(), "Experiencias");
        adapter.addFragment(new Goals(), "Goals");
        viewPager.setAdapter(adapter);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {

            final Client mKinveyClient = new Client.Builder("kid_WJFaHn5GmZ", "169d568121764862ad5950c15c9d2f5a"
                    , this.getApplicationContext()).build();

            if (item.getItemId() == R.id.sign_out) {

                Log.i(TAG, "onContextItemSelected: " + "hit");

                if (mKinveyClient.user().isUserLoggedIn()) {
                    mKinveyClient.user().logout();
                    finish();
                } else {
                    Toast.makeText(ProfileActivity.this, "You have to Log In to sign out", Toast.LENGTH_SHORT).show();
                }

            }

        }


        return super.onOptionsItemSelected(item);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
