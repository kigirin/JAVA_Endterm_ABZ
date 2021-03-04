package com.company.controllers;

import entities.Car;

import java.util.List;

public class CarController {
    private final com.company.repositories.interfaces.ICarRepository repo;

    public CarController(com.company.repositories.interfaces.ICarRepository repo)
    {
        this.repo=repo;
    }
    public  String createCar(String name){
        Car car = new Car(name);
        Car car1 = new Car(name);
        boolean created= repo.createCar(Car);
        return (created ? "Car was created!" : "Car creation was failed");
    }
    public String getCar(int id){
        Car car = repo.getCar(id);
        return (Car == null ? "Car was not found" : Car.toString());
    }

    public String getAllCars(){
        List<Car> Cars = repo.getAllCars();
        return Cars.toString();
    }
}
