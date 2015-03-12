package com.kyrlach.issuetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kyrlach.issuetracker.login.User;
import com.kyrlach.issuetracker.login.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {

		userRepository.save(new User("Tom", "Test"));
		userRepository.save(new User("Ben", "Secr3t"));
		userRepository.save(new User("Joel", "1234"));
	}
}
