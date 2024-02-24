package com.learn2code.vehicle.api.vehiclesearch.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicle.api.vehiclesearch.Dao.ManufacturerDao;
import com.learn2code.vehicle.api.vehiclesearch.entity.Manufacturer;
import com.learn2code.vehicle.api.vehiclesearch.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;
	@Override
	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return manufacturerDao.save(manufacturer);
	}
	@Override
	public List<Manufacturer> fetchAllManufacturers() {
		// TODO Auto-generated method stub
		return manufacturerDao.findAll();
	}
	@Override
	public Manufacturer getManufacturerById(int id) {
		// TODO Auto-generated method stub
		 Optional<Manufacturer> dbManufacturerOptional = manufacturerDao.findById(id);
		if(dbManufacturerOptional.isPresent())
			return dbManufacturerOptional.get();
		return null;
	}
	@Override
	public Manufacturer updateManufacturer(Manufacturer dbManufacturer,Manufacturer updatedManufacturer) {
		// TODO Auto-generated method stub
		dbManufacturer.setManufacturerName(updatedManufacturer.getManufacturerName());
		dbManufacturer.setCountryOfOrigin(updatedManufacturer.getCountryOfOrigin());
		
		return manufacturerDao.save(dbManufacturer);
	}
	@Override
	public Void deleteManufacturerById(int id) {
		manufacturerDao.deleteById(id);
		return null;
	}

}
