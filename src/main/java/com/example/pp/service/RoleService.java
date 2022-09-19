package com.example.pp.service;

import com.example.pp.model.Role;
import com.example.pp.model.User;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);
    Role getRoleByName(String name);
    void addRole(Role role);
    List<Role> getAllRoles();
}


