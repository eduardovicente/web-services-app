package com.vicentem.app.controller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentem.app.controller.exception.UserNotFoundException;
import com.vicentem.app.controller.model.User;
import com.vicentem.app.controller.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers(int page,int limit, String sort) {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUser(Long userId) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
			return userRepository.findById(userId).get();
		}
		throw new UserNotFoundException("User Not Found");
	}

	@Override
	@Transactional
	public User createUser(User userdetails) {
		return userRepository.save(userdetails);
	}

	@Override
	public User updateUser(Long userId, User userdetails) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
			User user = userRepository.findById(userId).get();
			mergeNewValues(user,userdetails);
			return userRepository.save(user);
		}
		throw new UserNotFoundException("User Not Found");
	}

	private void mergeNewValues(User oldUser, User newUser) { //TODO improve this logic
		oldUser.setEmail(newUser.getEmail()!=null?newUser.getEmail():oldUser.getEmail());
		oldUser.setFirstName(newUser.getFirstName()!=null?newUser.getFirstName():oldUser.getFirstName());
		oldUser.setLastName(newUser.getLastName()!=null?newUser.getLastName():oldUser.getLastName());
		oldUser.setPassword(newUser.getPassword()!=null?newUser.getPassword():oldUser.getPassword());
	}

	@Override
	public void deleteUser(Long userId) throws UserNotFoundException{
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return;
		}
		throw new UserNotFoundException("User Not Found");
	}

}
