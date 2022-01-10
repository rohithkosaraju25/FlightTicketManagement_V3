package prac2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

//adding passenger only once
class AirportTest5 {

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
			
			@DisplayName("Then you cannot add him to an economy flight more than once")
			@RepeatedTest(5)
			//@Disabled
			public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
				for(int i=0; i<repetitionInfo.getCurrentRepetition();i++) {
					economyFlight.addPassenger(mike);
				}
				assertAll("Verifying a usual passenger can be added to an economy flight only once",
						() -> assertEquals(1,economyFlight.getPassengerSet().size()),
						() -> assertTrue(economyFlight.getPassengerSet().contains(mike)),
						() -> assertEquals(true, economyFlight.getPassengerSet().contains(mike))
						);
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
	
	@DisplayName("Given there is premium flight")
	@Nested
	class PremiumFlightTest {
		private Flight premiumFlight;
		private Passenger john;
		private Passenger mike;

		@BeforeEach
		void setUp() {
			premiumFlight = new PremiumFlight("3");
			mike = new Passenger("mike", false);
			john = new Passenger("john", true);
		}

		@Nested
		@DisplayName("When we have usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Then you cannot add him or remove him from a premium flight")
			public void testBusinessFlightUsualPassenger() {
				assertAll("Verifying all the conditions for a usual passenger in business flight",
						() -> assertEquals(false, premiumFlight.addPassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengerSet().size()),
						() -> assertEquals(false, premiumFlight.removePassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengerSet().size()));
			}
		}

		@Nested
		@DisplayName("When we have VIP passsenger")
		class VipPassenger {
			@Test
			@DisplayName("Then you can add him and remove from a premium flight")
			public void testBusinessFlightVipPassenger() {
				assertAll("Verifying all the conditions for a usual passenger in premium flight",
						() -> assertEquals(true, premiumFlight.addPassenger(john)),
						() -> assertEquals(1, premiumFlight.getPassengerSet().size()),
						() -> assertEquals(true, premiumFlight.removePassenger(john)),
						() -> assertEquals(0, premiumFlight.getPassengerSet().size()));
			}
		}

	}

}
