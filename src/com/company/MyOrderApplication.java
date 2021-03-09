package com.company;

import com.company.controllers.DriverController;
import com.company.controllers.OrderController;
import com.company.repositories.interfaces.IOrderRepository;
import com.company.repositories.interfaces.IDriverRepository;

import java.util.Scanner;

public class MyOrderApplication {
    private final OrderController controller;
    private final Scanner scanner;
    public MyOrderApplication(IOrderRepository orderRepository){
        controller = new OrderController(orderRepository);
        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Orders");
            System.out.println("2. Get Order by id");
            System.out.println("3. Create Order");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllOrdersMenu();
                } else if (option == 2) {
                    getOrderByIdMenu();
                } else if (option == 3) {
                    createOrderMenu();
                } else {
                    break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("************************");
        }
    }
    public void getAllOrdersMenu() {
        String response = controller.getAllOrders();
        System.out.println(response);
    }

    public void getOrderByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getOrder(id);
        System.out.println(response);
    }
    public void createOrderMenu(){
        System.out.println("Please enter Order cost");
        double cost = scanner.nextDouble();
        System.out.println("Please enter from address Order:");
        String point_A = scanner.next();
        System.out.println("Please enter to address Order");
        String point_B = scanner.next();
        System.out.println("Please enter date of Order");
        String date = scanner.next();
        System.out.println("Please enter Driver ID who accept your Order");
        int driverID = scanner.nextInt();
        String response = controller.createOrder(cost,point_A,point_B,date,driverID);
        System.out.println(response);
/*        private int id;
        private double cost ;
        private String point_A;
        private String point_B;
        private String date;
        private int driverID;*/
    }
}
