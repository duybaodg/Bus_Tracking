package com.example.api_with_header;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.api_with_header.objects.BusTrip;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        BusTrip busTrip = (BusTrip) bundle.get("sendData");
        TextView textView = findViewById(R.id.tv_detail);
        assert busTrip != null;
        textView.setText(busTrip.getBusRoutine());
    }
}