package com.example.report.dao;

import com.example.report.models.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public List<User> userList();

    public User getUserById(int id);
}
