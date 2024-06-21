import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Flights;
import com.gridnine.testing.services.FlightServices;
import com.gridnine.testing.services.FlightServicesImpl;
import factory.FlightBuilderForTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class FlightServicesImplTest {
    FlightServices flightServices;
    Flights flights;
    @Before
    public void createFlight(){
        flights = new Flights(FlightBuilder.createFlights());
        flightServices = new FlightServicesImpl();
    }
    @Test
    public void deleteDepartureBeforeTheCurrentTime(){
        List<Flight> expectedFlightList = FlightBuilderForTest.createFlightsWithoutDepartureBeforeTheCurrentTime();
        List<Flight> actualFlightList = flightServices.deleteDepartureBeforeTheCurrentTime(flights).getFlightList();
        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());
    }
    @Test
    public void deleteSegmentsArrivalDateEarlierDepartureDate(){
        List<Flight> expectedFlightList = FlightBuilderForTest.createFlightsWithoutDepartsBeforeArrivesInSegment();
        List<Flight> actualFlightList = flightServices.deleteSegmentsArrivalDateEarlierDepartureDate(flights).getFlightList();
        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());
    }
    @Test
    public void deleteFlightsWhereTransferMoreTwoHours(){
        List<Flight> expectedFlightList = FlightBuilderForTest.createFlightsWithoutTransferMoreTwoHours();
        List<Flight> actualFlightList = flightServices.deleteFlightsWhereTransferMoreTwoHours(flights).getFlightList();
        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());
    }
}
