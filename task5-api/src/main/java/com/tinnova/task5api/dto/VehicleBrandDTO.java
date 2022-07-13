package com.tinnova.task5api.dto;

import com.tinnova.task5api.enums.VehicleBrandsEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleBrandDTO implements IVehicleBrandDTO {
	private VehicleBrandsEnum brand;
	private int quantity;
}
