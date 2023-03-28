package com.educatingweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educatingweb.course.entities.Order;
import com.educatingweb.course.entities.User;
import com.educatingweb.course.entities.enums.OrderStatus;
import com.educatingweb.course.repositories.OrderRepository;
import com.educatingweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail", "50508-1010", "88950061");
		User u2 = new User(null, "Alex Green", "alex@gmail", "50508-1010", "88950061");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), null, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
	}

}
