package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;
@Service
public class VehicleServiceImpl  implements VehicleService{
	@Autowired
	VehicleRepo repo;
	@Override
	public Vehicle addVehicle(Vehicle v) {
		repo.save(v);
		return v;
	}

	@Override
	public Vehicle delVehicleById(Integer vid) {
		Vehicle v =  repo.findById(vid).orElseThrow(()->new ResourceNotFoundException("Vehicle", "id",vid));
		if(v!=null) 
			repo.delete(v);

		return v;
	}

	@Override
	public List<Vehicle> getallVehicleDetails() {

		return repo.findallVehicleDetails();
	}

	@Override
	public Vehicle getVehicleById(Integer vid) {

		return repo.findById(vid).orElseThrow(()->new ResourceNotFoundException("Employee", "id",vid));
	}

	@Override
	public List<Vehicle> getVehicleDetailsByColor(String vcolor) {
		// TODO Auto-generated method stub
		if(repo.findVehicleDetailsByColor(vcolor)!=null) {
			return repo.findVehicleDetailsByColor(vcolor);}
		throw new ResourceNotFoundException("Vehicle", "Vcolor",vcolor);
	}

	@Override
	public List<Vehicle> getVehicleDetailsByPrice(Double vprice) {
		if( repo.findVehicleDetailsByPrice(vprice)!=null)
			return repo.findVehicleDetailsByPrice(vprice);
		throw new ResourceNotFoundException("Vehicle", "Vprice",vprice);
	}

	@Override
	public Vehicle updateVehicleById(Vehicle v) {
		Vehicle v1 =repo.findById(v.getId()).orElse(null);
		if(v1!=null) {
			v1.setVprice(v.getVprice());
		  v1.setVprice(v.getVprice());
		v1.setVmodel(v.getVmodel());
		v1.setVcolor(v.getVcolor());
  return 	repo.save(v1);
		}
		throw new ResourceNotFoundException("Vehicle", "id",v.getId());
	}

	@Override
	public List<Vehicle> getVehicleDetailsByPriceMoreThan10lac() {
		if(repo.findVehicleDetailsByPriceMoreThan10lac()!=null)
			return repo.findVehicleDetailsByPriceMoreThan10lac();
		throw new ResourceNotFoundException("Vehicle", "Price",">10lac");
	}

	@Override
	public List<Vehicle> getVehicleDetailsSortedBasedOnPrice() {

		return repo.findVehicleDetailsSortedBasedOnPrice() ;

	}

	@Override
	public List<Vehicle> getVehicleDetailsSortedBasedOnColor() {

		return repo.findVehicleDetailsSortedBasedOncolor();
	}

}
