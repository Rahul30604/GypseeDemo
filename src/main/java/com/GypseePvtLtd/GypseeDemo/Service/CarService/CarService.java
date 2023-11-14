package com.GypseePvtLtd.GypseeDemo.Service.CarService;

import java.util.ArrayList;
import java.util.Optional;

import com.GypseePvtLtd.GypseeDemo.Entity.Car;

public interface CarService {
	public Car createCar(Car car);
	public Optional<Car> getCar(String carId);
	public Car updateCar(Car car);
	public void deleteCar(String carId);
	public ArrayList<Car> getAll(String userId);

}
