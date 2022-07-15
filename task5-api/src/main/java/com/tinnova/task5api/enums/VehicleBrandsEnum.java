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
	HYUNDAI("Hyundai"),
	JEEP("Jeep"),
	KIA("Kia"),
	LAND_ROVER("Land Rover"),
	MERCEDES_BENZ("Mercedes-Benz"),
	NISSAN("Nissan"),
	PEUGEOT("Peugeot"),
	RENAULT("Renault"),
	SUZUKI("Suzuki"),
	TOYOTA("Toyota"),
	VOLKSWAGEN("Volkswagen"),
	VOLVO("Volvo"),
	YAMAHA("Yamaha"),
	OUTRO("Outro");

	private String brand;

	VehicleBrandsEnum(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}
}
