package com.flyminds.chris.buckit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "iwH1uYbKg2YjkEkCFGG3pE7wx";
    private static final String TWITTER_SECRET = "LS4iS0X9OqpU5v4H7kUSCfgQ0KwuJHsrH7RxOoKAZ8A1wnCOtb";


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Moon Bold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );


        setTitle("Home");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
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
                Log.d(TAG, "Kinvey Ping Success");

                Log.i(TAG, "onCreate: " + "LogIn " + mKinveyClient.user().getUsername());

            }
        });

      if (mKinveyClient.user().isUserLoggedIn()){





      } else {

          mKinveyClient.user().login(new KinveyUserCallback() {
              @Override
              public void onFailure(Throwable error) {
                  Log.e(TAG, "Login Failure", error);
              }
              @Override
              public void onSuccess(User result) {
                  Log.i(TAG,"Logged in a new implicit user with id: " + result.getId());

                  mKinveyClient.user().setUsername("Anon");
                  mKinveyClient.user().update(new KinveyUserCallback() {
                      @Override
                      public void onSuccess(User user) {

                          user.setUsername("Anon");

                      }

                      @Override
                      public void onFailure(Throwable throwable) {

                      }
                  });

              }
          });




      }


    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.profilem,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.profile) {

            Intent intent = new Intent(this,ProfileActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DicoverFragment(), "Discover");
        adapter.addFragment(new FoodFragment(), "Food");
        adapter.addFragment(new SportFragment(), "Sport");
        adapter.addFragment(new EventsFragment(), "Events");
        adapter.addFragment(new TurismFragment(), "Turism");
        viewPager.setAdapter(adapter);
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



