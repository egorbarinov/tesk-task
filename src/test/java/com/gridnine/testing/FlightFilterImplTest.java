package com.gridnine.testing;

import org.junit.jupiter.api.*;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterImplTest {

    FlightFilter flightFilter;
    List<Flight> testFlightList;

    @BeforeEach
    void setUp() {
        flightFilter = new FlightFilterImpl();
        testFlightList = FlightBuilder.createFlights();
    }

    @AfterEach
    void tearDown() {
        flightFilter = null;
        testFlightList = null;
    }

    @Test
    void departuresUpToCurrentTime_takeFlightsArray_thenOk() {
        assertEquals(1,flightFilter.departuresUpToCurrentTime(testFlightList).size());
    }

    @Test
    void segmentsWithArrivalDateEarlierThanDepartureDate_takeFlightsArray_thenOk() {
        assertEquals(1,flightFilter.segmentsWithArrivalDateEarlierThanDepartureDate(testFlightList).size());
    }

    @Test
    void totalTimeSpentOnEarthExceedsTwoHours_takeFlightsArray_thenOk() {
        assertEquals(2,flightFilter.totalTimeSpentOnEarthExceedsTwoHours(testFlightList).size());
    }
}
