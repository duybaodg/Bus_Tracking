package com.example.api_with_header.objects;

public class Trip {
    private String start_time;
    private String trip_id;
    private int direction_id;
    private String route_id;
    private String schedule_relationship;
    private String start_date;

    public Trip() {
    }

    public int getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(int direction_id) {
        this.direction_id = direction_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getSchedule_relationship() {
        return schedule_relationship;
    }

    public void setSchedule_relationship(String schedule_relationship) {
        this.schedule_relationship = schedule_relationship;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "direction_id=" + direction_id +
                ", start_time='" + start_time + '\'' +
                ", trip_id='" + trip_id + '\'' +
                ", route_id='" + route_id + '\'' +
                ", schedule_relationship='" + schedule_relationship + '\'' +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
