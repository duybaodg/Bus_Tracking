package com.example.api_with_header;

import android.app.Application;

import com.example.api_with_header.objects.Position;

import java.util.ArrayList;
import java.util.List;

public class ListApplication extends Application {
    public static ListApplication listApplication;
    public List<Position> busLocation;

    public List<Position> getBusLocation() {
        return busLocation;
    }
    public void setBusLocation(List<Position> busLocation) {
        this.busLocation = busLocation;
    }
    public ListApplication getInstance() {
        return listApplication;
    }
    public void onCreate() {
        super.onCreate();
        listApplication = this;
        busLocation = new ArrayList<>();
    }
}
