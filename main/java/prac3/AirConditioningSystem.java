package prac3;

public class AirConditioningSystem {
	
	private Thermometer thermometer;
	private double temparatureThreshold;
	private boolean open;
	
	public AirConditioningSystem() {
		open =false;
	}
	
	public void checkAirConditioningSystem() {
		this.open = thermometer.getTemparature() >= temparatureThreshold;
	}
	
	public boolean isOpen() {
		return open;
	}

	public void setThermometer(Thermometer thermometer) {
		this.thermometer = thermometer;
	}

	public void setTemparatureThreshold(double temparatureThreshold) {
		this.temparatureThreshold = temparatureThreshold;
	}
	
	
}
