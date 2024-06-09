package com.learn2code.vehicle.api.vehiclesearch.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicle.api.vehiclesearch.Dao.ModelDAO;
import com.learn2code.vehicle.api.vehiclesearch.Dao.TrimTypeDAO;
import com.learn2code.vehicle.api.vehiclesearch.entity.Model;
import com.learn2code.vehicle.api.vehiclesearch.entity.TrimType;
import com.learn2code.vehicle.api.vehiclesearch.service.ModelTrimService;

@Service
public class ModelTrimServiceImpl implements ModelTrimService{

	@Autowired
	private ModelDAO modelDAO;
	
	@Autowired
	private TrimTypeDAO trimTypeDAO;
	
	@Override
	public Model saveModel(Model model) {
		Model savedModel = modelDAO.save(model);
		return savedModel;
	}

	@Override
	public TrimType saveTrimType(TrimType trimType) {
		return trimTypeDAO.save(trimType);
	}

	@Override
	public List<Model> getAllModels() {
		List<Model> savedModels = modelDAO.findAll();
		return savedModels;
	}

}
