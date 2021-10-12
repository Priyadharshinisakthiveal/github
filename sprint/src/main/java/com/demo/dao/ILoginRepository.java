package com.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;
@Repository
public interface ILoginRepository extends JpaRepository<User,Integer> {
	User findByUsername(String username);
	public boolean existsByUsername(String username);

}