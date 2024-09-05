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
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    //creates a DrawerLayout object
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        if (id == R.id.nav_hotels) {
                            Intent navHotel = new Intent(MainActivity.this, HotelsActivity.class);
                            startActivity(navHotel);

                        } else if (id == R.id.nav_cinema) {
                            Intent navCinema = new Intent(MainActivity.this, CinemaActivity.class);
                            startActivity(navCinema);

                        } else if (id == R.id.nav_malls) {
                            Intent navMall = new Intent(MainActivity.this, MallsActivity.class);
                            startActivity(navMall);


                        } else if (id == R.id.nav_recreation) {
                            Intent navRecreation = new Intent(MainActivity.this, RecreationActivity.class);
                            startActivity(navRecreation);

                        } else if (id == R.id.nav_restaurants) {
                            Intent navRestaurants = new Intent(MainActivity.this, RestaurantsActivity.class);
                            startActivity(navRestaurants);

                        } else if (id == R.id.nav_stadiums) {
                            Intent navStadium = new Intent(MainActivity.this, StadiumActivity.class);
                            startActivity(navStadium);

                        }

                        return true;
                    }
                });

        Button hotels = (Button) findViewById(R.id.hotels);

        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotels = new Intent(MainActivity.this, HotelsActivity.class);
                startActivity(hotels);
            }
        });

        Button cinema = (Button) findViewById(R.id.cinema);

        cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cinema = new Intent(MainActivity.this, CinemaActivity.class);
                startActivity(cinema);
            }
        });
        Button malls = (Button) findViewById(R.id.malls);

        malls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent malls = new Intent(MainActivity.this, MallsActivity.class);
                startActivity(malls);
            }
        });

        Button recreation = (Button) findViewById(R.id.recreation);

        recreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recreation = new Intent(MainActivity.this, RecreationActivity.class);
                startActivity(recreation);
            }
        });

        Button restaurants = (Button) findViewById(R.id.restaurants);

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurants = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurants);
            }
        });

        Button stadiums = (Button) findViewById(R.id.stadiums);

        stadiums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stadiums = new Intent(MainActivity.this, StadiumActivity.class);
                startActivity(stadiums);
            }
        });


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
