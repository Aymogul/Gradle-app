package com.example.android.tourguide;

public class locations {

    //location name
    private String mLocation;
    //location address
    private String mAddress;
    //images for the location
    private int mImageResourceId;

    /*
     * Create a new Location object.
     *
     * vlocation is the input parameter for the name of the location
     * vAdress is the input parameter for the adress of the location
     * imageResourceId is the id for images of the location
     * */
    public locations(String vLocation, String vAdress, int imageResourceId) {
        mLocation = vLocation;
        mAddress = vAdress;
        mImageResourceId = imageResourceId;
    }

    //this gets the name of the location
    public String getLocation() {
        return mLocation;
    }

    //this gets the adress of the location
    public String getAddress() {
        return mAddress;
    }

    //gets the image resource id
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
