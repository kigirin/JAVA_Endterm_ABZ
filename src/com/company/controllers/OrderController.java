package com.company.controllers;

import com.company.entities.Order;
import java.util.List;
public class OrderController {
    private com.company.repositories.interfaces.IOrderRepository repo;
    public OrderController (com.company.repositories.interfaces.IOrderRepository repo)
    {
        this.repo=repo;
    }
    /*    private double cost ;
        private String point_A;
        private String point_B;
        private String date;
        private int driverID;*/
    public String createOrder(double cost , String point_A , String point_B , String date , int driverID)
    {
        Order order = new Order(cost , point_A , point_B , date , driverID);
        boolean created = repo.createOrder(order);
        return (created ? "Order was created!" : "Order creation was failed!");
    }
    public String getOrder(int id){
        com.company.entities.Order order=repo.getOrder(id);
        return (order== null ? "Order was not found! " : order.toString());
    }
    public String getAllOrders(){
        List<Order> Orders = repo.getAllOrders();
        return Orders.toString();
    }
}