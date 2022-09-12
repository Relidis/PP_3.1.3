package com.example.pp.repository;

import com.example.pp.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public RoleRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

}


