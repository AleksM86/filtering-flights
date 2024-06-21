package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segmentList;

    public Flight(List<Segment> segmentList) {
        this.segmentList = segmentList;
    }

    public List<Segment> getSegmentList() {
        return segmentList;
    }

    @Override
    public String toString() {
        return segmentList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
