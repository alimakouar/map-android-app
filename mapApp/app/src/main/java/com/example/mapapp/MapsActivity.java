package com.example.mapapp;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    int height = 100;
    int width = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        ///////////////////////////////////////////////////////////
        // load marker icons
        BitmapDrawable casablancadraw = (BitmapDrawable)getResources().getDrawable(R.drawable.casablanca);
        Bitmap casablancaMarker = Bitmap.createScaledBitmap(casablancadraw.getBitmap(), width, height, false);

        BitmapDrawable rabatdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.rabat);
        Bitmap rabatMarker = Bitmap.createScaledBitmap(rabatdraw.getBitmap(), width, height, false);

        BitmapDrawable agadirdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.agadir);
        Bitmap agadirMarker = Bitmap.createScaledBitmap(agadirdraw.getBitmap(), width, height, false);

        BitmapDrawable tangerdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.tanger);
        Bitmap tangerMarker = Bitmap.createScaledBitmap(tangerdraw.getBitmap(), width, height, false);

        BitmapDrawable oujdadraw = (BitmapDrawable)getResources().getDrawable(R.drawable.oujda);
        Bitmap oujdaMarker = Bitmap.createScaledBitmap(oujdadraw.getBitmap(), width, height, false);

        // load marker position
        LatLng casablanca = new LatLng(33.5731,-7.5898);
        LatLng rabat = new LatLng(33.9716, -6.8498);
        LatLng agadir = new LatLng(30.4278, -9.5981);
        LatLng tanger = new LatLng(35.7595, -5.8340);
        LatLng oujda = new LatLng(34.6820, -1.9002);

        // add markers
        mMap.addMarker(new MarkerOptions().position(casablanca).title("Marker in Casablanca").icon(BitmapDescriptorFactory.fromBitmap(casablancaMarker)));
        mMap.addMarker(new MarkerOptions().position(rabat).title("Marker in Rabat").icon(BitmapDescriptorFactory.fromBitmap(rabatMarker)));
        mMap.addMarker(new MarkerOptions().position(agadir).title("Marker in Agadir").icon(BitmapDescriptorFactory.fromBitmap(agadirMarker)));
        mMap.addMarker(new MarkerOptions().position(tanger).title("Marker in Tanger").icon(BitmapDescriptorFactory.fromBitmap(tangerMarker)));
        mMap.addMarker(new MarkerOptions().position(oujda).title("Marker in Oujda").icon(BitmapDescriptorFactory.fromBitmap(oujdaMarker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rabat,10));
    }
}