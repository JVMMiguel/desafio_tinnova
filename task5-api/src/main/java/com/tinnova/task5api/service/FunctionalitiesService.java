package com.tinnova.task5api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnova.task5api.dto.IVehicleBrandDTO;
import com.tinnova.task5api.model.Vehicle;
import com.tinnova.task5api.repository.VehicleRepository;

@Service
public class FunctionalitiesService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public int findQtdNotSold() {
		return vehicleRepository.findVehiclesNotSold();
	}
	
	public List<IVehicleBrandDTO> findQtdVehiclesByBrand() {
		return vehicleRepository.findVehiclesByBrand();
	}
	
	public List<Vehicle> findVehiclesRegisteredLastWeek() {
		return vehicleRepository.findVehiclesRegisteredLastWeek();
	}
}
