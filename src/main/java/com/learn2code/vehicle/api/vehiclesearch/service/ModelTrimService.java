package com.learn2code.vehicle.api.vehiclesearch.service;

import java.util.List;

import com.learn2code.vehicle.api.vehiclesearch.Exception.ModelNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.Exception.TrimTypeNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.entity.Model;
import com.learn2code.vehicle.api.vehiclesearch.entity.TrimType;

public interface ModelTrimService {
	
	Model saveModel(Model model);
	
	TrimType saveTrimType(TrimType trimType);
	
	List<Model> getAllModels();
	
	Model ModifyModel(int id, Model model) throws ModelNotFoundException;
	
	TrimType ModifyTrimType(int id, TrimType trimType) throws TrimTypeNotFoundException;
	
	Model getModelById(int id) throws ModelNotFoundException;
	
	TrimType getTrimTypeById(int id) throws TrimTypeNotFoundException;
}
