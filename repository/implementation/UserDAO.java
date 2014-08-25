package com.example.login.repository.implementation;

import com.example.login.domain.User;

import java.util.List;

/**
 * Created by joseph on 2014/08/20.
 */
public interface UserDAO
{
    public void createUser(User user);
    public  void updateUser(User user);
    public User findUserByID(int id);
    public void deleteUsers(User user);
    public User getUsers();

    public List<User> getAllUsers();
    public boolean findUserByUsername(String name, String password);
}
