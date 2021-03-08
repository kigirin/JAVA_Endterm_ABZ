package com.company.repositories;
//package name com.company
import com.company.data.interfaces.IDB;
//import IDB class
import com.company.entities.Car;
//import Car class
import com.company.repositories.interfaces.ICarRepository;
//import ICarRepository
import java.sql.*;
//import java.sql
import java.util.ArrayList;
//import ArrayList
import java.util.List;
//import util.List

public class CarRepo implements ICarRepository {
    //IDB class , db object
    private final IDB db;
    //constructor for db
    public CarRepo(IDB db) {
        this.db = db;
    }

    //@Override tells the compiler
    @Override
    public boolean createCar(Car car) {
        //Connection SQL
        Connection con = null;
        //try/catch exception of insert to our DB
        try {
            con = db.getConnection();
            String sql = "INSERT INTO car(model,number,colour) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, car.getModel());
            st.setString(2, car.getNumber());
            st.setString(3, car.getColour());
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
    //@Override tells the compiler
    @Override
    public Car getCar(int id) {
        //Connection to SQL
        Connection con = null;
        try {
            //SELECT id which contain
            con = db.getConnection();
            //db get connection
            String sql = "SELECT id, model,number,colour FROM car WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Car car = new Car(rs.getInt("id"),
                        rs.getString("model") ,
                        rs.getString("number") ,
                        rs.getString("colour"));
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
    //@Override tells the compiler
    @Override
    public List<Car> getAllCars() {
        Connection con = null;
        //Connection SQL
        try {
            con = db.getConnection();
            //connection database
            String sql = "SELECT id, model, number, colour FROM car";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("model") , rs.getString("number") , rs.getString("colour"));
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