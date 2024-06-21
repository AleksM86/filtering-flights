package com.gridnine.testing.services;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Flights;

import java.util.List;

public interface FlightServices {
    Flights deleteDepartureBeforeTheCurrentTime(Flights flights);
    Flights deleteSegmentsArrivalDateEarlierDepartureDate(Flights flights);
    Flights deleteFlightsWhereTransferMoreTwoHours(Flights flights);
}
