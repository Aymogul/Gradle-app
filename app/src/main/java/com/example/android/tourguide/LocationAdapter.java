package com.example.android.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class LocationAdapter extends ArrayAdapter<locations> {

    private static final String LOG_TAG = LocationAdapter.class.getSimpleName();

    /**
     * This is our the custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists
     *
     * @param context The current context. Used to inflate the layout file.
     * @param places  A List of AndroidFlavor objects to display in a list
     */
    public LocationAdapter(Activity context, ArrayList<locations> places) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, places);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        locations currentLocations = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        locationTextView.setText(currentLocations.getLocation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        addressTextView.setText(currentLocations.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView locationIMage = (ImageView) listItemView.findViewById(R.id.location_image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        locationIMage.setImageResource(currentLocations.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
