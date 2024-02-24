package com.learn2code.vehicle.api.vehiclesearch.service;

import java.util.List;

import com.learn2code.vehicle.api.vehiclesearch.entity.Manufacturer;


public interface ManufacturerService {
	
	Manufacturer saveManufacturer(Manufacturer manufacturer);
	List<Manufacturer> fetchAllManufacturers();
	Manufacturer getManufacturerById(int id);
	Manufacturer updateManufacturer(Manufacturer dbManufacturer,Manufacturer updatedManufacturer);
}
