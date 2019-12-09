package com.aa.improvinghackathon.domain;

public class Location {

    private final String city;
    private final String code;

    public Location(final String city, final String code) {
        this.city = city;
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

}
