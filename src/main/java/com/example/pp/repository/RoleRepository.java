package com.example.pp.repository;

import com.example.pp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository {

    Role getRoleById(Long id);
}
