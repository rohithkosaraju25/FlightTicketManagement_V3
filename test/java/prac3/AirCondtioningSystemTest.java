package prac3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AirCondtioningSystemTest {
	
	@InjectMocks
	AirConditioningSystem airConditioningSystem;
	
	@Mock
	Thermometer thermometer;
	
	@Test
	void testAirConditioningSystemStarted() {
		when(thermometer.getTemparature()).thenReturn(25.0);
		airConditioningSystem.setTemparatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertTrue(airConditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemparature();
	}
	
	@Test
	void testAirConditioningSystemStopped() {
		when(thermometer.getTemparature()).thenReturn(23.0);
		airConditioningSystem.setTemparatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertFalse(airConditioningSystem.isOpen());
		verify(thermometer,times(1)).getTemparature();
	}
	

}
