package com.gridnine.testing.services;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Flights;
import com.gridnine.testing.model.Segment;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightServicesImpl implements FlightServices{
    @Override
    public Flights deleteDepartureBeforeTheCurrentTime(Flights flights) {
        List<Flight> filteredFlightList = new ArrayList<>();
        for (Flight flight : flights.getFlightList()){
            if (flight.getSegmentList().get(0).getDateTimeDeparture().isAfter(LocalDateTime.now())){
                filteredFlightList.add(flight);
            }
        }
        return new Flights(filteredFlightList);
    }

    @Override
    public Flights deleteSegmentsArrivalDateEarlierDepartureDate(Flights flights) {
        List<Flight> filteredFlightList = new ArrayList<>(flights.getFlightList());
        for (Flight flight : flights.getFlightList()){
            for (Segment segment : flight.getSegmentList()){
                if (segment.getDateTimeDeparture().isAfter(segment.getDateTimeArrival())){
                    filteredFlightList.remove(flight);
                    break;
                }
            }
        }
        return new Flights(filteredFlightList);
    }

    @Override
    public Flights deleteFlightsWhereTransferMoreTwoHours(Flights flights) {
        List<Flight> filteredFlightList = new ArrayList<>(flights.getFlightList());
        for (Flight flight : flights.getFlightList()){
            Duration durationAll = Duration.ZERO;
            List <Segment> segmentList = flight.getSegmentList();
            for (int i = 1; i < segmentList.size(); i++){
             Duration duration = Duration.between(segmentList.get(i - 1).getDateTimeArrival(), segmentList.get(i).getDateTimeDeparture());
             durationAll = durationAll.plus(duration);
             if (durationAll.getSeconds() > 7200) {
                 filteredFlightList.remove(flight);
                 break;
             }
            }
        }
        return new Flights(filteredFlightList);
    }
}
