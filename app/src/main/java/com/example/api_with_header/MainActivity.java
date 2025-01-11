package com.example.api_with_header;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.api_with_header.api.APIStaticService;
import com.example.api_with_header.api.ApiService;
import com.example.api_with_header.fragment.MapFragment;
import com.example.api_with_header.objects.BusTrip;
import com.example.api_with_header.objects.Entity;
import com.example.api_with_header.objects.Position;
import com.example.api_with_header.objects.Routes;
import com.example.api_with_header.objects.StopLocation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Position> savedPosition;
    private List<String> listOfTripId;
    private List<String> listOfRouterId;
    private List<Integer> listOfDirectionId;
    private List<String> listOfRouterShortName;
    private List<String> listOfRouterLongName;
    private List<String> listOfRouterDes;
    private List<String> listOfVehicleId;
    private List<Integer> listOfStopId;
    private List<Routes> listOfRoute;
    private List<BusTrip> listOfBusTrip;
    private List<StopLocation> listOfStopIdObject;
    private List<Routes> listOfRouteGetFromAPI =  new ArrayList<>();
    private List<StopLocation> listOfStopLocationGetFromAPI = new ArrayList<>();
    private BottomNavigationView bottomNavigationView;
    private ViewPager mViewPager;
    private Fragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        callAPIGetStopLocation();
        callAPI();
        callAPIStatic();
        updateData();
        mapFragment = new MapFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mapFragment)
                .commit();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        mViewPager = findViewById(R.id.view_pager);
        setUpViewPager();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.action_home) {
                    mViewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.action_map) {
                    mViewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.action_schedule) {
                    mViewPager.setCurrentItem(2);
                }
                return true;
            }
        });
    }
    public void updateData() {
        Handler handler = new Handler();
        final Runnable refresh = new Runnable() {
            @Override
            public void run() {
                callAPI();
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(refresh, 5000);
    }
    public void callAPI() {
        ApiService.apiService.callApi().enqueue(new Callback<Entity>() {
            @Override
            public void onResponse(@NonNull Call<Entity> call, @NonNull Response<Entity> response) {
                if(response.isSuccessful() && response.body() != null) {
                    Entity entity = response.body();
                    ListApplication listApplication = (ListApplication)getApplicationContext();
                    savedPosition = listApplication.getBusLocation();
                    listOfTripId = listApplication.getTripId();
                    listOfRouterId = listApplication.getRouteId();
                    listOfDirectionId = listApplication.getDirectionId();
                    listOfVehicleId = listApplication.getVehicleId();
                    savedPosition.clear();
                    for(int i = 0; i < entity.getEntity().size(); i++) {
                        double bearing = entity.getEntity().get(i).getVehicle().getPosition().getBearing();
                        float latitude = entity.getEntity().get(i).getVehicle().getPosition().getLatitude();
                        float longitude = entity.getEntity().get(i).getVehicle().getPosition().getLongitude();
                        Position position = new Position(bearing, latitude, longitude);
                        String tripId = entity.getEntity().get(i).getVehicle().getTrip().getTrip_id();
                        String routerId = entity.getEntity().get(i).getVehicle().getTrip().getRoute_id();
                        int directionId = entity.getEntity().get(i).getVehicle().getTrip().getDirection_id();
                        String vehicleId = entity.getEntity().get(i).getVehicle().getVehicle().getId();
                        savedPosition.add(position);
                        listOfTripId.add(tripId);
                        listOfRouterId.add(routerId);
                        listOfDirectionId.add(directionId);
                        listOfVehicleId.add(vehicleId);
                       // Log.d("Size", "Size of bus: " + savedPosition.size());
                        Log.d("Bearing", "this is Bearing: " +bearing);
                        Log.d("Longitude", "LIST OF Bus longitude: "+longitude);
                        Log.d("Latitude", "LIST OF Bus latitude "+latitude);
                        Log.d("Trip ID", "this is trip Id: " +tripId);
                        Log.d("routerId", "this is routerId: " +routerId);
                        Log.d("directionId", "this is directionId: " +directionId);
                        Log.d("vehicleId", "this is vehicleId: " +vehicleId);
                    }

                    Log.d("JSON", "Body JSON" + entity);
                    Log.d("size", "here "+entity.getEntity().size());
                    Log.d("Size", "Size of bus: " + savedPosition.size());
                } else {
                    Log.e("Fail", "Error code"+ response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<Entity> call, @NonNull Throwable throwable) {
                Log.e("Error network", "Network Error "+ throwable.getMessage());
            }
        });
    }
    public void callAPIStatic() {
        APIStaticService.apiService2.callAPIRoutes("5012").enqueue(new Callback<List<Routes>>() {
            @Override
            public void onResponse(@NonNull Call<List<Routes>> call, @NonNull Response<List<Routes>> response) {
                if(response.isSuccessful()) {
                    listOfRouteGetFromAPI = response.body();
                    ListApplication listApplication = (ListApplication)getApplicationContext();
                    listOfRouterDes = listApplication.getRouteDes();
                    listOfRouterShortName = listApplication.getRouteShortName();
                    listOfRouterLongName = listApplication.getRouteLongName();
                    listOfRoute = listApplication.getBusRouteList();
                    listOfBusTrip = listApplication.getListOfBusTrips();
                    assert listOfRouteGetFromAPI != null;
                    for(int i = 0; i < listOfRouteGetFromAPI.size(); i++) {
                        int id = listOfRouteGetFromAPI.get(i).getId();
                        String routeId = listOfRouteGetFromAPI.get(i).getRoute_id();
                        String routeShortName = listOfRouteGetFromAPI.get(i).getRoute_short_name();
                        String routeLongName = listOfRouteGetFromAPI.get(i).getRoute_long_name();
                        String routeDes = listOfRouteGetFromAPI.get(i).getRoute_desc();
                        Routes route = new Routes(id, routeId, routeShortName, routeLongName, routeDes);
                        BusTrip busTrip = new BusTrip(routeShortName,routeLongName);
                        listOfBusTrip.add(busTrip);
                        listOfRoute.add(route);
                        listOfRouterDes.add(routeDes);
                        listOfRouterShortName.add(routeShortName);
                        listOfRouterLongName.add(routeLongName);
                        //Log.d("RouteShortname:", "RouteShortname: " + listOfRouterShortName.size());
                        //Log.d("routeLongName:", "routeLongName: " + listOfRouterLongName.size());
                        //Log.d("routeDes:", "routeDes: " + listOfRouterDes.size());
                    }

                    Log.d("listOfRoute", "this is listOfRoute: " +listOfRoute.size());

                } else {
                    Log.e("Fail", "Error code"+ response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Routes>> call, Throwable throwable) {
                Log.e("Error network", "Network Error callAPIStatic  "+ throwable.getMessage());
            }
        });
    }
    public void callAPIGetStopLocation() {
        APIStaticService.apiService2.callAPIStopLocation("21__0__231__NBM__24__2__24__2_20241222").enqueue(new Callback<List<StopLocation>>() {
            @Override
            public void onResponse(@NonNull Call<List<StopLocation>> call, @NonNull Response<List<StopLocation>> response) {
                if(response.isSuccessful()) {
                    listOfStopLocationGetFromAPI = response.body();
                    ListApplication listApplication = (ListApplication)getApplicationContext();
                    listOfStopId = listApplication.getStopId();
                    listOfStopIdObject = listApplication.getListOfStopLocationObject();
                    assert listOfStopLocationGetFromAPI != null;
                    for(int i = 0; i < listOfStopLocationGetFromAPI.size(); i++) {
                        int stopId = listOfStopLocationGetFromAPI.get(i).getStop_id();
                        String stopName = listOfStopLocationGetFromAPI.get(i).getStop_name();
                        String zoneId = listOfStopLocationGetFromAPI.get(i).getZone_id();
                        StopLocation stopLocation = new StopLocation(stopId, stopName,zoneId);
                        listOfStopIdObject.add(stopLocation);
                        listOfStopId.add(stopId);
                    }
                    Log.d("listOfStopIdObject", "this is listOfStopIdObject Size: " +listOfStopIdObject.size());
                } else {
                    Log.e("Fail", "Error code at StopId API"+ response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<StopLocation>> call, @NonNull Throwable throwable) {
                Log.e("Error network", "Network Error At Stop ID API "+ throwable.getMessage());
            }
        });
    }
    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                } else if (position == 1) {
                    bottomNavigationView.getMenu().findItem(R.id.action_map).setChecked(true);
                } else if (position == 2) {
                    bottomNavigationView.getMenu().findItem(R.id.action_schedule).setChecked(true);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}