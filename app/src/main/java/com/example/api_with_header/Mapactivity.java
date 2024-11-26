package com.example.api_with_header;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SearchView;

import com.example.api_with_header.objects.Position;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.api_with_header.databinding.ActivityMapactivityBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mapactivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapactivityBinding binding;
    private List<Position> savedPosition;
    private Marker marker;
    MainActivity mainActivity;
    private SearchView mapSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapSearch = findViewById(R.id.mapSearch);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        ListApplication listApplication = (ListApplication)getApplicationContext();
        savedPosition = listApplication.getBusLocation();
        mapSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String locationInput = mapSearch.getQuery().toString();
                List<Address> addresses = null;
                if(locationInput != null) {
                    Geocoder geocoder = new Geocoder (Mapactivity.this);
                    try {
                        addresses = geocoder.getFromLocationName(locationInput, 1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    assert addresses != null;
                    Address address = addresses.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Location"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        onResume();
    }
    @Override
    public void onResume() {
        super.onResume();
        if(mMap != null) {
            mMap.clear();
            LatLng sydney = new LatLng(-34, 151);
            LatLng lastLocation = sydney;
            for(Position position: savedPosition) {
                LatLng latLng = new LatLng(position.getLatitude(), position.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Lat "+position.getLatitude()+ " " + "Long "+position.getLongitude());
                mMap.addMarker(markerOptions);
                lastLocation = latLng;
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lastLocation, 12.0f));
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);
            mMap.getUiSettings().setZoomGesturesEnabled(true);
            mMap.getUiSettings().setScrollGesturesEnabled(true);
        }
    }
}