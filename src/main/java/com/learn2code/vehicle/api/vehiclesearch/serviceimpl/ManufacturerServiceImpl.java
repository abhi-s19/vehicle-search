package com.learn2code.vehicle.api.vehiclesearch.serviceimpl;

import java.util.List;

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

}
