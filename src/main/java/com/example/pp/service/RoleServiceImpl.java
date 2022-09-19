package com.example.pp.service;

import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Transactional(readOnly=true)
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

}