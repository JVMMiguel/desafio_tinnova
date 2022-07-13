package com.tinnova.task5api.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.tinnova.task5api.model.Vehicle;
import com.tinnova.task5api.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Transactional
	public Vehicle save(Vehicle vehicle) {
		vehicle.setCreatedAt(new Date());
		return vehicleRepository.save(vehicle);
	}
	
	@Transactional
	public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) throws Exception {
		Vehicle currentVehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Não há veículos com esse ID!"));
		vehicle.setId(vehicleId);
		vehicle.setUpdatedAt(new Date());
		vehicle.setCreatedAt(currentVehicle.getCreatedAt());
		return vehicleRepository.save(vehicle);
	}
	
	@Transactional
	public Vehicle updateEspecificField(Long vehicleId, Map<Object, Object> fields) throws Exception {
		Vehicle currentVehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Não há veículos com esse ID!"));
		
		fields.forEach((k, v) ->{
			Field field = ReflectionUtils.findField(Vehicle.class, (String) k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, currentVehicle, v);
		});
		currentVehicle.setUpdatedAt(new Date());
		return this.save(currentVehicle);
	}
	
	@Transactional
	public void deleteVehicle(Long vehicleId) {
		vehicleRepository.deleteById(vehicleId);
	}
	
	public Vehicle findVehicle(Long vehicleId) throws Exception {
		return vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Veiculo não encontrado."));
	}
}
