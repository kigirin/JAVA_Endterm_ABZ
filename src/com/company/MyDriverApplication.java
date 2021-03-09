package com.company;

import com.company.controllers.DriverController;
import com.company.repositories.interfaces.ICarRepository;
import com.company.repositories.interfaces.IDriverRepository;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MyDriverApplication {
    private final DriverController controller; //variables
    private final Scanner scanner;

    public MyDriverApplication(IDriverRepository driverRepository , ICarRepository carRepository){
        controller = new DriverController(driverRepository , carRepository);
        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Drivers");
            System.out.println("2. Get Driver by id");
            System.out.println("3. Create Driver");
            System.out.println("0. Exit");
            System.out.println();
            try{
                System.out.println("Enter option(1-3): ");
                int option = scanner.nextInt();
                if(option == 1){
                    getAllDriversMenu();
                }else if(option == 2){
                    getDriverByIdMenu();
                } else if (option == 3){
                    createDriverMenu();
                } else {
                    break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("*************************");
        }
    }
    public void getAllDriversMenu(){
        String response = controller.getAllDrivers();
        System.out.println(response);
    }

    public void getDriverByIdMenu(){
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getDriver(id);
        System.out.println(response);
    }
    public void createDriverMenu(){
        System.out.println("Please enter CarID");
        int CarID = Integer.parseInt(scanner.next());
        try{
            var id = controller.getCar(CarID);
        }
        catch (Exception e){
            return ;
        }
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname:");
        String surname = scanner.next();
        System.out.println("Please enter Phone number:");String PhoneNumber = scanner.next();
        String response = controller.createDriver(name , surname,PhoneNumber,CarID);
        System.out.println(response);
    }
}

