package com.example.PET.service;

import com.example.PET.DAO.UserDAO;
import com.example.PET.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User findByPhone(String number) {
        return userDAO.getUserByMobile(number);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void update(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void setPassword(User user, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        userDAO.setPassword(user, encodedPassword);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }
}
