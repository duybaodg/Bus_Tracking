package com.example.api_with_header.objects;

public class Bus {
    private String id;
    private Vehicle vehicle;

    public Bus(String id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                '}';
    }
}
