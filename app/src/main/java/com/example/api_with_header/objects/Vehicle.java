package com.example.api_with_header.objects;

public class Vehicle {
    private Trip trip;
    private Position position;
    private String occupancy_status;
    private VehicleId vehicle;
    private long timestamp;

    public Vehicle(String occupancy_status, Position position, long timestamp, Trip trip, VehicleId vehicle) {
        this.occupancy_status = occupancy_status;
        this.position = position;
        this.timestamp = timestamp;
        this.trip = trip;
        this.vehicle = vehicle;
    }

    public Vehicle() {
    }

    public String getOccupancy_status() {
        return occupancy_status;
    }

    public void setOccupancy_status(String occupancy_status) {
        this.occupancy_status = occupancy_status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public VehicleId getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleId vehicle) {
        this.vehicle = vehicle;
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

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "occupancy_status='" + occupancy_status + '\'' +
                ", trip=" + trip +
                ", position=" + position +
                ", vehicle=" + vehicle +
                ", timestamp=" + timestamp +
                '}';
    }
}
