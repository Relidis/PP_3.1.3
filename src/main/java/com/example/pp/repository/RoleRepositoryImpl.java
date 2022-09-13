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

    public RoleRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional(readOnly=true)
    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

}


