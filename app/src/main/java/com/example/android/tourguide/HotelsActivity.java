package com.example.android.tourguide;

import android.content.Intent;
import android.location.Location;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    //creates a DrawerLayout object
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        //this creates the tool bar which includes the menu button to open the navigation drawer
        //sets the toolbar as the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //adds the memu button to the toolbar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //assigns the DrawerLayout to the layout from the activity_main
        mDrawerLayout = findViewById(R.id.drawer_layout);

        //this creates a listener to check for clicks in the navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        //this gets the reference id for the items in the menu
                        int id = menuItem.getItemId();
                        /**an else if statement is then used control what happens when each of the
                         items are clicked such as opening a new activity*/
                        if (id == R.id.nav_home) {
                            finish();
                            Intent navHome = new Intent(HotelsActivity.this, MainActivity.class);
                            startActivity(navHome);

                        } else if (id == R.id.nav_cinema) {
                            Intent navCinema = new Intent(HotelsActivity.this, CinemaActivity.class);
                            startActivity(navCinema);

                        } else if (id == R.id.nav_malls) {
                            Intent navMall = new Intent(HotelsActivity.this, MallsActivity.class);
                            startActivity(navMall);


                        } else if (id == R.id.nav_recreation) {
                            Intent navRecreation = new Intent(HotelsActivity.this, RecreationActivity.class);
                            startActivity(navRecreation);

                        } else if (id == R.id.nav_restaurants) {
                            Intent navRestaurants = new Intent(HotelsActivity.this, RestaurantsActivity.class);
                            startActivity(navRestaurants);

                        } else if (id == R.id.nav_stadiums) {
                            Intent navStadium = new Intent(HotelsActivity.this, StadiumActivity.class);
                            startActivity(navStadium);

                        }

                        return true;
                    }
                });

        // Create an ArrayList of the locations objects from the locations.java file
        ArrayList<locations> Hotels = new ArrayList<locations>();
        Hotels.add(new locations(getString(R.string.hotel1), getString(R.string.hotel_address1), R.drawable.concorde_hotel));
        Hotels.add(new locations(getString(R.string.hotel2), getString(R.string.hotel_address2), R.drawable.rock_view_hotel));
        Hotels.add(new locations(getString(R.string.hotel3), getString(R.string.hotel_address3), R.drawable.allseasons_hotel));
        Hotels.add(new locations(getString(R.string.hotel4), getString(R.string.hotel_address4), R.drawable.greatwood_hotel));
        Hotels.add(new locations(getString(R.string.hotel5), getString(R.string.hotel_address5), R.drawable.immaculate_royal_hotels));
        Hotels.add(new locations(getString(R.string.hotel6), getString(R.string.hotel_address6), R.drawable.owerri_plaza_hotel));
        Hotels.add(new locations(getString(R.string.hotel7), getString(R.string.hotel_address7), R.drawable.titanic_view_hotel));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        LocationAdapter places = new LocationAdapter(this, Hotels);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.hotel_list);
        listView.setAdapter(places);

    }

    //ensures that the back button works correctly
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    //opens the navigation drawer when the menu button is pressed on the tool bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
