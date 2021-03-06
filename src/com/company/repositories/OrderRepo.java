package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Order;
import com.company.repositories.interfaces.IOrderRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements IOrderRepository {
    private final IDB db;
    public OrderRepo(IDB db){
        this.db = db;
    }
/*    private int id;
    private double cost ;
    private String point_A;
    private String point_B;
    private String date;
    private int driverID;*/
    @Override
    public boolean createOrder(Order order){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "INSERT INTO orders(id , cost , point_A , point_B , date , driverID) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,order.getId());
            st.setDouble(2,order.getCost());
            st.setString(3, order.getPoint_A());
            st.setString(4,order.getPoint_B());
            st.setString(5,order.getDate());
            st.setInt(6,order.getDriverID());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Order getOrder(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT id , cost , point_A , point_B , date , driverID FROM orders WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Order order = new Order(rs.getInt("id"), rs.getDouble("cost"),
                        rs.getString("Point_A") , rs.getString("Point_B") ,
                        rs.getString("date"), rs.getInt("driverID"));
                return null;
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Order> getAllOrders(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "SELECT id , cost , point_A , point_B , date , driverID FROM orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()){
                Order order = new Order(rs.getInt("id"), rs.getDouble("cost"),
                        rs.getString("Point_A") , rs.getString("Point_B") ,
                        rs.getString("date"), rs.getInt("driverID"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
