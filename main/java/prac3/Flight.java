package prac3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public abstract class Flight {
	private String id;
	
	// to have unique passenger in list replace list with set
	//List<Passenger> passengerList = new ArrayList<Passenger>();
	Set<Passenger> passengerSet = new HashSet<>();
	
	public Flight(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengerSet() {
		return Collections.unmodifiableSet(passengerSet);
	}
	
	public abstract boolean addPassenger(Passenger passenger);
	
	public abstract boolean removePassenger(Passenger passenger);
	
}
