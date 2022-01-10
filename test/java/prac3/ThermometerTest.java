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

import prac3.Sensor;
import prac3.Thermometer;

@ExtendWith(MockitoExtension.class)
class ThermometerTest {

	@InjectMocks
	Thermometer thermometer;
	
	@Mock
	Sensor sensor;
	
	@Test
	void testWorkingSensor() {
		thermometer.setTemparature(25.0);
		when(sensor.isBlocked()).thenReturn(false);
		assertEquals(sensor, thermometer.getSensor());
		assertEquals(25.0, thermometer.getTemparature());
		verify(sensor, times(1)).isBlocked();
	}
	
	@Test
	void testBlockedSensor() {
		thermometer.setTemparature(25.0);
		when(sensor.isBlocked()).thenReturn(true);
		assertEquals(sensor, thermometer.getSensor());
		assertThrows(RuntimeException.class, () -> thermometer.getTemparature());
		verify(sensor, times(1)).isBlocked();
	}

}
