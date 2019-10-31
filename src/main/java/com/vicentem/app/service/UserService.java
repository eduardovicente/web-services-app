package com.vicentem.app.service;

import java.util.List;

import com.vicentem.app.exception.UserNotFoundException;
import com.vicentem.app.model.User;

public interface UserService {
	List<User> getUsers(int page, int limit, String sort);
	User getUser(Long userId) throws UserNotFoundException;
	User createUser(User userdetails);
	User updateUser(Long userId, User userdetails) throws UserNotFoundException;
	void deleteUser(Long userId) throws UserNotFoundException;
}
