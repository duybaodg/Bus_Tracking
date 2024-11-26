package com.example.api_with_header;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.api_with_header.api.ApiService;
import com.example.api_with_header.objects.Entity;
import com.example.api_with_header.objects.Position;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Position> listBusPositions;
    private Button btnListOfBusPosition;
    private Button btnCallAPI;
    private List<Position> savedPosition;
    private Button btnViewMap;
    ListApplication listApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnCallAPI = findViewById(R.id.btn_callAPI);
        btnListOfBusPosition = findViewById(R.id.btn_listBus);
        btnViewMap = findViewById(R.id.id_view_on_map);
        updateData();
        btnCallAPI.setOnClickListener(v -> callAPI());
        btnListOfBusPosition.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowListOfBus.class);
            startActivity(intent);
        });
        btnViewMap.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Mapactivity.class);
            startActivity(intent);
        });

    }
    public void updateData() {
        Handler handler = new Handler();
        final Runnable refresh = new Runnable() {
            @Override
            public void run() {
                callAPI();
                handler.postDelayed(this, 30000);
            }
        };
        handler.postDelayed(refresh, 30000);
    }
    public void callAPI() {
        ApiService.apiService.callApi().enqueue(new Callback<Entity>() {
            @Override
            public void onResponse(@NonNull Call<Entity> call, @NonNull Response<Entity> response) {
                if(response.isSuccessful() && response.body() != null) {
                    Entity entity = response.body();
                   // ApiView.setText(entity.toString());
                    ListApplication listApplication = (ListApplication)getApplicationContext();
                    savedPosition = listApplication.getBusLocation();
                    boolean isCall = false;
                    savedPosition.clear();
                    for(int i = 0; i < entity.getEntity().size(); i++) {
                        double bearing = entity.getEntity().get(i).getVehicle().getPosition().getBearing();
                        float latitude = entity.getEntity().get(i).getVehicle().getPosition().getLatitude();
                        float longitude = entity.getEntity().get(i).getVehicle().getPosition().getLongitude();
                        Position position = new Position(bearing, latitude, longitude);
                        savedPosition.add(position);
                        Log.d("Size", "Size of bus: " + savedPosition.size());
                        Log.d("Bearing", "this is Bearing: " +bearing);
                        Log.d("Longitude", "LIST OF Bus location: "+longitude);
                        Log.d("Latitude", "LIST OF Bus location "+latitude);
                    }

                    Log.d("JSON", "Body JSON" + entity);
                    Log.d("size", "here "+entity.getEntity().size());
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
}