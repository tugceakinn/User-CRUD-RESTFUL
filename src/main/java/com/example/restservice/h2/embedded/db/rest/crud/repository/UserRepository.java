package com.example.restservice.h2.embedded.db.rest.crud.repository;


import com.example.restservice.h2.embedded.db.rest.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findAll();

	User deleteByName(String userName);

	User findFirstByUsername(String userName);
}
