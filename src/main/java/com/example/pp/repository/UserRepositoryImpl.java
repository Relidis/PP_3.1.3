package com.example.pp.repository;

import com.example.pp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional(readOnly=true)
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Transactional(readOnly=true)
    @Override
    public void deleteUser(Long id) {

        try {
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (NullPointerException e) {
            System.out.println("User с указанным вами id не существует!");
        }
    }
    @Transactional(readOnly=true)
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
    @Transactional(readOnly=true)
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Transactional(readOnly=true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }
    @Transactional(readOnly=true)
    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}