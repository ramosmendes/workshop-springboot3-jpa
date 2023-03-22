package com.educatingweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educatingweb.course.entities.User;
import com.educatingweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail", "50508-1010", "88950061");
		User u2 = new User(null, "Alex Green", "alex@gmail", "50508-1010", "88950061");

		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
