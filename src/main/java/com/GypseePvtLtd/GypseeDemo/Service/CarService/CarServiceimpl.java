package com.GypseePvtLtd.GypseeDemo.Service.CarService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GypseePvtLtd.GypseeDemo.DAO.CarJpaRepository;
import com.GypseePvtLtd.GypseeDemo.Entity.Car;

@Component
public class CarServiceimpl implements CarService {
	@Autowired
	CarJpaRepository repository;
	
	
	@Override
	public Car createCar(Car car) {
		Car savedCar=repository.save(car);
		return savedCar;
	}

	@Override
	public Optional<Car> getCar(String carId) {
		// TODO Auto-generated method stub
		Optional<Car> savedCar=repository.findById(carId);
		return savedCar;
	}

	@Override
	public Car updateCar(Car car) {
		// TODO Auto-generated method stub
		Car savedCar=repository.getReferenceById(car.getCarId());
		
		savedCar.setHealth(car.getHealth());
		savedCar.setType(car.getType());
		savedCar.setUserId(car.getUserId());
		repository.save(savedCar);
		
		return savedCar;
	}

	@Override
	public void deleteCar(String carId) {
		// TODO Auto-generated method stub
		repository.deleteById(carId);

	}

	@Override
	public ArrayList<Car> getAll(String userId) {
		// TODO Auto-generated method stub
		ArrayList<Car> carList=(ArrayList<Car>) repository.findByUserId(userId);
		return carList;
	}

}
