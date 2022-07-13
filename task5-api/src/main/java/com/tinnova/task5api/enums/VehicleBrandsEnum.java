package com.tinnova.task5api.enums;

public enum VehicleBrandsEnum {
	ALFA_ROMEO("Alfa Romeo"),
	ASTON_MARTIN("Aston Martin"),
	AUDI("Audi"),
	BMW("Bmw"),
	CHEVROLET("Chevrolet"),
	CITROEN("Citroen"),
	FIAT("Fiat"),
	FORD("Ford"),
	HONDA("Honda"),
	JEEP("Jeep"),
	KIA("Kia"),
	RENAULT("Renault"),
	SUZUKI("Suzuki"),
	VOLKSWAGEN("Volkswagen"),
	OUTRO("Outro");

	private String brand;

	VehicleBrandsEnum(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}
}
