package com.company.repositories.interfaces;
import com.company.entities.Car;
import com.company.entities.Driver;
import java.util.List;
public interface ICarRepository {
    boolean createCar(Car car);
    Car getCar(int id);
    List<Car> getAllCars();
}