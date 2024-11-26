package com.example.api_with_header.objects;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private double bearing;
    private float latitude;
    private float longitude;

    public Position(double bearing, float latitude, float longitude) {
        this.bearing = bearing;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Position{" +
                "bearing='" + bearing + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
