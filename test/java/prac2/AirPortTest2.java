package prac2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// testing with polymorphised code
class AirPortTest2 {

	@Test
	public void testEconomyFlightUsualPassenger() {
		Flight economyFlight = new EconomyFlight("1");
		Passenger mike = new Passenger("mike",false);
		
		assertEquals("1",economyFlight.getId());
		assertEquals(true, economyFlight.addPassenger(mike));
		assertEquals(1,economyFlight.getPassengerSet().size());
		//assertEquals("mike",economyFlight.passengerList.get(0).getName());
		assertEquals(true, economyFlight.getPassengerSet().contains(mike));
		
		assertEquals(true,economyFlight.removePassenger(mike));
		assertEquals(0, economyFlight.getPassengerSet().size());
	}
	
	@Test
	public void testEconomyFlightVipPassenger() {
		Flight economyFlight = new EconomyFlight("1");
		Passenger john = new Passenger("john",true);
		
		assertEquals("1",economyFlight.getId());
		assertEquals(true, economyFlight.addPassenger(john));
		assertEquals(1,economyFlight.getPassengerSet().size());
		assertEquals(true, economyFlight.getPassengerSet().contains(john));
		
		assertEquals(false,economyFlight.removePassenger(john));
		assertEquals(1, economyFlight.getPassengerSet().size());
	}
	
	@Test
	public void testBusinessFlightUsualPassenger() {
		Flight businessFlight = new BusinessFlight("2");
		Passenger mike = new Passenger("mike",false);
		
		assertEquals(false, businessFlight.addPassenger(mike));
		assertEquals(0,businessFlight.getPassengerSet().size());
		assertEquals(false,businessFlight.removePassenger(mike));
		assertEquals(0,businessFlight.getPassengerSet().size());
	}
	
	@Test
	public void testBusinessFlightVipPassenger() {
		Flight businessFlight = new BusinessFlight("2");
		Passenger john = new Passenger("john",true);
		
		assertEquals(true, businessFlight.addPassenger(john));
		assertEquals(1,businessFlight.getPassengerSet().size());
		assertEquals(false,businessFlight.removePassenger(john));
		assertEquals(1,businessFlight.getPassengerSet().size());
	}

}
