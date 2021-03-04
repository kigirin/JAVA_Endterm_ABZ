package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Car;
import com.company.repositories.interfaces.ICarRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CarRepo implements ICarRepository {
    private final IDB db;

    public CarRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCar(Car car) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Car(model) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, car.getModel());
            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Car getCar(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, model FROM Cars WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("model"));
                return car;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, model FROM Cars";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("model"));
                cars.add(car);
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}