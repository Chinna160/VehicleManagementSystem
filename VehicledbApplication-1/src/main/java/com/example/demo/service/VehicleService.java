package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService {
	Vehicle addVehicle(Vehicle v);
	Vehicle delVehicleById(Integer vid);
	List<Vehicle> getallVehicleDetails();
	Vehicle getVehicleById(Integer vid);
	List<Vehicle> getVehicleDetailsByColor(String vcolor);
	List<Vehicle> getVehicleDetailsByPrice(Double vprice);
	List<Vehicle> getVehicleDetailsSortedBasedOnPrice();
	List<Vehicle> getVehicleDetailsSortedBasedOnColor();
	Vehicle updateVehicleById(Vehicle v);
	List<Vehicle> getVehicleDetailsByPriceMoreThan10lac();
}
