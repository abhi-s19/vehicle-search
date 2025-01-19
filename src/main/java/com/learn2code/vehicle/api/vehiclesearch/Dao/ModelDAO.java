package com.learn2code.vehicle.api.vehiclesearch.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicle.api.vehiclesearch.entity.Manufacturer;
import com.learn2code.vehicle.api.vehiclesearch.entity.Model;

public interface ModelDAO extends JpaRepository<Model, Integer> {

	List<Model> findByManufacturer(Manufacturer manufacturer);
	
	

}
