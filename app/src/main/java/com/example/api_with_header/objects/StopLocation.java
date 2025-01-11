package com.example.api_with_header.objects;

public class StopLocation {
    private int stop_id;
    private String stop_name;
    private String zone_id;

    public StopLocation() {
    }

    public StopLocation(int stop_id, String stop_name, String zone_id) {
        this.stop_id = stop_id;
        this.stop_name = stop_name;
        this.zone_id = zone_id;
    }

    public int getStop_id() {
        return stop_id;
    }

    public void setStop_id(int stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public String getZone_id() {
        return zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    @Override
    public String toString() {
        return "StopLocation{" +
                "stop_id=" + stop_id +
                ", stop_name='" + stop_name + '\'' +
                ", zone_id=" + zone_id +
                '}';
    }
}
