package com.example.android.tourguide;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class StadiumActivity extends AppCompatActivity {

    //creates a DrawerLayout object
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);
        //this creates the tool bar which includes the menu button to open the navigation drawer
        //sets the toolbar as the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //adds the menu button to the toolbar
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
                            Intent navHome = new Intent(StadiumActivity.this, MainActivity.class);
                            startActivity(navHome);

                        } else if (id == R.id.nav_cinema) {
                            Intent navCinema = new Intent(StadiumActivity.this, CinemaActivity.class);
                            startActivity(navCinema);

                        } else if (id == R.id.nav_malls) {
                            Intent navMall = new Intent(StadiumActivity.this, MallsActivity.class);
                            startActivity(navMall);

                        } else if (id == R.id.nav_restaurants) {
                            Intent navRestaurants = new Intent(StadiumActivity.this, RestaurantsActivity.class);
                            startActivity(navRestaurants);

                        } else if (id == R.id.nav_hotels) {
                            Intent navHotel = new Intent(StadiumActivity.this, HotelsActivity.class);
                            startActivity(navHotel);

                        } else if (id == R.id.nav_recreation) {
                            Intent navRecreation = new Intent(StadiumActivity.this, RecreationActivity.class);
                            startActivity(navRecreation);

                        }

                        return true;
                    }
                });

        // Create an ArrayList of the locations objects from the locations.java file
        ArrayList<locations> Stadium = new ArrayList<locations>();
        Stadium.add(new locations(getString(R.string.stadium1), getString(R.string.stadium_address1), R.drawable.dan_anyam_stadium));

        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        LocationAdapter places = new LocationAdapter(this, Stadium);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.stadiums_list);
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
