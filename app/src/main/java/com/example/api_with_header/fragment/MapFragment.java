package com.example.api_with_header.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.api_with_header.ListApplication;
import com.example.api_with_header.R;
import com.example.api_with_header.objects.Position;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapFragment extends Fragment {
    private GoogleMap mMap;
    private View mapView;
    private List<Position> savedPosition;
    private SupportMapFragment supportMapFragment;
    private SearchView mapSearch;
    private final Handler handler = new Handler();
    private static final int RELOAD_TIME_MS = 5000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mapView = inflater.inflate(R.layout.fragment_map, container, false);
        supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.mapFragment);
        reloadMapData();
        return mapView;
    }
    private void reloadMapData() {
        ListApplication listApplication = (ListApplication) requireActivity().getApplication();
        savedPosition = listApplication.getBusLocation();
        supportMapFragment.getMapAsync(googleMap -> {

            LatLng markerLocation = new LatLng(-41.2924, 174.7787);
            googleMap.addMarker(new MarkerOptions().position(markerLocation).title("W"));
            //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(markerLocation, 14f));
            mMap = googleMap;
            CameraPosition currentCameraPosition = mMap.getCameraPosition();
           if (mMap != null) {
                mMap.clear();
               // LatLng lastLocation = new LatLng(-41.2924, 174.7787);
                for (Position position : savedPosition) {
                    LatLng latLng = new LatLng(position.getLatitude(), position.getLongitude());
                    MarkerOptions markerOptions = new MarkerOptions()
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus))
                            .position(latLng)
                            .title("Bus Bearing: " + position.getBearing());
                    mMap.addMarker(markerOptions);
                  //  lastLocation = latLng;
                }
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(currentCameraPosition));
                //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lastLocation, 12.0f));
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.getUiSettings().setCompassEnabled(true);
                mMap.getUiSettings().setZoomGesturesEnabled(true);
                mMap.getUiSettings().setScrollGesturesEnabled(true);
            }
        });
        handler.postDelayed(this::reloadMapData, RELOAD_TIME_MS);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }
}