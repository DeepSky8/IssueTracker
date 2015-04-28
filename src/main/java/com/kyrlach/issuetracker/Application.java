package com.kyrlach.issuetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kyrlach.issuetracker.issue.Issue;
import com.kyrlach.issuetracker.issue.IssueRepository;
import com.kyrlach.issuetracker.login.User;
import com.kyrlach.issuetracker.login.UserRepository;
import com.kyrlach.issuetracker.issue.Stage;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {

		User tom = new User("Tom", "Test");
		User ben = new User("Ben", "Secr3t");
		User joel = new User("Joel", "1234");
		userRepository.save(tom);
		userRepository.save(ben);
		userRepository.save(joel);
		issueRepository.save(new Issue("Purple", "doesn't work", "Feature", 2, tom, Stage.ENTERED));
		issueRepository.save(new Issue("Blue", "too much work", "Problem", 40, ben, Stage.PROGRESSING));
		issueRepository.save(new Issue("Green", "need more", "Enhancement", 5, joel, Stage.REVIEWING));
	}
}
