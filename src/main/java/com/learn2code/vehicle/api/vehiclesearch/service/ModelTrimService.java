package com.learn2code.vehicle.api.vehiclesearch.service;

import java.util.List;

import com.learn2code.vehicle.api.vehiclesearch.entity.Model;
import com.learn2code.vehicle.api.vehiclesearch.entity.TrimType;

public interface ModelTrimService {
	
	Model saveModel(Model model);
	
	TrimType saveTrimType(TrimType trimType);
	
	List<Model> getAllModels();
}
