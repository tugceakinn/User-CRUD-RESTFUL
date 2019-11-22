package com.example.restservice.h2.embedded.db.rest.crud.controller;


import com.example.restservice.h2.embedded.db.rest.crud.exception.AlreadyExistException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.BadRequestException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.NotFoundException;
import com.example.restservice.h2.embedded.db.rest.crud.model.User;
import com.example.restservice.h2.embedded.db.rest.crud.service.UserManager;
import com.example.restservice.h2.embedded.db.rest.crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserManager.class);

	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/user")
	public List<User> handleGetAllUser() {
		LOG.debug("[handleGetAllUser] User Controller Retrieve All User procces started.");
		List<User> result = userService.getAllUser();
		LOG.debug("[handleGetAllUser] User Manager Retrieve All User procces finished.", result);
		return result;
	}

	@GetMapping(value = "/user/{userId}")
	public User handleGetUser(@PathVariable("userId") String userId) throws NotFoundException {
		LOG.debug("[handleGetUser] User Controller Retrieve User procces started. Params: userId ->{}", userId);
		User result = userService.getUser(userId);
		LOG.debug("[handleGetUser] User Manager Retrieve User procces finished. Params: result ->{}", result);
		return result;
	}

	@PostMapping(value = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User handleSaveUser(@Valid @RequestBody User user) throws AlreadyExistException {
		LOG.debug("[handleSaveUser] User Controller Save User procces started. Params: user ->{}", user);
		User result = userService.saveUser(user);
		LOG.debug("[handleSaveUser] User Manager Save User procces finished. Params: result ->{}", result);
		return result;
	}

	@PutMapping(value = "/user/{username}")
	public User handleUpdateUser(@PathVariable("username") String username, @Valid @RequestBody User user) throws NotFoundException, BadRequestException {
		LOG.debug("[handleUpdateUser] User Controller Update User procces started. Params: user ->{}", user);
		User result = userService.updateUser(username, user);
		LOG.debug("[handleUpdateUser] User Manager Update User procces finished. Params: result ->{}", result);
		return result;
	}

	@DeleteMapping(value = "/user/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDeleteUser(@PathVariable("username") String username) throws NotFoundException {
		LOG.debug("[handleDeleteUser] User Controller Update User procces started. Params: username ->{}", username);
		userService.deleteUser(username);
		LOG.debug("[handleDeleteUser] User Manager Update User procces finished.");

	}
}
