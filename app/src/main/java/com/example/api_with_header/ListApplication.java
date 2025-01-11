package com.example.api_with_header;
import android.app.Application;

import com.example.api_with_header.objects.BusTrip;
import com.example.api_with_header.objects.Position;
import com.example.api_with_header.objects.Routes;
import com.example.api_with_header.objects.StopLocation;

import java.util.ArrayList;
import java.util.List;

public class ListApplication extends Application {
    public static ListApplication listApplication;
    public List<Position> busLocation;
    private List<String> tripId;
    private List<Integer> directionId;
    private List<String> routeId;
    private List<String> routeShortName;
    private List<String> routeLongName;
    private List<String> routeDes;
    private List<String> vehicleId;
    private List<Integer> stopId;
    private List<Routes> busRouteList;
    private List<StopLocation> listOfStopLocationObject;
    private List<BusTrip> listOfBusTrips;

    public List<BusTrip> getListOfBusTrips() {
        return listOfBusTrips;
    }

    public void setListOfBusTrips(List<BusTrip> listOfBusTrips) {
        this.listOfBusTrips = listOfBusTrips;
    }

    public List<StopLocation> getListOfStopLocationObject() {
        return listOfStopLocationObject;
    }

    public void setListOfStopLocationObject(List<StopLocation> listOfStopLocationObject) {
        this.listOfStopLocationObject = listOfStopLocationObject;
    }

    public List<Routes> getBusRouteList() {
        return busRouteList;
    }

    public void setBusRouteList(List<Routes> busRouteList) {
        this.busRouteList = busRouteList;
    }

    public List<Integer> getStopId() {
        return stopId;
    }

    public void setStopId(List<Integer> stopId) {
        this.stopId = stopId;
    }

    public List<String> getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(List<String> vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<String> getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(List<String> routeShortName) {
        this.routeShortName = routeShortName;
    }

    public List<String> getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(List<String> routeLongName) {
        this.routeLongName = routeLongName;
    }

    public List<String> getRouteDes() {
        return routeDes;
    }

    public void setRouteDes(List<String> routeDes) {
        this.routeDes = routeDes;
    }

    public List<String> getTripId() {
        return tripId;
    }
    public void setTripId(List<String> tripId) {
        this.tripId = tripId;
    }
    public List<String> getRouteId() {
        return routeId;
    }
    public void setRouteId(List<String> routeId) {
        this.routeId = routeId;
    }
    public List<Integer> getDirectionId() {
        return directionId;
    }
    public void setDirectionId(List<Integer> directionId) {
        this.directionId = directionId;
    }
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
        tripId = new ArrayList<>();
        directionId = new ArrayList<>();
        routeId = new ArrayList<>();
        routeShortName = new ArrayList<>();
        routeLongName = new ArrayList<>();
        routeDes = new ArrayList<>();
        vehicleId = new ArrayList<>();
        stopId = new ArrayList<>();
        busRouteList = new ArrayList<>();
        listOfStopLocationObject = new ArrayList<>();
        listOfBusTrips = new ArrayList<>();
    }
}
