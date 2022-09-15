package com.example.pp.repository;

import com.example.pp.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }

}


