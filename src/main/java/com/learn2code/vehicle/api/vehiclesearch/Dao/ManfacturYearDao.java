package com.learn2code.vehicle.api.vehiclesearch.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.vehicle.api.vehiclesearch.entity.ManufacturYear;

public interface ManfacturYearDao extends JpaRepository<ManufacturYear, Integer> {

}
