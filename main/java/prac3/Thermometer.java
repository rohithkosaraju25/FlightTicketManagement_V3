package prac3;

import javax.management.RuntimeErrorException;

public class Thermometer {
	
	private double temparature;
	private Sensor sensor;
	
	public double getTemparature() {
		if(sensor.isBlocked())
			throw new RuntimeException("sensor is blocked");
		return temparature;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public void setTemparature(double temparature) {
		this.temparature = temparature;
	}
	
	

}
