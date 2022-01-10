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


// adding a premium flight
class AirportTest4 {

	@DisplayName("Given there is economy flight")
	@Nested
	class EconomyFlightsTest {
		private Flight economyFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setup() {
			economyFlight = new EconomyFlight("1");
			mike = new Passenger("mike", false);
			john = new Passenger("john", true);
		}

		@Nested
		@DisplayName("When we have a usual passenger")
		class UsualPassenger {

			@Test
			@DisplayName("Then you can add and remove him from an economy flight")
			public void testEconomyFlightUsualPassenger() {

				assertAll("Verifying all conditions for a usual passenger and economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(mike)),
						() -> assertEquals(1, economyFlight.getPassengerSet().size()),
						() -> assertEquals(true, economyFlight.getPassengerSet().contains(mike)),
						() -> assertEquals(true, economyFlight.removePassenger(mike)),
						() -> assertEquals(0, economyFlight.getPassengerSet().size()));
			}
		}

		@Nested
		@DisplayName("When we have a VIP Passenger")
		class VipPassenger {

			@Test
			@DisplayName("Then you can add him but cannot remove him from economy flight")
			public void testEconomyFlightVipPassenger() {
				assertAll("Verifying all conditions for a Vip passenger and economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengerSet().size()),
						() -> assertEquals(true, economyFlight.getPassengerSet().contains(john)),
						() -> assertEquals(false, economyFlight.removePassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengerSet().size()));

			}
		}

	}

	@DisplayName("Given there is business flight")
	@Nested
	class BusinessFlightTest {
		private Flight businessFlight;
		private Passenger john;
		private Passenger mike;

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2");
			mike = new Passenger("mike", false);
			john = new Passenger("john", true);
		}

		@Nested
		@DisplayName("When we have usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Then you cannot add him or remove him from a Business flight")
			public void testBusinessFlightUsualPassenger() {
				assertAll("Verifying all the conditions for a usual passenger in business flight",
						() -> assertEquals(false, businessFlight.addPassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengerSet().size()),
						() -> assertEquals(false, businessFlight.removePassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengerSet().size()));
			}
		}

		@Nested
		@DisplayName("When we have VIP passsenger")
		class VipPassenger {
			@Test
			@DisplayName("Then you can add him but cannot remove from a business flight")
			public void testBusinessFlightVipPassenger() {
				assertAll("Verifying all the conditions for a usual passenger in business flight",
						() -> assertEquals(true, businessFlight.addPassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengerSet().size()),
						() -> assertEquals(false, businessFlight.removePassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengerSet().size()));
			}
		}

	}

}
