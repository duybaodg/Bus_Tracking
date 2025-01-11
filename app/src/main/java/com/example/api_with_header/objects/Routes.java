package com.example.api_with_header.objects;

public class Routes {
    private int id;
    private String route_id;
    private String route_short_name;
    private String route_long_name;
    private String route_desc;


    public Routes() {
    }

    public Routes(int id,String route_id, String route_short_name, String route_long_name, String route_desc) {
        this.id = id;
        this.route_id = route_id;
        this.route_short_name = route_short_name;
        this.route_long_name = route_long_name;
        this.route_desc = route_desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute_desc() {
        return route_desc;
    }

    public void setRoute_desc(String route_desc) {
        this.route_desc = route_desc;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    public String getRoute_short_name() {
        return route_short_name;
    }

    public void setRoute_short_name(String route_short_name) {
        this.route_short_name = route_short_name;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "id=" + id +
                ", route_id='" + route_id + '\'' +
                ", route_short_name='" + route_short_name + '\'' +
                ", route_long_name='" + route_long_name + '\'' +
                ", route_desc='" + route_desc + '\'' +
                '}';
    }
}
