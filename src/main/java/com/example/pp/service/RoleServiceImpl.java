package com.example.pp.service;

import com.example.pp.model.Role;
import com.example.pp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly=true)
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

}