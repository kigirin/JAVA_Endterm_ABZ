package com.company.controllers;

import com.company.entities.Car;
import com.company.repositories.interfaces.ICarRepository;
import java.util.List;
public class CarController {
    private final ICarRepository repo;
    public CarController(ICarRepository repo)
    {
        this.repo=repo;
    }
    public  String createCar(String model , String number , String colour){
        Car car = new Car(model , number , colour);
        boolean created= repo.createCar(car);
        return (created ? "Car was created!" : "Car creation was failed");
    }
    public String getCar(int id){
        Car car = repo.getCar(id);
        return (car == null ? "Car was not found" : car.toString());
    }
    public String getAllCars(){
        List<Car> Cars = repo.getAllCars();
        return Cars.toString();
    }
}