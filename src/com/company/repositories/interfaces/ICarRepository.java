package com.company.repositories.interfaces;
//package name com.company
import com.company.entities.Car;
//import Car class
import java.util.List;
public interface ICarRepository {
    //createCar method
    boolean createCar(Car car);
    //getCar method for reference CarRepo
    Car getCar(int id);
    //getAllCars method for reference CarRepo
    List<Car> getAllCars();
}