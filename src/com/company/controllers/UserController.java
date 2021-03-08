package com.company.controllers;

import com.company.entities.User;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    } // constructor

    public String createUser(String name, String surname, String gender) {// method that notifies if user was created
        boolean male = (gender.toLowerCase().equals("male"));
        User user = new User(name, surname, male);

        boolean created = repo.createUser(user);

        return (created ? "User creation was failed!" : "User was created!");
    }

    public String getUser(int id) {  // method that returns and notifies if User was created
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() { //method that lists all users
        List<User> users = repo.getAllUsers();

        return users.toString();
    }
}