package com.learn2code.vehicle.api.vehiclesearch.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicle.api.vehiclesearch.Exception.ModelNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.Exception.TrimTypeNotFoundException;
import com.learn2code.vehicle.api.vehiclesearch.entity.Model;
import com.learn2code.vehicle.api.vehiclesearch.entity.TrimType;
import com.learn2code.vehicle.api.vehiclesearch.service.ModelTrimService;

@RestController
@RequestMapping("/api/v1/model-trim")
public class ModelTrimController {
	@Autowired
	private ModelTrimService modelTrimServce;
	
	@PostMapping
	public ResponseEntity<Model> createModelTrim(@Valid@RequestBody Model model){
		Model savedRecord = modelTrimServce.saveModel(model);
		return new ResponseEntity<>(savedRecord,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/trim-type")
	public ResponseEntity<TrimType> createTrimType(@Valid@RequestBody TrimType trimType){
		TrimType savedTrim =  modelTrimServce.saveTrimType(trimType);
		return new ResponseEntity<TrimType>(savedTrim,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Model>> fetchAllModels(){
		List<Model> dBModels = modelTrimServce.getAllModels();
		if(dBModels.size()>0)
			return new ResponseEntity<List<Model>>(dBModels,HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Model> updateModel(@PathVariable int id, @Valid@RequestBody Model model) throws ModelNotFoundException{
		
		return new ResponseEntity<Model>(modelTrimServce.ModifyModel(id, model),HttpStatus.OK);

	}
	
	@PutMapping("/trim-type/{id}")
	public ResponseEntity<TrimType> updateTrimType(@PathVariable int id,@Valid@RequestBody TrimType trimType) throws TrimTypeNotFoundException {
		
		return new ResponseEntity<TrimType>(modelTrimServce.ModifyTrimType(id, trimType),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteModel(@PathVariable int id) throws ModelNotFoundException{
		modelTrimServce.deleteModelById(id);
		return new ResponseEntity<String>("Model is deleted from db for Id-"+id,HttpStatus.OK);
	}

	//****this is not fully functional as TrimType entity does not know about the linking or foreign key model_trim 
	//    table so we have to discuss with product owner so as of now it is commented  	
//	@DeleteMapping("/trim-type/{id}")
//	public ResponseEntity<String> deleteTrimType(@PathVariable int id) throws TrimTypeNotFoundException {
//		modelTrimServce.deleteTrimType(id);
//		return new ResponseEntity<String>("Trim-Type is deleted from db for Id-"+id,HttpStatus.OK);
//	}
	
	@GetMapping("/manufacturer/{manufacturerId}")
	public ResponseEntity<List<Model>> findAllModelsForManufacturer(@PathVariable int manufacturerId) throws Exception{
		List<Model> dbModels = modelTrimServce.getModelsByManufacturerId(manufacturerId);
		if(dbModels.size()>0) {
			return new ResponseEntity<List<Model>>(dbModels,HttpStatus.OK);
		}
		else {
			throw new ModelNotFoundException("Model not found in db with manufacturerId: "+manufacturerId);
		}
		
	}
	
	@GetMapping("/manufacturer/name/{manufacturerName}")
	public ResponseEntity<List<Model>> findAllModelsForManufacturer(@PathVariable String manufacturerName) throws Exception{
		List<Model> dbModels = modelTrimServce.getModelsByManufacturerName(manufacturerName);
		if(dbModels.size()>0) {
			return new ResponseEntity<List<Model>>(dbModels,HttpStatus.OK);
		}
		else {
			throw new ModelNotFoundException("Model not found in db with manufacturer name: "+manufacturerName);
		}
		
	}
	
}
