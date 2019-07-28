package com.ezops.ezopsDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ezops.ezopsDemo.bean.Passenger;
/**
 * 
 * @author mundlamuri
 *
 */
@Repository
public interface PassengerRepository extends CrudRepository<Passenger,Integer>{
	@Override
	Iterable<Passenger> findAll();
}
