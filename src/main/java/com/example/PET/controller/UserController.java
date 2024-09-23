package com.example.PET.controller;


import com.example.PET.entity.User;
import com.example.PET.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.PET.exception.UserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/usr")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        // check again
        return userService.findAll();
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {

        User dbUser = userService.findById(userId);

        if (dbUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return dbUser;
    }


    @PostMapping("/")
    public User addUser(@RequestBody User theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        User dbUser = userService.save(theEmployee);

        return dbUser;
    }
    @PutMapping("")
    public User updateUser(@RequestBody User theEmployee) {

        User dbUser = userService.save(theEmployee);

        return dbUser;
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findById(userId);

        if (tempUser == null) {
            throw new UserNotFoundException("User id not found - " + userId);
        }

        userService.deleteUser(tempUser);

        return "Deleted employee id - " + userId;
    }

}
