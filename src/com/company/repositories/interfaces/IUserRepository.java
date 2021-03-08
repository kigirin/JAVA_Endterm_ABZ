package com.company.repositories.interfaces;
//package name com.company
import com.company.entities.User;
//import User class
import java.util.List;

public interface IUserRepository {
    //createUser method
    boolean createUser(User user);
    //getUser method for reference UserRepository
    User getUser(int id);
    //getAllUsers method for reference UserRepository
    List<User> getAllUsers();
}