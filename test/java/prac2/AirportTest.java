package prac2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// testing flights conditionally
class AirportTest {

	@Test
	public void testAirport() {
	Flight economyFlight = new EconomyFlight("1");
	Flight businessFlight = new BusinessFlight("2");
	
	Passenger john = new Passenger("John",true);
	Passenger mike = new Passenger("Mike",false);
	
	assertEquals(true, economyFlight.addPassenger(john));
	assertEquals(false, economyFlight.removePassenger(john));
	assertEquals(true, businessFlight.addPassenger(john));
	assertEquals(false, businessFlight.removePassenger(john));
	
	assertEquals(true, economyFlight.addPassenger(mike));
	assertEquals(true, economyFlight.removePassenger(mike));
	assertEquals(false, businessFlight.addPassenger(mike));
	assertEquals(false, businessFlight.removePassenger(mike));
}
}
