package com.example.iothack;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;



public class Constants {
    Global sharedData = Global.getInstance();


    //Location
    public final String GEOFENCE_ID = "BLR";
    public final float GEOFENCE_RADIUS_IN_METERS = (float) sharedData.getValueRad();


    public final HashMap<String, LatLng> AREA_LANDMARKS = new HashMap<String, LatLng>();


    {

        AREA_LANDMARKS.put(GEOFENCE_ID, new LatLng(sharedData.getValueLat(), sharedData.getValueLong()));
    }
}