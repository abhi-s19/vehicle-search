package com.learn2code.vehicle.api.vehiclesearch.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "trim_types")
public class TrimType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "trim_type")
	@NotBlank(message = "trimType field is mandatory")
	private String trimType;
	
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinTable(name = "model_trim",joinColumns = @JoinColumn(name="trim_id", referencedColumnName = "id"),
//				inverseJoinColumns = @JoinColumn(name="model_id",referencedColumnName = "id"))
//	private List<Model> modelList;
	
	public TrimType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrimType(int id, String trimType, List<Model> modelList) {
		super();
		this.id = id;
		this.trimType = trimType;
//		this.modelList = modelList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrimType() {
		return trimType;
	}

	public void setTrimType(String trimType) {
		this.trimType = trimType;
	}

	@Override
	public String toString() {
		return "TrimType [id=" + id + ", trimType=" + trimType + "]";
	}
	
	

//	public List<Model> getModelList() {
//		return modelList;
//	}
//
//	public void setModelList(List<Model> modelList) {
//		this.modelList = modelList;
//	}

//	@Override
//	public String toString() {
//		return "TrimType [id=" + id + ", trimType=" + trimType + ", modelList=" + modelList + "]";
//	}
	
	
	
	
}
