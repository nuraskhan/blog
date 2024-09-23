package com.example.PET.DAO;

import com.example.PET.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO{
    List<User> findAll();
    User save(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserByMobile(String mobile);
    User getUserByEmail(String email);
    void setPassword(User user, String password);
    User findById(int id);
}
