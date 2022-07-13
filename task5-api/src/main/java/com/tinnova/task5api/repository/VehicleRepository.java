package com.tinnova.task5api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tinnova.task5api.dto.IVehicleBrandDTO;
import com.tinnova.task5api.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	@Query(value = "SELECT COUNT(*) FROM veiculo WHERE vendido = false", nativeQuery = true)
	int findVehiclesNotSold();
	
	@Query(value = "SELECT marca AS brand, COUNT(*) AS quantity FROM veiculo GROUP BY marca", nativeQuery = true)
	List<IVehicleBrandDTO> findVehiclesByBrand();
	
	@Query(value = "SELECT * FROM veiculo WHERE created > CURRENT_DATE - INTERVAL '7 days'", nativeQuery = true)
	List<Vehicle> findVehiclesRegisteredLastWeek();
}
