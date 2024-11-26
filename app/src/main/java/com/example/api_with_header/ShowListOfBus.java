package com.example.api_with_header;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.api_with_header.objects.Position;

import java.util.List;

public class ShowListOfBus extends AppCompatActivity {
    ListView listViewPositon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_list_of_bus);
        ListApplication listApplication = (ListApplication)getApplicationContext();
        List<Position> listBusPositon = listApplication.getBusLocation();
        listViewPositon = findViewById(R.id.id_listView);
        listViewPositon.setAdapter(new ArrayAdapter<Position>(this, android.R.layout.simple_list_item_1, listBusPositon));
    }
}