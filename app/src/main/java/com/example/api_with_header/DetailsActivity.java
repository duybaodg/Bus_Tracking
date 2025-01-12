package com.example.api_with_header;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.api_with_header.objects.Bus;
import com.example.api_with_header.objects.BusTrip;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        listView = findViewById(R.id.id_listDetail);
        btnBack = findViewById(R.id.id_btnBack);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        BusTrip busTrip = (BusTrip) bundle.get("sendData");
        assert busTrip != null;
        List<String> busDetails = new ArrayList<>();
        busDetails.add("BUS ID: "+String.valueOf(busTrip.getId()));
        busDetails.add("BUS ROUTE ID: "+busTrip.getRouteId());
        busDetails.add("BUS NUMBER: "+busTrip.getBusIdName());
        busDetails.add("BUS ROUTE: "+busTrip.getBusRoutine());
        busDetails.add("BUS ROUTE: "+busTrip.getRouteDesc());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>((Context) this, R.layout.detail_item,R.id.tv_detail, busDetails);
        listView.setAdapter(arrayAdapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}