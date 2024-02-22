package com.learn2code.vehicle.api.vehiclesearch.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicle.api.vehiclesearch.Exception.ManufacturerNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.entity.Manufacturer;
import com.learn2code.vehicle.api.vehiclesearch.service.ManufacturerService;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@PostMapping
	public ResponseEntity<Manufacturer> createManufacturerInDB(@Valid@RequestBody Manufacturer manufacturer){
		
		Manufacturer dbRecord = manufacturerService.saveManufacturer(manufacturer);
		return new ResponseEntity<>(dbRecord,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
		List<Manufacturer> saveManufacturers = manufacturerService.fetchAllManufacturers();
		return new ResponseEntity<>(saveManufacturers,HttpStatus.OK);
		//another way to return
		//return ResponseEntity.status(HttpStatus.OK).body(saveManufacturers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Manufacturer> getManufacturerBasedOnId(@PathVariable int id) throws ManufacturerNotFoundException{
		Manufacturer dbManufacturer = manufacturerService.getManufacturerById(id);
		
		if(dbManufacturer == null) {
			throw new ManufacturerNotFoundException("No Manufacturer found for id:- "+id);
		}
		
		return new ResponseEntity<>(dbManufacturer,HttpStatus.OK);
		//another way to return
		//return ResponseEntity.ok(dbManufacturer);
		
	}

}
