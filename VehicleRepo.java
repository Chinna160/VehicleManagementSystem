package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	@Query (value = "select * from Vehicle ",nativeQuery = true)
	List<Vehicle> findallVehicleDetails();
	@Query (value = "select * from Vehicle where vcolor=?1 ",nativeQuery = true)
	List<Vehicle> findVehicleDetailsByColor(String vcolor);
	@Query (value = "select * from Vehicle where vprice=?1 ",nativeQuery = true)
	List<Vehicle> findVehicleDetailsByPrice(Double vprice);
	@Query (value = "select * from Vehicle where vprice>1000000",nativeQuery = true)
	List<Vehicle> findVehicleDetailsByPriceMoreThan10lac();
	@Query (value = "select * from Vehicle order by vprice",nativeQuery = true)
	List<Vehicle>	findVehicleDetailsSortedBasedOnPrice();
	@Query (value = "select * from Vehicle where vprice in(select vprice from Vehicle group by vprice having count(*)>1 ) order by vcolor" ,nativeQuery = true)
	List<Vehicle>	findVehicleDetailsSortedBasedOncolor();
}
