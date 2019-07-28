package com.ezops.ezopsDemo.service;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.ezops.ezopsDemo.bean.Passenger;
import com.ezops.ezopsDemo.controller.PassengerController;
import com.ezops.ezopsDemo.repository.PassengerRepository;
/**
 * 
 * @author mundlamuri
 *
 */
@Service
public class PassengerServiceImpl implements PassengerService{
	private static Logger logger = LogManager.getLogger(PassengerController.class);
	@Autowired
	public PassengerRepository titanicRepository;
	@Override
	@Transactional
	public Iterable<Passenger> getAllPassengers() {
		return this.titanicRepository.findAll();
	}
	@Override
	@Transactional
	public Passenger getPassenger(int passengerId) {
		Passenger titanic = this.titanicRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("passenger not found for this id :: " + passengerId));
		return titanic;

	}
	@Override
	@Transactional
	public Passenger savePassenger(Passenger titanic) {
		return this.titanicRepository.save(titanic);
	}

	@Override
	public boolean deletePassenger(Passenger titanic) {
		this.titanicRepository.delete(titanic);
		return true;
	}

}
