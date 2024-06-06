package com.learn2code.vehicle.api.vehiclesearch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "models")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "model_name")
	private String modelName;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "model_trim",joinColumns = @JoinColumn(name="model_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="trim_id",referencedColumnName = "id"))
	private List<TrimType> trimTypeList;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Manufacturer manufacturer;
	
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Model(int id, String modelName, List<TrimType> trimTypeList) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.trimTypeList = trimTypeList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public List<TrimType> getTrimTypeList() {
		return trimTypeList;
	}
	public void setTrimTypeList(List<TrimType> trimTypeList) {
		this.trimTypeList = trimTypeList;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", modelName=" + modelName + ", trimTypeList=" + trimTypeList + ", manufacturer="
				+ manufacturer + "]";
	}

	
}
