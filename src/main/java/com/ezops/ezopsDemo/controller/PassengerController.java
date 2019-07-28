package com.ezops.ezopsDemo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezops.ezopsDemo.EzopsDemoApplication;
import com.ezops.ezopsDemo.bean.Passenger;
import com.ezops.ezopsDemo.service.PassengerService;
/**
 * 
 * @author mundlamuri
 * Rest Controller to handle Titanic Passenger Info   
 */
@Controller
@RequestMapping("/passenger")
public class PassengerController {
	private static Logger logger = LogManager.getLogger(PassengerController.class);
	
	@Autowired
	private PassengerService passengerService; 
	@GetMapping(path="/all")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public @ResponseBody Iterable<Passenger> getAllPassengers() {
		logger.info("PassengerController::getAllPassengers");
		Iterable<Passenger> passengers = passengerService.getAllPassengers();
		return passengers;
	}
	@GetMapping(path="/get/{id}")
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Passenger> getPassenger(@PathVariable(value = "id") int passengerId) {
		logger.info("PassengerController::getPassenger"+passengerId);
		Passenger passenger = passengerService.getPassenger(passengerId);
		return ResponseEntity.ok().body(passenger);
		 
	}

	@PostMapping("/save")
	@CrossOrigin(origins = {"http://localhost:4200"})
	@ResponseBody
	public Passenger  savePassenger(@RequestBody Passenger passenger) {
		logger.info("PassengerController::savePassenger::"+passenger.getName());
		this.passengerService.savePassenger(passenger);
		return this.passengerService.savePassenger(passenger);
	}
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = {"http://localhost:4200"})
	@ResponseBody
	public ResponseEntity<Boolean>  deletePassenger(@PathVariable(value = "id") int passengerId) {
		logger.info("PassengerController::deletePassenger::"+passengerId);
		Passenger passenger = passengerService.getPassenger(passengerId);
		passengerService.deletePassenger(passenger);
		return ResponseEntity.ok().body(true);
	}
	
		
}
