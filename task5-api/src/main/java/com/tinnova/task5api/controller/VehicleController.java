package com.tinnova.task5api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.task5api.dto.IVehicleBrandDTO;
import com.tinnova.task5api.model.Vehicle;
import com.tinnova.task5api.repository.VehicleRepository;
import com.tinnova.task5api.service.FunctionalitiesService;
import com.tinnova.task5api.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculos")
@Api(value = "Vehicles REST API")
@CrossOrigin(origins = "*")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private FunctionalitiesService functionalitiesService;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos cadastrados")
	public List<Vehicle> listVehicles() {
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/{vehicleId}")
	@ApiOperation(value = "Retorna os veículos pelo ID")
	public Vehicle findVehicleById(@PathVariable Long vehicleId) throws Exception {
		return vehicleService.findVehicle(vehicleId);
	}
	
	@PostMapping
	@ApiOperation(value = "Faz a inserção de um novo veículo")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}
	
	@PutMapping("/{vehicleId}")
	@ApiOperation(value = "Faz a atualização do veículo")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicle) throws Exception {
		if (!vehicleRepository.existsById(vehicleId)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, vehicle));
	}
	
	@PatchMapping("/{vehicleId}")
	@ApiOperation(value = "Faz a atualização do um atributo específico do veículo")
	public Vehicle patchVehicle(@PathVariable Long vehicleId, @RequestBody Map<Object, Object> fields) throws Exception {
		return vehicleService.updateEspecificField(vehicleId, fields);
	}
	
	@DeleteMapping("/{vehicleId}")
	@ApiOperation(value = "Faz a deleção de um veículo pelo ID")
	public ResponseEntity<Void> removeVehicle(@PathVariable Long vehicleId) {
		if (!vehicleRepository.existsById(vehicleId)) {
			return ResponseEntity.notFound().build();
		}
		vehicleService.deleteVehicle(vehicleId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/find/not-sold")
	@ApiOperation(value = "Retorna todos os veículos que ainda não foram vendidos")
	public int vehiclesNotSold() {
		return functionalitiesService.findQtdNotSold();
	}
	
	@GetMapping("/find/brand")
	@ApiOperation(value = "Retorna os veículos pela marca")
	public List<IVehicleBrandDTO> vehiclesByBrand() {
		return functionalitiesService.findQtdVehiclesByBrand();
	}
	
	@GetMapping("/find/weekly-register")
	@ApiOperation(value = "Retorna os veículos que foram registrados na última semana")
	public List<Vehicle> weeklyRegister() {
		return functionalitiesService.findVehiclesRegisteredLastWeek();
	}
}
