package com.example.report.controllers;

import com.example.report.models.User;
import com.example.report.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getList() {
        return userService.userList();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id) {
        userService.removeUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable int id, @RequestBody User newUser) {
        newUser.setId(id);
        userService.updateUser(newUser);
        return newUser;
    }
}