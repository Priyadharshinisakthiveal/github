package com.demo.dao;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.*;

//extends jpa repository to perform CRUD operations
public interface RolesRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}