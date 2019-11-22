package com.example.restservice.h2.embedded.db.rest.crud.service;



import com.example.restservice.h2.embedded.db.rest.crud.exception.AlreadyExistException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.BadRequestException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.NotFoundException;
import com.example.restservice.h2.embedded.db.rest.crud.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user) throws AlreadyExistException;

    public User getUser(String userId) throws NotFoundException;

    public User updateUser(String username, User user) throws NotFoundException, BadRequestException;

    public void deleteUser(String username) throws NotFoundException;

    public List<User> getAllUser();

}
