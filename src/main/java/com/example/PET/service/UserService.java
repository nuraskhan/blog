package com.example.PET.service;

import com.example.PET.DAO.UserDAO;
import com.example.PET.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();

    User findByEmail(String email);

    User findByPhone(String number);

    User save(User theEmployee);

    void update(User theEmployee);

    void deleteUser(User user);

    void setPassword(User user, String password);
    User findById(int id);
}
