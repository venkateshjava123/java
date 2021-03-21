package com.example.demo.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Login;


public interface LoginRepo extends JpaRepository<Login, Integer> {

	Optional<Login> findById(int id);

	
}
 