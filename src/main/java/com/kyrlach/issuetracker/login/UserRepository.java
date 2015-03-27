package com.kyrlach.issuetracker.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { 
	User findByUsername(String username);
}
