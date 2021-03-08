package com.company.repositories.interfaces;
//package name com.company
import com.company.entities.Driver;
//import Driver class
import java.util.List;

public interface IDriverRepository {
    //createDriver method
    boolean createDriver(Driver driver);
    //getDriver method for reference DriverRepo
    Driver getDriver(int id);
    //getAllDrivers method for reference DriverRepo
    List<Driver> getAllDrivers();
}