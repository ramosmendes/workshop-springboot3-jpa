package com.educatingweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educatingweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
