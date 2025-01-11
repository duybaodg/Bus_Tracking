package com.example.api_with_header.objects;

import java.io.Serializable;

public class BusTrip implements Serializable {
    private String busIdName;
    private String busRoutine;

    public BusTrip(String busIdName, String busRoutine) {
        this.busIdName = busIdName;
        this.busRoutine = busRoutine;
    }

    public String getBusIdName() {
        return busIdName;
    }

    public void setBusIdName(String busIdName) {
        this.busIdName = busIdName;
    }

    public String getBusRoutine() {
        return busRoutine;
    }

    public void setBusRoutine(String busRoutine) {
        this.busRoutine = busRoutine;
    }

    @Override
    public String toString() {
        return "BusTrip{" +
                "busIdName='" + busIdName + '\'' +
                ", busRoutine='" + busRoutine + '\'' +
                '}';
    }
}
