package com.company.repositories.interfaces;

import com.company.entities.Driver;
import java.util.List;
public interface IDriverRepository {
    boolean createDriver(Driver driver);
    Driver getDriver(int id);
    List<Driver> getAllDrivers();
}