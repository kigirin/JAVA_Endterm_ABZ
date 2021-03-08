package com.company.controllers;

import com.company.entities.Car;
import com.company.repositories.interfaces.ICarRepository;
import java.util.List;
public class CarController {
    private final ICarRepository repo;
    public CarController(ICarRepository repo)
    {
        this.repo=repo;
    } //constructor
    public  String createCar(String model , String number , String colour){ //method that notifies us if object was created or not
        Car car = new Car(model , number , colour);
        boolean created= repo.createCar(car);
        return (created ? "Car creation was failed" : "Car was created");
    }
    public String getCar(int id){//method that notifies if there is car in database
        Car car = repo.getCar(id);
        return (car == null ? "Car was not found" : car.toString());
    }
    public String getAllCars(){ //method that returns all cars
        List<Car> Cars = repo.getAllCars();
        return Cars.toString();
    }
}