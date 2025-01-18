package com.learn2code.vehicle.api.vehiclesearch.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2code.vehicle.api.vehiclesearch.Dao.ModelDAO;
import com.learn2code.vehicle.api.vehiclesearch.Dao.TrimTypeDAO;
import com.learn2code.vehicle.api.vehiclesearch.Exception.ModelNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.Exception.TrimTypeNotFoundException;
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

	@Override
	public Model ModifyModel(int id,Model model) throws ModelNotFoundException {
		Model dbModel = getModelById(id);
		dbModel.setModelName(model.getModelName());
		return modelDAO.save(dbModel);
	}

	@Override
	public TrimType ModifyTrimType(int id,TrimType trimType) throws TrimTypeNotFoundException {
		TrimType dbTrimType = getTrimTypeById(id);
		dbTrimType.setTrimType(trimType.getTrimType());
		return trimTypeDAO.save(dbTrimType);
	}

	@Override
	public Model getModelById(int id) throws ModelNotFoundException {
		Optional<Model> dbModelOptional = modelDAO.findById(id);
		if(!dbModelOptional.isPresent()) {
			throw new ModelNotFoundException("No Model found in DB with ID-"+id);
		}
		return dbModelOptional.get();
	}

	@Override
	public TrimType getTrimTypeById(int id) throws TrimTypeNotFoundException {
		Optional<TrimType> dbTrimTypeOptional = trimTypeDAO.findById(id);
		if(!dbTrimTypeOptional.isPresent()) {
			throw new TrimTypeNotFoundException("No TrimType found in DB with ID-"+id);
		}
		return dbTrimTypeOptional.get();
	}

	@Override
	public void deleteModelById(int id) throws ModelNotFoundException {
		
		Model dbModel = getModelById(id);
		try {
			modelDAO.delete(dbModel);
		}
		catch(Exception e) {
			System.out.println("******unable to delete model, check db connection:- *************"+e.getMessage());
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteTrimType(int id) throws TrimTypeNotFoundException {
		TrimType dbTrim = getTrimTypeById(id);
		try {
			trimTypeDAO.delete(dbTrim);
		}
		catch(Exception e) {
			System.out.println("******unable to delete trim type, check db connection:- *************"+e.getMessage());
			e.printStackTrace();
		}	
		
	}

}
