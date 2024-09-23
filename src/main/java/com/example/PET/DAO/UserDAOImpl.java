package com.example.PET.DAO;

import com.example.PET.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> findAll(){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User>users =  query.getResultList();
        return users;
    }

    @Override
    public User save(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.detach(user);
    }

    @Override
    public User getUserByMobile(String mobile) {
        return entityManager.find(User.class, mobile);
    }

    @Override
    public User getUserByEmail(String email) {
        return entityManager.find(User.class, email);
    }

    @Override
    public void setPassword(User user ,String password) {
        user.setPasswordHash(password);
        entityManager.merge(user);
    }

    @Override
    public User findById(int id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        User user = query.setParameter("id", id).getSingleResult();
        return user;
    }
}
