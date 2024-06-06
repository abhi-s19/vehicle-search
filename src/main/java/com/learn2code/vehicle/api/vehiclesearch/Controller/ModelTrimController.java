package com.learn2code.vehicle.api.vehiclesearch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.vehicle.api.vehiclesearch.entity.Model;
import com.learn2code.vehicle.api.vehiclesearch.entity.TrimType;
import com.learn2code.vehicle.api.vehiclesearch.service.ModelTrimService;

@RestController
@RequestMapping("/api/v1/model-trim")
public class ModelTrimController {
	@Autowired
	private ModelTrimService modelTrimServce;
	
	@PostMapping
	public ResponseEntity<Model> createModelTrim(@RequestBody Model model){
		Model savedRecord = modelTrimServce.saveModel(model);
		return new ResponseEntity<>(savedRecord,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/trim-type")
	public ResponseEntity<TrimType> createTrimType(@RequestBody TrimType trimType){
		TrimType savedTrim =  modelTrimServce.saveTrimType(trimType);
		return new ResponseEntity<TrimType>(savedTrim,HttpStatus.CREATED);
	}
}
