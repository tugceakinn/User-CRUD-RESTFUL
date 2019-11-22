package com.example.restservice.h2.embedded.db.rest.crud.service;


import com.example.restservice.h2.embedded.db.rest.crud.exception.AlreadyExistException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.BadRequestException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.NotFoundException;
import com.example.restservice.h2.embedded.db.rest.crud.model.User;
import com.example.restservice.h2.embedded.db.rest.crud.repository.UserRepository;
import com.example.restservice.h2.embedded.db.rest.crud.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserManager.class);

	@Autowired
	UserRepository userRepository;


	@Override
	public User saveUser(User user) throws AlreadyExistException {
		LOG.debug("[saveUser] User Manager saveUser procces started. Params: user ->{}", user);
		User response = userRepository.findFirstByUsername(user.getUsername());
		if (response == null) {
			response = userRepository.save(user);
		} else {
			throw new AlreadyExistException(Utils.getUsernameAlreadyExistException(user.getUsername()));
		}
		LOG.debug("[saveUser] User Manager saveUser procces finished. Params: response ->{}", response);
		return response;
	}

	@Override
	public User getUser(String userName) throws NotFoundException {
		LOG.debug("[getUser] User Manager saveUser procces started. Params: userName ->{}", userName);
		User response = userRepository.findFirstByUsername(userName);
		if (response == null) {
			throw new NotFoundException(Utils.getUserNotFoundException(userName));
		}
		LOG.debug("[getUser] User Manager saveUser procces finished. Params: response ->{}", response);
		return response;
	}

	@Override
	public User updateUser(String username, User user) throws NotFoundException, BadRequestException {
		LOG.debug("[updateUser] User Manager saveUser procces started. Params: user ->{}", user);
		User response = userRepository.findFirstByUsername(username);
		if (!username.equals(user.getUsername())) {
			throw new BadRequestException("Usernames not matched within Request body and url variable");
		}
		if (response == null) {
			throw new NotFoundException(Utils.getUserNotFoundException(user.getUsername()));
		}
		user.setId(response.getId());
		response = userRepository.save(user);
		LOG.debug("[updateUser] User Manager saveUser procces finished. Params: response ->{}", response);
		return response;
	}

	@Override
	public void deleteUser(String username) throws NotFoundException {
		LOG.debug("[deleteUser] User Manager saveUser procces started. Params: username ->{}", username);
		User user = userRepository.findFirstByUsername(username);
		if (user == null) {
			throw new NotFoundException(Utils.getUserNotFoundException(username));
		}
		userRepository.delete(user);
		LOG.debug("[deleteUser] User Manager saveUser procces finished. deleted user ->{}", user);
	}

	@Override
	public List<User> getAllUser() {
		LOG.debug("[getAllUser] User Manager saveUser procces started.");
		List<User> response = userRepository.findAll();
		LOG.debug("[getAllUser] User Manager saveUser procces finished. Params: response ->{}", response);
		return response;
	}

}
