package com.learn2code.vehicle.api.vehiclesearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicle.api.vehiclesearch.entity.Manufacturer;
import com.learn2code.vehicle.api.vehiclesearch.service.ManufacturerService;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@PostMapping
	public ResponseEntity<Manufacturer> createManufacturerInDB(@RequestBody Manufacturer manufacturer){
		
		Manufacturer dbRecord = manufacturerService.saveManufacturer(manufacturer);
		return new ResponseEntity<>(dbRecord,HttpStatus.CREATED);
	}

}
