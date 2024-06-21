package com.gridnine.testing;

import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.model.Flights;
import com.gridnine.testing.services.FlightServices;
import com.gridnine.testing.services.FlightServicesImpl;


public class Main {
    public static void main(String[] args) {
        Flights flights = new Flights(FlightBuilder.createFlights());
        System.out.println("Все имееющееся перелёты: \n" + flights + "\n===============================");
        FlightServices flightServices = new FlightServicesImpl();
        Flights filteredFlights1 = flightServices.deleteDepartureBeforeTheCurrentTime(flights);
        System.out.println("Рейсы с вылетом от текущего момента времени: \n" + filteredFlights1 + "\n===============================");
        Flights filteredFlights2 = flightServices.deleteSegmentsArrivalDateEarlierDepartureDate(flights);
        System.out.println("Рейсы, которые не имеют сегменты с датой прилёта раньше даты вылета: \n" + filteredFlights2 + "\n===============================");
        Flights filteredFlights3 = flightServices.deleteFlightsWhereTransferMoreTwoHours(flights);
        System.out.println("Рейсы, общее время пересадок которых не более 2 часов: \n" + filteredFlights3 + "\n===============================");
    }
}
