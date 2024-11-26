package com.example.api_with_header.objects;

public class Vehicle {
    private Trip trip;
    private Position position;

    public Vehicle(Position position, Trip trip) {
        this.position = position;
        this.trip = trip;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Trip getTrip() {
        return trip;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "position=" + position +
                ", trip=" + trip +
                '}';
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
