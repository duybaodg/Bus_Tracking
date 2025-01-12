package com.example.api_with_header.objects;

import java.io.Serializable;

public class BusTrip implements Serializable {
    private String busIdName;
    private String busRoutine;
    private int id;
    private String routeId;
    private String routeDesc;

    public BusTrip(String busIdName, String busRoutine) {
        this.busIdName = busIdName;
        this.busRoutine = busRoutine;
    }

    public BusTrip(int id, String routeId, String busIdName, String busRoutine, String routeDesc) {
        this.id = id;
        this.routeId = routeId;
        this.busIdName = busIdName;
        this.busRoutine = busRoutine;
        this.routeDesc = routeDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
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
