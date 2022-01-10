package prac3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import prac3.BusinessFlight;
import prac3.EconomyFlight;
import prac3.Flight;
import prac3.Passenger;

//nested test cases
class AirportTest3 {

	@DisplayName("Given there is economy flight")
	@Nested
	class EconomyFlightsTest {
		private Flight economyFlight;

		@BeforeEach
		void setup() {
			economyFlight = new EconomyFlight("1");
		}

		@Test
		public void testEconomyFlightUsualPassenger() {
			Passenger mike = new Passenger("mike", false);

			assertEquals("1", economyFlight.getId());
			assertEquals(true, economyFlight.addPassenger(mike));
			assertEquals(1, economyFlight.getPassengerSet().size());
			assertEquals(true, economyFlight.getPassengerSet().contains(mike));

			assertEquals(true, economyFlight.removePassenger(mike));
			assertEquals(0, economyFlight.getPassengerSet().size());
		}

		@Test
		public void testEconomyFlightVipPassenger() {
			Passenger john = new Passenger("john", true);

			assertEquals("1", economyFlight.getId());
			assertEquals(true, economyFlight.addPassenger(john));
			assertEquals(1, economyFlight.getPassengerSet().size());
			assertEquals(true, economyFlight.getPassengerSet().contains(john));

			assertEquals(false, economyFlight.removePassenger(john));
			assertEquals(1, economyFlight.getPassengerSet().size());
		}

	}

	@DisplayName("Given there is business flight")
	@Nested
	class BusinessFlightTest {
		private Flight businessFlight;

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2");
		}

		@Test
		public void testBusinessFlightUsualPassenger() {
			Passenger mike = new Passenger("mike", false);

			assertEquals(false, businessFlight.addPassenger(mike));
			assertEquals(0, businessFlight.getPassengerSet().size());
			assertEquals(false, businessFlight.removePassenger(mike));
			assertEquals(0, businessFlight.getPassengerSet().size());
		}

		@Test
		public void testBusinessFlightVipPassenger() {
			Passenger john = new Passenger("john", true);

			assertEquals(true, businessFlight.addPassenger(john));
			assertEquals(1, businessFlight.getPassengerSet().size());
			assertEquals(false, businessFlight.removePassenger(john));
			assertEquals(1, businessFlight.getPassengerSet().size());
		}
	}

}
