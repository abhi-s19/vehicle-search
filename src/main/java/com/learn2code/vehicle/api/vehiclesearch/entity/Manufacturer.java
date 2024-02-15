package com.learn2code.vehicle.api.vehiclesearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "manufacturer_name")
	private String manufacturerName;
	@Column(name = "country_of_origin")
	private String countryOfOrigin;

}
