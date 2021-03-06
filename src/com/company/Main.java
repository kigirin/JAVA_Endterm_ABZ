package com.company;

import com.company.data.interfaces.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IUserRepository;
import com.company.repositories.CarRepo;
import  com.company.repositories.interfaces.ICarRepository;
import  com.company.repositories.DriverRepo;
import  com.company.repositories.OrderRepo;
import  com.company.repositories.interfaces.IDriverRepository;
import  com.company.repositories.interfaces.IOrderRepository;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Test");
        IDB db = new PostgresDB();
        Scanner scanner = new Scanner(System.in);
        IUserRepository repo = new UserRepository(db);
        MyApplication app = new MyApplication(repo);
        IDriverRepository driverrepo = new DriverRepo(db);
        ICarRepository carrepo = new CarRepo(db);
        IOrderRepository orderrepo = new OrderRepo(db);
        MyCarApplication carApplication = new MyCarApplication(driverrepo,carrepo);
        MyDriverApplication driverApplication = new MyDriverApplication(driverrepo,carrepo);
        MyOrderApplication orderApplication = new MyOrderApplication(orderrepo);
        System.out.println("1. Car");
        System.out.println("2. Driver");
        System.out.println("3. Order");
        System.out.println("4. User");
        System.out.println("Enter option (1-4): ");
        int option = scanner.nextInt();
        if (option == 1){
            carApplication.start();
        } else if(option == 2){
            driverApplication.start();
        } else if(option == 3){
            orderApplication.start();
        } else if (option == 4){
            app.start();
        }
    }
}
