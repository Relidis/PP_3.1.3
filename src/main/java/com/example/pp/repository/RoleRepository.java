package com.example.pp.repository;

import com.example.pp.model.Role;

import java.util.List;


public interface RoleRepository {

    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();

    void addRole(Role role);
}
