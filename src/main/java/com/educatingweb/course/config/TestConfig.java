package com.educatingweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educatingweb.course.entities.Category;
import com.educatingweb.course.entities.Order;
import com.educatingweb.course.entities.OrderItem;
import com.educatingweb.course.entities.Payment;
import com.educatingweb.course.entities.Product;
import com.educatingweb.course.entities.User;
import com.educatingweb.course.entities.enums.OrderStatus;
import com.educatingweb.course.repositories.CategoryRepository;
import com.educatingweb.course.repositories.OrderItemRepository;
import com.educatingweb.course.repositories.OrderRepository;
import com.educatingweb.course.repositories.ProductRepository;
import com.educatingweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail", "50508-1010", "88950061");
		User u2 = new User(null, "Alex Green", "alex@gmail", "50508-1010", "88950061");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), null, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		Category c1 = new Category(null, "Games");
		Category c2 = new Category(null, "Tools");
		Category c3 = new Category(null, "Films");

		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(c1);
		p2.getCategories().add(c2);
		p3.getCategories().add(c3);
		p4.getCategories().add(c1);
		p5.getCategories().add(c1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2019-07-21T03:42:10Z"), o2);
		o2.setPayment(pay1);
		orderRepository.save(o2);
	}

}
