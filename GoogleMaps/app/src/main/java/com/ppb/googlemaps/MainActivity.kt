package com.ppb.googlemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragment ().findFragmentById(
            R.id.map
        );
        mapFragment.getMapAsync(this);
    }
}