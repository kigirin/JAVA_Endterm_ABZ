package com.company.controllers;

import com.company.entities.Car;
import com.company.entities.Driver;
import com.company.repositories.CarRepo;
import com.company.repositories.interfaces.ICarRepository;
import com.company.repositories.interfaces.IDriverRepository;
import java.util.List;
public class DriverController {
    private final ICarRepository carRepository;
    private final IDriverRepository repository;  //variables
    public DriverController(IDriverRepository repository , ICarRepository carRepository){ //constructor
        this.carRepository = carRepository;
        this.repository = repository;
    }
    /*    private int id;
        private String name;
        private String surname;
        private String PhoneNumber;
        private int CarID;*/
    public String createDriver(String name , String surname , String PhoneNumber , int CarID){ // method that notifies if Driver was created or not
        Driver driver = new Driver(name , surname , PhoneNumber , CarID);
        boolean created = repository.createDriver(driver);
        return (created ? "Driver creation was failed" : "Driver was created!");
    }
    public String getDriver(int id){ //method that finds Driver
        Driver driver = repository.getDriver(id);
        return (driver == null ? "Driver was not found!" : driver.toString());
    }
    public String getAllDrivers(){ //method that returns all Drivers from database
        List<Driver> drivers = repository.getAllDrivers();
        return drivers.toString();
    }
    public  String createCar(String model , String number , String colour){// method that notifies if car was created
        Car car = new Car(model , number , colour);
        boolean created= carRepository.createCar(car);
        return (created ? "Car was created!" : "Car creation was failed");
    }
    public String getCar(int id){ // method that returns car from database
        Car car = carRepository.getCar(id);
        return (car == null ? "Car was not found" : car.toString());
    }
    public String getAllCars(){ // method that lists all car
        List<Car> Cars = carRepository.getAllCars();
        return Cars.toString();
    }
}