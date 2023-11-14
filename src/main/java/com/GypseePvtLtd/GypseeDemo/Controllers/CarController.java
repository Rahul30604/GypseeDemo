package com.GypseePvtLtd.GypseeDemo.Controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GypseePvtLtd.GypseeDemo.Entity.Car;
import com.GypseePvtLtd.GypseeDemo.Service.CarService.CarServiceimpl;

@RestController
public class CarController {

	@Autowired
	CarServiceimpl service;
	
	
	@GetMapping("/cars/{carId}")
	public Optional<Car> getCar(@PathVariable String carId) {
		Optional<Car> savedCar=service.getCar(carId);
		return savedCar;
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car savedCar=service.createCar(car);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(savedCar.getCarId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	@PutMapping("/cars")
	public ResponseEntity<Car> updateCar(@RequestBody Car car) {
		
	      Car savedCar=service.updateCar(car);
	      return new ResponseEntity<Car>(HttpStatus.OK);
		
	}
	@DeleteMapping("/cars/{carId}")
	public void deleteCar(@PathVariable String carId) {
		service.deleteCar(carId);
	}
	
	@GetMapping("/cars")
	public ArrayList<Car> getAllCars(@RequestHeader("userId") String userId) {
		ArrayList<Car> carsList=service.getAll(userId);
		return carsList;
	}
		
	
}
