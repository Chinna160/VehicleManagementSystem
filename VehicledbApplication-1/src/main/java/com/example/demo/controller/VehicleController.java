package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService ser;
	// localhost:8080/addvehicle
	@PostMapping("/addvehicle")
	ResponseEntity<Vehicle> addvehicle(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.addVehicle(v),HttpStatus.CREATED);
	}
	//localhost:8080/getvehiclebyid
	@GetMapping("/getvehiclebyid")
	ResponseEntity<Vehicle> getvehicleById(@RequestHeader Integer vid)
	{
		return new ResponseEntity<Vehicle>(ser.getVehicleById(vid),HttpStatus.FOUND);
	}
	//localhost:8080/getallvehicles
	@GetMapping("/getallvehicles")
	ResponseEntity<List<Vehicle>> getAllVeh()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getallVehicleDetails(),HttpStatus.FOUND);
	}
	//localhost:8080/delvehiclebyid
	@DeleteMapping("/delvehiclebyid")
	ResponseEntity<Vehicle> delvehicleById(@RequestParam Integer vid)
	{
		return new ResponseEntity<Vehicle>(ser.delVehicleById(vid),HttpStatus.OK);
	}
	//localhost:8080/getvehiclebycolor
	@GetMapping("/getvehiclebycolor")
	ResponseEntity<List<Vehicle>> getAllVehByColor(@RequestHeader  String vcolor)
	{
		return new ResponseEntity<List<Vehicle>>(ser.getVehicleDetailsByColor(vcolor),HttpStatus.FOUND);
	}
	//localhost:8080/getvehiclebyprice
	@GetMapping("/getvehiclebyprice")
	ResponseEntity<List<Vehicle>> getAllVehByPrice(@RequestHeader  Double vprice)
	{
		return new ResponseEntity<List<Vehicle>>(ser.getVehicleDetailsByPrice(vprice),HttpStatus.FOUND);
	}
	//localhost:8080/getvehicleabove10lac
	@GetMapping("/getvehicleabove10lac")
	ResponseEntity<List<Vehicle>> getAllVehAbove10lac()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getVehicleDetailsByPriceMoreThan10lac(),HttpStatus.FOUND);
	}
	//localhost:8080/getvehiclesortedbycolor
	@GetMapping("/getvehiclesortedbycolor")
	ResponseEntity<List<Vehicle>> getAllVehSortByColor()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getVehicleDetailsSortedBasedOnColor(),HttpStatus.FOUND);
	}
	//localhost:8080/getvehiclesortedbyprice
	@GetMapping("/getvehiclesortedbyprice")
	ResponseEntity<List<Vehicle>> getAllVehSortByPrice()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getVehicleDetailsSortedBasedOnPrice(),HttpStatus.FOUND);
	}
	//localhost:8080/updatevehiclebyid
	@PutMapping("updatevehiclebyid")
	ResponseEntity<Vehicle> updatevehiclebyid(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.updateVehicleById(v),HttpStatus.CREATED);
	}

}
