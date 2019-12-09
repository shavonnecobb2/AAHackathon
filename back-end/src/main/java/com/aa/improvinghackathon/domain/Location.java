package com.aa.improvinghackathon.domain;

public class Location {

    private final String code;
    private final String city;

    public Location(final String code, final String city) {
        this.code = code;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

}
