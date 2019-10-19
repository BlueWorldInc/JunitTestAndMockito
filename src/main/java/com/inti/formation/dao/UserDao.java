package com.inti.formation.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.formation.entities.User;
import com.inti.formation.repositories.UserRepository;

@Service
public class UserDao {

	UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User addUser(User user) {
		return this.repo.save(user);
	}

	public User findById(Integer userId) {
		return this.repo.findById(userId).get();
	}

	// other methods omitted for brevity
	public void updateUser(User utilisateur) {
		this.repo.save(utilisateur);
	}

	public void deleteUser(User utilisateur) {
		this.repo.delete(utilisateur);
	}

}
