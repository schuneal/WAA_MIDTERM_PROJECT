package edu.mum.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	

	public User findByUsername(String username);
}
