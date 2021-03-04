package com.company.controllers;

import java.util.List;

public class OrderController {
    private com.company.repositories.interfaces.IOrderRepository repo;
    public OrderController (com.company.repositories.interfaces.IOrderRepository repo)
    {
        this.repo=repo;
    }

    public String createOrder( String  )
    {

    }

    public String getOrder(int id){
        com.company.entities.Order order=repo.getOrder(id);
        return (order== null ? "Ordder was not found! " : order.toString());
    }
    public String getAllOrders(){
        List<Order> Orders = repo.getAllOrders();
        return Orders.toString();
    }

}
