package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
