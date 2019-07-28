package com.ezops.ezopsDemo.service;


import com.ezops.ezopsDemo.bean.Passenger;
/**
 * 
 * @author mundlamuri
 *
 */
public interface PassengerService {
	public Iterable<Passenger>getAllPassengers();
	public Passenger getPassenger(int passengerId);
	public Passenger savePassenger(Passenger titanic);
	public boolean deletePassenger(Passenger titanic);
}
