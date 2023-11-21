package com.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.repository.models.User;
/**
 * User JPA repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
 // Custom queries or methods can be added here
	public User findByEmailAndPassword(String email, String password);
}
