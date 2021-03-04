package com.company.controllers;

import com.company.entities.Car;
import com.company.entities.Driver;
import com.company.repositories.CarRepo;
import com.company.repositories.interfaces.ICarRepository;
import com.company.repositories.interfaces.IDriverRepository;
import java.util.List;
public class DriverController {
    private final ICarRepository carRepository;
    private final IDriverRepository repository;
    public DriverController(IDriverRepository repository , ICarRepository carRepository){
        this.carRepository = carRepository;
        this.repository = repository;
    }
    /*    private int id;
        private String name;
        private String surname;
        private String PhoneNumber;
        private int CarID;*/
    public String createDriver(String name , String surname , String PhoneNumber , int CarID){
        Driver driver = new Driver(name , surname , PhoneNumber , CarID);
        boolean created = repository.createDriver(driver);
        return (created ? "Driver was created!" : "Driver creation was failed");
    }
    public String getDriver(int id){
        Driver driver = repository.getDriver(id);
        return (driver == null ? "Driver was not found!" : driver.toString());
    }
    public String getAllDrivers(){
        List<Driver> drivers = repository.getAllDrivers();
        return drivers.toString();
    }
    public  String createCar(String model , String number , String colour){
        Car car = new Car(model , number , colour);
        boolean created= carRepository.createCar(car);
        return (created ? "Car was created!" : "Car creation was failed");
    }
    public String getCar(int id){
        Car car = carRepository.getCar(id);
        return (car == null ? "Car was not found" : car.toString());
    }
    public String getAllCars(){
        List<Car> Cars = carRepository.getAllCars();
        return Cars.toString();
    }
}