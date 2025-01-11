package com.example.api_with_header.objects;

public class VehicleId {
    private String id;

    public VehicleId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VehicleId{" +
                "id=" + id +
                '}';
    }
}
