package com.vicentem.app.controller.service;

import java.util.List;

import com.vicentem.app.controller.exception.UserNotFoundException;
import com.vicentem.app.controller.model.User;

public interface UserService {
	List<User> getUsers(int page, int limit, String sort);
	User getUser(Long userId) throws UserNotFoundException;
	User createUser(User userdetails);
	User updateUser(Long userId, User userdetails) throws UserNotFoundException;
	void deleteUser(Long userId) throws UserNotFoundException;
}
