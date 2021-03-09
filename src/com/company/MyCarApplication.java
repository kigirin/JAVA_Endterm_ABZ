package com.company;

import com.company.controllers.CarController;
import com.company.controllers.DriverController;
import com.company.repositories.interfaces.ICarRepository;
import com.company.repositories.interfaces.IDriverRepository;
import java.util.Scanner;
public class MyCarApplication {
    private final CarController controller;
    private final Scanner scanner;
    public MyCarApplication(IDriverRepository driverRepository ,  ICarRepository carRepository) {
        controller  = new CarController (carRepository);
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Car Application");
            System.out.println("Select option:");
            System.out.println("1. Get all cars");
            System.out.println("2. Get car by id");
            System.out.println("3. Create car");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCarsMenu();
                } else if (option == 2) {
                    getCarByIdMenu();
                } else if (option == 3) {
                    createCarMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("*************************");
        }
    }
    public void getAllCarsMenu() {
        String response = controller.getAllCars();
        System.out.println(response);
    }
    public void getCarByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getCar(id);
        System.out.println(response);
    }
    public void createCarMenu() {
        System.out.println("Please enter model of Car");
        String model = scanner.next();
        System.out.println("Please enter number(ГОС НОМЕР) of Car");
        String number = scanner.next();
        System.out.println("Please enter colour of Car");
        String colour = scanner.next();
        String response = controller.createCar(model, number, colour);
        System.out.println(response);
    }
}
