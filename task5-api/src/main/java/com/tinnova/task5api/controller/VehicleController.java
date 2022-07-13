package com.tinnova.task5api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/veiculos")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private FunctionalitiesService functionalitiesService;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	// Método para poder listar todos os veículos cadastrados - GET
	@GetMapping
	public List<Vehicle> listVehicles() {
		return vehicleRepository.findAll();
	}
	
	// Método para poder listar veículos pelo ID - GET
	@GetMapping("/{vehicleId}")
	public Vehicle findVehicleById(@PathVariable Long vehicleId) throws Exception {
		return vehicleService.findVehicle(vehicleId);
	}
	
	// Método para fazer a inserção de um novo veículo - POST
	@PostMapping
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}
	
	// Método para fazer a atualização do veículo - PUT
	@PutMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicle) throws Exception {
		if (!vehicleRepository.existsById(vehicleId)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, vehicle));
	}
	
	// Método para fazer a atualização do um atributo específico do veículo - PATCH
	@PatchMapping("/{vehicleId}")
	public Vehicle patchVehicle(@PathVariable Long vehicleId, @RequestBody Map<Object, Object> fields) throws Exception {
		return vehicleService.updateEspecificField(vehicleId, fields);
	}
	
	// Método para fazer a deleção de um veículo pelo ID - DELETE
	@DeleteMapping("/{vehicleId}")
	public ResponseEntity<Void> removeVehicle(@PathVariable Long vehicleId) {
		if (!vehicleRepository.existsById(vehicleId)) {
			return ResponseEntity.notFound().build();
		}
		vehicleService.deleteVehicle(vehicleId);
		return ResponseEntity.noContent().build();
	}
	
	// Faz a busca pelos carros que ainda não foram vendidos
	@GetMapping("/find/not-sold")
	public int vehiclesNotSold() {
		return functionalitiesService.findQtdNotSold();
	}
	
	// Faz o "filtro" de carros pela marca
	@GetMapping("/find/brand")
	public List<IVehicleBrandDTO> vehiclesByBrand() {
		return functionalitiesService.findQtdVehiclesByBrand();
	}
	
	// Faz o "filtro" dos carros que foram registrados na última semana
	@GetMapping("/find/weekly-register")
	public List<Vehicle> weeklyRegister() {
		return functionalitiesService.findVehiclesRegisteredLastWeek();
	}
}
