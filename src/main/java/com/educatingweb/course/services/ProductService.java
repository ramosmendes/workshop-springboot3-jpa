package com.educatingweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educatingweb.course.entities.Product;
import com.educatingweb.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return repository.findById(id);

	}
}
