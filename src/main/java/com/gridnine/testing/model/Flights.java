package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Flights {
    private final  List<Flight> flightList;

    public Flights(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }


    @Override
    public String toString() {
        return  flightList.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }
}
