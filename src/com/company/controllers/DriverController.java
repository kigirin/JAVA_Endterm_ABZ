package com.company.controllers;

import com.company.entities.Car;
import com.company.entities.Driver;

import java.util.List;

public class DriverController {
    private final ICarRepository repo;
    private final IDriverRepository driverRepo;
    public DriverController(IDriverRepository repo , ICarRepository driverRepo){
        this.repo = repo;
        this.driverRepo = driverRepo;
    }
    public String createDriver(String name , String surname , String phoneNumber , int CarID){
        Driver driver = new Driver(name , surname , phoneNumber , CarID);

        boolean created = repo.createDriver(driver);

        return (created ? "Driver was created!" : "Driver creation was failed!");
    }
    public String getDriver(int id){
        Driver driver = repo.getDriver(id);
        return (driver == null ? "Driver was not found!" : train.toString());
    }

    public String getAllDrivers(){
        List<Driver> drivers = repo.getAllDrivers();
        return drivers.toString();
    }
    public  String createCar(String name){
        Car car = new Car(name);

        boolean created= repo.createCar(Car);
        return (created ? "Car was created!" : "Car creation was failed");
    }
    public Car String getCar(int id){
        Car car = CarRepo.getCar(id);
        return car;
    }

    public String getAllCars(){
        List<Car> Cars = repo.getAllCars();
        return Cars.toString();
    }

}
