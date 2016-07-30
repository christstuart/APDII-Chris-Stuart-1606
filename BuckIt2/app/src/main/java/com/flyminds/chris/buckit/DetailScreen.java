package com.flyminds.chris.buckit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyUserCallback;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DetailScreen extends AppCompatActivity {

    private static final String TAG = "DetailScreen";


    TwitterSession session;
    TwitterLoginButton loginButton;
    String username;
    String photo;


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
        if (collapsingToolbar != null) {
            collapsingToolbar.setTitle("Detail");
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);

        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);

        tintManager.setTintColor(Color.BLACK);

        TextView description = (TextView) findViewById(R.id.description_id);
        TextView precio = (TextView) findViewById(R.id.precio_text);
        if (description != null) {
            description.setTextColor(Color.BLACK);
        }
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "MoonLight.otf");
        if (description != null) {
            description.setTypeface(custom_font);
        }
        if (precio != null) {
            precio.setTypeface(custom_font);
        }

        TwoWayGridView hours_gridview = (TwoWayGridView) findViewById(R.id.gridview_hours);
        final TwoWayGridView image_gridview = (TwoWayGridView) findViewById(R.id.gridview_image);

        final ArrayList<Place> places = new ArrayList<>();
// Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/agua")

        ArrayList<String> date = new ArrayList<String>();
        date.add("Monday");

        ArrayList<String> time = new ArrayList<String>();
        time.add("9:00am-11:00pm");

        ArrayList<Uri> uris = new ArrayList<Uri>();
        uris.add(Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/agua"));

        places.add(new Place(date, time, uris, "Gustitos", "787-565-1441", "http://www.google.com", 28.578216, -81.308165));

        if (hours_gridview != null) {
            hours_gridview.setNumColumns(places.size());
        }
        if (image_gridview != null) {
            image_gridview.setNumColumns(places.size());
        }

        BaseAdapters.HourAdapter hourAdapter = new BaseAdapters.HourAdapter(places, this);
        BaseAdapters.ImagePlaceAdapter imagePlaceAdapter = new BaseAdapters.ImagePlaceAdapter(places, this);

        if (hours_gridview != null) {
            hours_gridview.setAdapter(hourAdapter);
        }
        if (image_gridview != null) {
            image_gridview.setAdapter(imagePlaceAdapter);
        }


        if (image_gridview != null) {
            image_gridview.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                    Place place = (Place) parent.getAdapter().getItem(position);

                    Log.i(TAG, "onItemClick: " + place.getImage());

                    final Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(place.getImage().get(position), "image/*");
                    startActivity(Intent.createChooser(intent, "title"));


                }
            });
        }


        TwoWayGridView oferta_gridview = (TwoWayGridView) findViewById(R.id.gridview_ofertas);

        ArrayList<Oferta> ofertas = new ArrayList<>();

        ofertas.add(new Oferta("1", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("2", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("3", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));
        ofertas.add(new Oferta("4", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/whiteimage")));

        if (oferta_gridview != null) {
            oferta_gridview.setNumColumns(ofertas.size());
        }

        if (oferta_gridview != null) {
            oferta_gridview.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                    Oferta oferta = (Oferta) parent.getAdapter().getItem(position);

                    Log.i(TAG, "onItemClick: " + oferta.getOferta());

                    Intent intent = new Intent(DetailScreen.this, OfferScreen.class);
                    startActivity(intent);

                }
            });
        }

        BaseAdapters.OfertaAdapter ofertaAdapter = new BaseAdapters.OfertaAdapter(ofertas, this);

        if (oferta_gridview != null) {
            oferta_gridview.setAdapter(ofertaAdapter);
        }

        TwoWayGridView menuItemsGridView = (TwoWayGridView) findViewById(R.id.gridview_menu);


        ArrayList<MenuItems> menuItemses = new ArrayList<>();
        menuItemses.add(new MenuItems("Phone", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/phone")));
        menuItemses.add(new MenuItems("Map", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/marker")));
        menuItemses.add(new MenuItems("Web", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/domain")));
        menuItemses.add(new MenuItems("Save", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/save")));
        menuItemses.add(new MenuItems("Camera", Uri.parse("android.resource://com.flyminds.chris.buckit/drawable/camera")));

        BaseAdapters.MenuAdapter menuAdapter = new BaseAdapters.MenuAdapter(menuItemses, this);

        menuItemsGridView.setAdapter(menuAdapter);

        final Client mKinveyClient = new Client.Builder("kid_WJFaHn5GmZ", "169d568121764862ad5950c15c9d2f5a"
                , this.getApplicationContext()).build();

        menuItemsGridView.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                MenuItems item = (MenuItems) parent.getAdapter().getItem(position);

                Log.i(TAG, "onItemClick: " + item.getType());

                switch (item.getType()) {
                    case "Phone":
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + places.get(0).getPhoneNumber()));
                        DetailScreen.this.startActivity(intent);
                        break;
                    case "Map":
                        Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + places.get(0).getLat() + ">,<" + places.get(0).getLong() + ">?q=<" + places.get(0).getLat() + ">,<" + places.get(0).getLong() + ">(" + "Full Sail" + ")"));
                        startActivity(intentMap);
                        break;
                    case "Web":
                        String url = places.get(0).getWebsite();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        DetailScreen.this.startActivity(i);
                        break;
                    case "Save":

                        if (mKinveyClient.user().isUserLoggedIn()) {

                            if (mKinveyClient.user().getUsername().equals("Anon")) {

                                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(DetailScreen.this);

                                LayoutInflater inflater = DetailScreen.this.getLayoutInflater();
                                View dialogView = inflater.inflate(R.layout.alertpofile, null);
                                dialogBuilder.setView(dialogView);


                                AlertDialog alertDialog = dialogBuilder.create();
                                alertDialog.show();

                                LoginTwitter(dialogView, alertDialog);
                            } else {
                                Toast.makeText(DetailScreen.this, "Log in" + mKinveyClient.user().getUsername(), Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(DetailScreen.this);

                            LayoutInflater inflater = DetailScreen.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.alertpofile, null);
                            dialogBuilder.setView(dialogView);


                            AlertDialog alertDialog = dialogBuilder.create();
                            alertDialog.show();

                            LoginTwitter(dialogView, alertDialog);

                        }
                        break;

                    case "Camera":
                        if (mKinveyClient.user().isUserLoggedIn()) {

                            Log.i(TAG, "onCreate: " + "LogIn ");

                            if (mKinveyClient.user().getUsername().equals("Anon")) {

                                AlertDialog.Builder dialogBuilderCamera = new AlertDialog.Builder(DetailScreen.this);

                                LayoutInflater inflaterCamera = DetailScreen.this.getLayoutInflater();
                                View dialogViewCamera = inflaterCamera.inflate(R.layout.alertpofile, null);
                                dialogBuilderCamera.setView(dialogViewCamera);


                                AlertDialog alertDialogCamera = dialogBuilderCamera.create();
                                alertDialogCamera.show();

                                LoginTwitter(dialogViewCamera, alertDialogCamera);
                            } else {
                                Toast.makeText(DetailScreen.this, "Log in" + mKinveyClient.user().getUsername(), Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            AlertDialog.Builder dialogBuilderCamera = new AlertDialog.Builder(DetailScreen.this);

                            LayoutInflater inflaterCamera = DetailScreen.this.getLayoutInflater();
                            View dialogViewCamera = inflaterCamera.inflate(R.layout.alertpofile, null);
                            dialogBuilderCamera.setView(dialogViewCamera);


                            AlertDialog alertDialogCamera = dialogBuilderCamera.create();
                            alertDialogCamera.show();

                            LoginTwitter(dialogViewCamera, alertDialogCamera);


                        }

                        break;
                }
            }
        });

    }

    public  void LoginTwitter(View dialogView, final AlertDialog dialog) {


        final Client mKinveyClient = new Client.Builder("kid_WJFaHn5GmZ", "169d568121764862ad5950c15c9d2f5a"
                , this.getApplicationContext()).build();


        loginButton = (TwitterLoginButton) dialogView.findViewById(R.id.login_button);

        Callback twitterCallback = new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls

                session = result.data;
//
                final String username = session.getUserName();
                Long userid = session.getUserId();

                Log.i(TAG, "success: " + username);

                getUserData();



                mKinveyClient.user().set("profile_picture", photo);
                mKinveyClient.user().setUsername(username);

                Log.i(TAG, "success: " + mKinveyClient.user().getUsername());

                mKinveyClient.user().update(new KinveyUserCallback() {
                    @Override
                    public void onSuccess(com.kinvey.java.User newUser) {
                        newUser.setUsername(username);
                        newUser.set("profile_picture", photo);
                        dialog.hide();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.i(TAG, "onFailure: " + throwable);
                    }
                });




            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Log.d("TwitterKit", "Login with Twitter failure", exception);
                dialog.hide();
            }
        };

        loginButton.setCallback(twitterCallback);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }


    void getUserData() {


        Twitter.getApiClient(session).getAccountService()
                .verifyCredentials(true, false, new Callback<User>() {

                    @Override
                    public void failure(TwitterException e) {

                        Log.i(TAG, "failure: " + e);

                    }

                    @Override
                    public void success(Result<User> userResult) {

                        final User user = userResult.data;
//
                        username = user.name;
                        photo = user.profileImageUrlHttps;


                    }

                });


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
